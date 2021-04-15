
package com.gortiz.AppCinema.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Gustavo
 */
@Entity
public class Calificacion {
    
	@Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    
    /**
     * Constructor por Defecto
     */
    public Calificacion() {
    }

    /**
     * Este constructor incluye todos atributos de la clase Calificacion
     * 
     * @param nombre 
     */
    public Calificacion(String nombre) {
        this.nombre = nombre;
    }

    // A continuación se listan todos los métodos de seteo
    // de cada atributo de la clase

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
}
