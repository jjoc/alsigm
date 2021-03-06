package xml.config;

import org.apache.commons.lang.StringUtils;

import xml.XMLObject;

import common.Constants;

/**
 * Clase que almacena la información de un campo descriptivo en los ficheros de configuración
 */
public class CampoDescriptivoConfig extends XMLObject
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *  Nombre del campo
	 */
	protected String nombre = null;

	/**
	 *  Valor del campo
	 */
	protected String valor = null;

	/**
	 *  Tipo del campo
	 */
	protected String tipo = null;


	/**
     * Constructor.
     */
    public CampoDescriptivoConfig()
    {
    	super();
    }

	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return el valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor el valor a establecer
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

	/**
	 * @return el tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo el tipo a establecer
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene una representación XML del objeto.
	 * @param indent Número de espacios de tabulación.
	 * @return Representación del objeto.
	 */
	public String toXML(int indent)
	{
		final StringBuffer xml = new StringBuffer();
		final String tabs = StringUtils.repeat("  ", indent);

		xml.append(tabs + "<campo");
	    xml.append(nombre != null ? " nombre=\"" + nombre +"\"" : "");
	    xml.append(valor != null ? " valor=\"" + valor +"\"" : "");
	    xml.append(tipo != null ? " tipo=\"" + tipo +"\"" : "");
	   	xml.append("/>");

		xml.append(Constants.NEWLINE);

		return xml.toString();
	}

}
