package com.gortiz.AppCinema.Entity;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Gustavo
 */
@Entity
public class Actor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
    private boolean animado;
	
    private String apellido;
	
    private String nombre;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn//(name="")
    private Sexo sexo;

    /**
     * Constructor por Defecto
     */
    public Actor() {
    }
    
    /**
     * Este constructor incluye todos los atributos de la clase Personaje
     * 
     * @param animado
     * @param apellido
     * @param nombre
     * @param sexo 
     */
    public Actor(boolean animado, String apellido, String nombre, Sexo sexo) {
        this.animado = animado;
        this.apellido = apellido;
        this.nombre = nombre;
        this.sexo = sexo;
    }
    
    //A continuación se listan todos los métodos de seteo de cada atributo de la clase.
    public boolean isAnimado() {
        return animado;
    }

    public void setAnimado(boolean animado) {
        this.animado = animado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
    
}
