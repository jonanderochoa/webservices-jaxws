package com.ipartek.formacion.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.ipartek.formacion.pojo.Coche;


@WebService(targetNamespace="http://com.ipartek.formacion/types", name = "cochews")
@SOAPBinding(use=Use.LITERAL, style=Style.RPC)//Tipo de servicio web que nos publica
public interface CocheServiceWS {
	
	@WebMethod
	@ResponseWrapper(targetNamespace="http://com.ipartek.formacion/types", 
			className="com.ipartek.formacion.ws.CocheColeccion")//Mapeamos la respuesta
	public CocheColeccion getAll();
	
	@WebMethod
	@ResponseWrapper(targetNamespace="http://com.ipartek.formacion/types", 
	className="com.ipartek.formacion.pojo.Coche")//Mapeamos la peticion
	@RequestWrapper()
	public Coche getById(@WebParam(targetNamespace="http://com.ipartek.formacion/types", 
	mode=Mode.IN, name = "codigocoche") Integer codigo); //Ponemos integer porque queremos que pueda ser nulo
}
