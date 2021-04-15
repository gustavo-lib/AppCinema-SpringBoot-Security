
package com.gortiz.AppCinema.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Gustavo
 */
@Entity
public class Rol {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    Long id;
    private String nombre;

    /**
     * Constructor por Defecto
     */
    public Rol() {
    }
   
    /**
     * Este constructor incluye todos los atributos de la clase
     * 
     * @param nombre
     */
    public Rol(String nombre) {
        this.nombre = nombre;
    }

    // A continuación se listan todos los métodos 
    // de seteo de cada atributo de la clase
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
