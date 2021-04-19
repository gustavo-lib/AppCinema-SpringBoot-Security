
package com.gortiz.AppCinema.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.gortiz.AppCinema.Enum.RolNombre;

/**
 *
 * @author Gustavo
 */
import com.sun.istack.NotNull;
//import com.gortiz.AppCinema.Security.;

import javax.persistence.*;

@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@NotNull
    @Enumerated(EnumType.STRING)
    @Column(unique = true)
    private RolNombre rolNombre;

    public Rol() {
    }
    
    

    public Rol(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolNombre getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(RolNombre rolNombre) {
        this.rolNombre = rolNombre;
    }
    
    @Override
	public String toString() {
		return " ######### Rol ######## [id=" + 2 + ", rolNombre=" + rolNombre + "]";
	}

}