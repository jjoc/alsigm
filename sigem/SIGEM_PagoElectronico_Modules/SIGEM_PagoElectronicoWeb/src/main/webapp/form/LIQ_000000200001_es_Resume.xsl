<?xml version="1.0" encoding="utf-8"?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:import href="LIQ_000000200001_Resume_template.xsl" />
<xsl:output encoding="ISO-8859-1" method="html"/>
<xsl:variable name="lang.fechaDevengo" select="'Fecha de Devengo'"/>
<xsl:variable name="lang.emisora" select="'Emisora'"/>
<xsl:variable name="lang.modalidad" select="'Modalidad'"/>
<xsl:variable name="lang.modelo" select="'Modelo'"/>
<xsl:variable name="lang.referencia" select="'Referencia'"/>
<xsl:variable name="lang.concepto" select="'Concepto'"/>
<xsl:variable name="lang.ayuntamiento" select="'Ayuntamiento'"/>
<xsl:variable name="lang.desc" select="'Descripción'"/>
<xsl:variable name="lang.nif" select="'N.I.F. / C.I.F'"/>
<xsl:variable name="lang.nombre" select="'Apellidos y Nombre / Razón Social'"/>
<xsl:variable name="lang.especifico" select="'Dato Especifico'"/>
<xsl:variable name="lang.importe" select="'Importe'"/>
<xsl:variable name="lang.medio" select="'Medio Pago'"/>
<xsl:variable name="lang.medio1" select="'Cargo en cuenta'"/>
<xsl:variable name="lang.medio2" select="'Pago con tarjeta'"/>
<xsl:variable name="lang.entidadFinanciera" select="'Entidad Financiera'"/>
<xsl:variable name="lang.ccc" select="'Código Cuenta Cliente'"/>
<xsl:variable name="lang.numeroTarjeta" select="'Número Tarjeta Crédito'"/>
<xsl:variable name="lang.fechaTarjeta" select="'Fecha de Caducidad'"/>
<xsl:variable name="lang.mensaje01" select="'Formato de fecha incorrecto. El formato correcto es 12/12/2000.'"/>
<xsl:variable name="lang.mensaje02" select="'Formato de importe incorrecto. El formato correcto es 1500,90'"/>
<xsl:variable name="lang.mensaje03" select="'Formato incorrecto. '"/>
<xsl:variable name="lang.mensaje04" select="'debe ser un valor númerico. '"/>
<xsl:variable name="lang.mensaje05" select="'Debe indicar una fecha de devengo.'"/>
<xsl:variable name="lang.mensaje06" select="'Debe indicar los datos específicos.'"/>
<xsl:variable name="lang.mensaje07" select="'Debe indicar el importe.'"/>
<xsl:variable name="lang.mensaje08" select="'Debe introducir un número de cuenta corriente.'"/>
<xsl:variable name="lang.mensaje09" select="'El número de cuenta debe tener 20 dígitos.'"/>
<xsl:variable name="lang.mensaje10" select="'El número de tarjeta debe tener 16 dígitos.'"/>
<xsl:variable name="lang.mensaje11" select="'Debe introducir la fecha de caducidad de la tarjeta.'"/>
<xsl:variable name="lang.mensaje12" select="'La fecha de caducidad de la tarjeta debe tener 4 dígitos.'"/></xsl:stylesheet>