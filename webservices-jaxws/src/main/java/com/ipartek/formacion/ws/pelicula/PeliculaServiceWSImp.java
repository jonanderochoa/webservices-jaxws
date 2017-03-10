package com.ipartek.formacion.ws.pelicula;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import com.ipartek.formacion.pojo.Pelicula;
import com.ipartek.formacion.service.PeliculaSerciveImp;
import com.ipartek.formacion.service.PeliculaService;

@WebService(serviceName="peliculasservice",
portName="",
targetNamespace="")
@SOAPBinding(use = Use.LITERAL, style = Style.DOCUMENT)
public class PeliculaServiceWSImp {
	
	//Cargamos el contexto del servicio web
	@Resource
	WebServiceContext webServiceContext;

	@WebMethod(operationName="obtenerporid")
	public PeliculaMensaje getById(int codigo){
		PeliculaMensaje pM = new PeliculaMensaje();
		
		if(validarPeticion()){//Si la contraseña es correcta....
			PeliculaService pS = new PeliculaSerciveImp();
			Pelicula pelicula = pS.getById(codigo);
			if(pelicula == null){
				pM.setMensaje("El codigo enviado no corresponde a ninguna pelicula: "+codigo);
			}else{
				pM.setPelicula(pelicula);
			}
		}else{//Si la contraseña NO es correcta....
			pM.setMensaje("La contraseña enviada no es correcta");
		}
		return pM;		
	}
	
	//Valida la contraseña
	private boolean validarPeticion(){
		boolean valida = false;
		//WS-Security
		//Cargamos el contexto de soap
		MessageContext contextoMensajes = webServiceContext.getMessageContext();
		//Recogemos un mapa con todos los encabezados del contexto de la peticion soap
		Map<?, ?> encabezados = (Map<?, ?>) contextoMensajes.get(MessageContext.HTTP_REQUEST_HEADERS);
		//El nombre del atributo del mapa anterior "encabezados" se llama asi porque asi se decide
		//Es una lista porque asi lo decidimos
		List<?> listaDeParametros = (List<?>) encabezados.get("sessionId");
		//VALIDACION
		//Cogeriamos la lista de sesiones activas. Ya lo hicimos con un listener. Lo omitimos para simplificar.
		//ipsession lo enviaria cliente
		String sessionId = "ipsession";
		//Comprobamos que la lista no sea nula
		if(listaDeParametros != null){
			//Aqui hariamos o producuriamos cualquier validacion commpleja (token, algoritmo,...)
			//Porque consume muchos recursos
			if(sessionId.equals(listaDeParametros.get(0).toString())){
				valida = true;
			}
		}
		
		return valida;
	}
	
	@WebMethod(operationName="obtenertodo")
	public PeliculasColection getAll(){
		PeliculasColection coleccion = new PeliculasColection();
		if(validarPeticion()){//Si la contraseña es correcta....
			PeliculaService pS = new PeliculaSerciveImp();
			Set<Pelicula> peliculas = pS.getAll();
			if(peliculas == null){
				coleccion.setMensaje("la lista esta vacia ");
			}else{
				coleccion.setPeliculas(peliculas);
			}
		}else{//Si la contraseña NO es correcta....
			coleccion.setMensaje("La contraseña enviada no es correcta");
		}
		return coleccion;
	}
}
