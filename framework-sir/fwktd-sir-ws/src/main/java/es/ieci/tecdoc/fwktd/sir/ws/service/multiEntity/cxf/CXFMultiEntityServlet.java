package es.ieci.tecdoc.fwktd.sir.ws.service.multiEntity.cxf;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletConfig;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * Basada en implementacion Cxf 2.5.2  {@link org.apache.cxf.transport.servlet.CXFServlet}
 * @author IECISA
 *
 */
public class CXFMultiEntityServlet extends CXFMultiEntityNonSpringServlet{
    private boolean busCreated;
    private XmlWebApplicationContext createdContext; 
    
    public CXFMultiEntityServlet() {
    }

    @Override
    protected void loadBus(ServletConfig sc) {
        ApplicationContext wac = WebApplicationContextUtils.
            getWebApplicationContext(sc.getServletContext());
        String configLocation = sc.getInitParameter("config-location");
        if (configLocation == null) {
            try {
                InputStream is = sc.getServletContext().getResourceAsStream("/WEB-INF/cxf-servlet.xml");
                if (is != null && is.available() > 0) {
                    is.close();
                    configLocation = "/WEB-INF/cxf-servlet.xml";
                }
            } catch (Exception ex) {
                //ignore
            }
        }
        if (configLocation != null) {
            wac = createSpringContext(wac, sc, configLocation);
        }
        if (wac != null) {
            setBus(wac.getBean("cxf", Bus.class));
        } else {
            busCreated = true;
            setBus(BusFactory.newInstance().createBus());
        }
    }

    /**
     * Try to create a spring application context from the config location.
     * Will first try to resolve the location using the servlet context.
     * If that does not work then the location is given as is to spring
     * 
     * @param ctx
     * @param sc
     * @param configLocation
     * @return
     */
    private ApplicationContext createSpringContext(ApplicationContext ctx,
                                                   ServletConfig sc,
                                                   String location) {
        XmlWebApplicationContext ctx2 = new XmlWebApplicationContext();
        createdContext = ctx2;
        ctx2.setServletConfig(sc);

        Resource r = ctx2.getResource(location);
        try {
            InputStream in = r.getInputStream();
            in.close();
        } catch (IOException e) {
            //ignore
            r = ctx2.getResource("classpath:" + location);
            try {
                r.getInputStream().close();
            } catch (IOException e2) {
                //ignore
                r = null;
            }
        }
        try {
            if (r != null) {
                location = r.getURL().toExternalForm();
            }
        } catch (IOException e) {
            //ignore
        }        
        if (ctx != null) {
            ctx2.setParent(ctx);
            String names[] = ctx.getBeanNamesForType(Bus.class);
            if (names == null || names.length == 0) {
                ctx2.setConfigLocations(new String[] {"classpath:/META-INF/cxf/cxf.xml",
                                                      location});                
            } else {
                ctx2.setConfigLocations(new String[] {location});                                
            }
        } else {
            ctx2.setConfigLocations(new String[] {"classpath:/META-INF/cxf/cxf.xml",
                                                  location});
            createdContext = ctx2;
        }
        ctx2.refresh();
        return ctx2;
    }
    public void destroyBus() {
        if (busCreated) {
            //if we created the Bus, we need to destroy it.  Otherwise, spring will handleit.
            getBus().shutdown(true);
        }
        if (createdContext != null) {
            createdContext.close();
        }
    }
}