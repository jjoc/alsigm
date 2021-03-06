package com.ieci.tecdoc.common.invesdoc;

import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/** 
 *        @hibernate.class
 *         table="IDOCAPPEVENT"
 *     
*/
public class Idocappevent implements Serializable {

    /** identifier field */
    private int appid;

    /** identifier field */
    private int eventid;

    /** identifier field */
    private int macroid;

    /** full constructor */
    public Idocappevent(int appid, int eventid, int macroid) {
        this.appid = appid;
        this.eventid = eventid;
        this.macroid = macroid;
    }

    /** default constructor */
    public Idocappevent() {
    }

    /** 
     *                @hibernate.property
     *                 column="APPID"
     *                 length="10"
     *             
     */
    public int getAppid() {
        return this.appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    /** 
     *                @hibernate.property
     *                 column="EVENTID"
     *                 length="10"
     *             
     */
    public int getEventid() {
        return this.eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    /** 
     *                @hibernate.property
     *                 column="MACROID"
     *                 length="10"
     *             
     */
    public int getMacroid() {
        return this.macroid;
    }

    public void setMacroid(int macroid) {
        this.macroid = macroid;
    }

    public String toString() {
        return new ToStringBuilder(this)
            .append("appid", getAppid())
            .append("eventid", getEventid())
            .append("macroid", getMacroid())
            .toString();
    }

    public boolean equals(Object other) {
        if ( !(other instanceof Idocappevent) ) return false;
        Idocappevent castOther = (Idocappevent) other;
        return new EqualsBuilder()
            .append(this.getAppid(), castOther.getAppid())
            .append(this.getEventid(), castOther.getEventid())
            .append(this.getMacroid(), castOther.getMacroid())
            .isEquals();
    }

    
         
                                       
//************************************
// Incluido pos ISicres-Common Oracle 9i


public String toXML() {
       String className = getClass().getName();
       className = className.substring(className.lastIndexOf(".") + 1, className.length()).toUpperCase();
       StringBuffer buffer = new StringBuffer();
       buffer.append("<");
       buffer.append(className);
       buffer.append(">");
       try {
           java.lang.reflect.Field[] fields = getClass().getDeclaredFields();
           java.lang.reflect.Field field = null;
           String name = null;
           int size = fields.length;
           for (int i = 0; i < size; i++) {
               field = fields[i];
               name = field.getName();
               buffer.append("<");
               buffer.append(name.toUpperCase());
               buffer.append(">");
               if (field.get(this) != null) {
                   buffer.append(field.get(this));
               }
               buffer.append("</");
               buffer.append(name.toUpperCase());
               buffer.append(">");
           }
       } catch (Exception e) {
           e.printStackTrace(System.err);
       }
       buffer.append("</");
       buffer.append(className);
       buffer.append(">");
       return buffer.toString();
}
                               
//************************************  
                                                                                                                                                                   
public int hashCode() {
      
        return new HashCodeBuilder()
            .append(getAppid())
            .append(getEventid())
            .append(getMacroid())
            .toHashCode();
    }

}
