package ieci.tdw.ispac.ispaccatalog.action.pcdsyncnode;

import ieci.tdw.ispac.api.IInvesflowAPI;
import ieci.tdw.ispac.api.IProcedureAPI;
import ieci.tdw.ispac.api.ISecurityAPI;
import ieci.tdw.ispac.api.impl.SessionAPI;
import ieci.tdw.ispac.ispaccatalog.action.BaseAction;
import ieci.tdw.ispac.ispaccatalog.action.procedure.ManageVistaCuadroProcedimientoAction;
import ieci.tdw.ispac.ispaccatalog.helpers.FunctionHelper;
import ieci.tdw.ispac.ispaclib.bean.TreeNode;
import ieci.tdw.ispac.ispaclib.bean.TreeView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Action para eliminar un nodo de sincronizaci�n del procedimiento.
 */
public class RemovePcdSyncNodeAction extends BaseAction {

    public ActionForward executeAction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response,
            SessionAPI session) throws Exception {

 		// Comprobar si el usuario tiene asignadas las funciones adecuadas
		FunctionHelper.checkFunctions(request, session.getClientContext(), new int[] {
				ISecurityAPI.FUNC_INV_PROCEDURES_EDIT });

		IInvesflowAPI invesFlowAPI = session.getAPI();
		IProcedureAPI procedureAPI = invesFlowAPI.getProcedureAPI();

		// Identificador del procedimiento
		int pcdId = Integer.parseInt(request.getParameter("pcdId"));

		// Identificador del nodo de sincronizaci�n
		int syncnodeId = Integer.parseInt(request.getParameter("syncnodeId"));
		
		// Eliminar la fase
		procedureAPI.removeSyncNode(pcdId, syncnodeId);
		
		// Actualizar el �rbol del procedimiento
		TreeView tree = (TreeView)request.getSession().getAttribute(
				ManageVistaCuadroProcedimientoAction.CUADRO_PROCEDIMIENTO);
		if (tree != null) {
			
			// Seleccionar el nodo padre en el �rbol
			TreeNode parent = tree.getSelectedNode().getParent();
			tree.setSelectedNode(parent);
			parent.refresh();
			return mapping.findForward("showTreeProc");
		}

		// Refrescar la pantalla principal
		request.setAttribute("Refresh", "true");
		
		return mapping.findForward("showTreeProc");
	}
}
