package ieci.tecdoc.sgm.registro.util;
import ieci.tecdoc.sgm.base.xml.lite.XmlTextBuilder;

import java.io.Serializable;

/**
 * Bean con la informaci�n de una solicitud de registro.
 * 
 * @author IECISA
 *
 */
public class RegistroPeticion implements Serializable
{
   protected String procedureId;  // Identificador de tr�mite.
   protected String addressee;    // El destino a veces puede ser modificado seg�n la elecci�n del ciudadano.
   protected String folderId;     // N�mero de expediente.
   protected String email;		  // Correo electr�nico
   protected String specificData; // Datos espec�ficos.
   protected String senderIdType; // Tipo de documento de identidad
   protected PeticionDocumentos documents;   // Documentos.
   
   /**
    * Constructor de la clase RegistroPeticion
    *
    */
   public RegistroPeticion()
   {
      procedureId = null;
      addressee = null;
      email = null;
      folderId = null;
      specificData = null;
      senderIdType = null;
      documents = new PeticionDocumentos();
   }
   
   /**
    * Establece el identificador del tr�mite.
    * @param procedureId Identificador del tr�mite.
    */   
   public void setProcedureId(String procedureId)
   {
      this.procedureId = procedureId;
   }
   
   /**
    * Establece el organismo destintario del registro.
    * @param addressee Identificador del organismo destinatario del registro.
    */   
   public void setAddressee(String addressee)
   {
      this.addressee = addressee;
   }
   
   
   /**
    * Estable el correo electr�nico del ciudadano
    * @param email Correo electr�nico del ciudadano.
    */
   public void setEmail(String email) {
      this.email = email;
   }
   
   /**
    * Establece el n�mero de expediente de la solicitud.
    * @param folderId N�mero de expediente de la solicitud.
    */   
   public void setFolderId(String folderId)
   {
   	this.folderId = folderId;
   }
   
   /**
    * Establece informaci�n adicional para el registro.
    * @param specificData Informaci�n adicional para el registro.
    */   
   public void setSpecificData(String specificData)
   {
      this.specificData = specificData;
   }
   
   /**
    * Establece el tipo de identificaci�n del ciudadano.
    * @param senderIdType Tipo de identificaci�n del ciudadano.
    */   
   public void setSenderIdType(String senderIdType) {
	  this.senderIdType = senderIdType;
   }
   
   /**
    * Establece los documentos anexos a la solicitud de registro.
    * @param documents Documentos anexos a la solicitud.
    */   
   public void setDocuments(PeticionDocumentos documents)
   {
      this.documents = documents;
   }
   
   /**
    * Devuelve el identificador del procedimiento.
    * @return String Identificador del procedimiento.
    */   
   public String getProcedureId()
   {
      return procedureId;
   }

   /**
    * Devuelve el identificador el organismo destinatario del registro.
    * @return String Identificador del organismo destinatario de registro.
    */
   public String getAddressee()
   {
      return addressee;
   }
   
   /**
    * Devuelve el correo electr�nico del ciudadano
    * @return String Correo electr�nico del ciudadano.
    */
   public String getEmail() {
      return email;
   }
   
   /**
    * Devuelve el n�mero de expediente asociado a la solicitud.
    * @return String N�mero de expediente.
    */   
   public String getFolderId()
   {
      return folderId;
   }
   
   /**
    * Devuelve la informaci�n adicional de la solicitud de registro.
    * @return String Informaci�n adicional de la solicitud.
    */   
   public String getSpecificData()
   {
      return specificData;
   }

   /**
    * Devuelve el tipo de identificaci�n del ciudadano.
    * @return String Tipo de identificaci�n del ciudadano.
    */
   public String getSenderIdType() {
   	return senderIdType;
   }

   /**
    * Devuelve los documentos anexos a la solicitud.
    * @return RequestDocuments Documentos anexos a la solicitud.
    */
   public PeticionDocumentos getDocuments()
   {
      return documents;
   }

   /**
    * Devuelve una cadena XML con los datos de la solicitud de registro.
    * @param headline Indica si el XML debe llevar cabecera.
    * @return String Cadena XML con los datos de la solicitud de registro.
    */
   public String toXML(boolean headline) 
   {
      XmlTextBuilder bdr;
      String tagName = "Registry_Request";
      
      bdr = new XmlTextBuilder();
      if (headline)
         bdr.setStandardHeader();

      bdr.addOpeningTag(tagName);
      
      bdr.addSimpleElement("ProcedureId", procedureId);
      bdr.addSimpleElement("Addresse", addressee);
      bdr.addSimpleElement("SenderId_Type", senderIdType);
      bdr.addSimpleElement("Specific_Data", specificData);
      
      bdr.addFragment(documents.toXML(false));

      bdr.addClosingTag(tagName);
      
      return bdr.getText();
   }

   /**
    * Devuelve una cadena con los datos de la solicitud de registro.
    * @return String Cadena XML con los datos de la solicitud de registro.
    */
	public String toString()
	{
      return toXML(false);
   }
}