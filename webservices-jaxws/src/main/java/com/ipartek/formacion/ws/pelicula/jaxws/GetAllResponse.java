
package com.ipartek.formacion.ws.pelicula.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.ipartek.formacion.ws.pelicula.PeliculasColection;

@XmlRootElement(name = "obtenertodoResponse", namespace = "http://pelicula.ws.formacion.ipartek.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "obtenertodoResponse", namespace = "http://pelicula.ws.formacion.ipartek.com/")
public class GetAllResponse {

    @XmlElement(name = "return", namespace = "")
    private PeliculasColection _return;

    /**
     * 
     * @return
     *     returns PeliculasColection
     */
    public PeliculasColection getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(PeliculasColection _return) {
        this._return = _return;
    }

}
