
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
public class Sexo {
    
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
    private String nombre;

    public Sexo() {
    }

    public Sexo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
