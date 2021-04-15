
package com.gortiz.AppCinema.Entity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
///mport java.util.ArraySet;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Gustavo
 */
@Entity
public class Cine {
    
	@Id
    @GeneratedValue
    private String direccion;
    private Date fechaInauguracion;
    private String nombre;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Sala> salas;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<HorarioFuncion> horariosFunciones;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Programacion> programaciones;
    
    private BigDecimal precioEntrada;
    
    /**
     * Constructor por Defecto
     */
    public Cine() {
        salas =new HashSet<> ();//= new ArraySet<>();
        horariosFunciones = new HashSet<> ();//new ArraySet<>();
        programaciones = new HashSet<> ();;//new ArraySet<>();
    }

    /**
     * Este constructor incluye todos los atributos de la clase Cine
     * 
     * @param direccion
     * @param fechaInauguracion
     * @param nombre
     * @param sala
     * @param horariosFunciones
     * @param programaciones
     */
    public Cine(String direccion, Date fechaInauguracion, String nombre, Set<Sala> sala, Set<HorarioFuncion> horariosFunciones, Set<Programacion> programaciones) {
        this.direccion = direccion;
        this.fechaInauguracion = fechaInauguracion;
        this.nombre = nombre;
        this.salas = sala;
        this.horariosFunciones = horariosFunciones;
        this.programaciones = programaciones;
    }
    
    /**
     * Este constructor no incluye los atributos referenciales de la clase Cine
     * 
     * @param direccion
     * @param fechaInauguracion
     * @param nombre 
     * @param precioEntrada 
     */
    public Cine(String direccion, Date fechaInauguracion, String nombre, BigDecimal precioEntrada) {
        this.direccion = direccion;
        this.fechaInauguracion = fechaInauguracion;
        this.nombre = nombre;
        this.precioEntrada = precioEntrada;
        
        // inicializamos las colecciones vacias
        this.salas = new HashSet<> ();
        this.horariosFunciones = new HashSet<> ();//new ArraySet<>();
        this.programaciones = new HashSet<> ();//new ArraySet<>();
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaInauguracion() {
        return fechaInauguracion;
    }

    public void setFechaInauguracion(Date fechaInauguracion) {
        this.fechaInauguracion = fechaInauguracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Sala> getSalas() {
        return salas;
    }

    public void setSalas(Set<Sala> salas) {
        this.salas = salas;
    }

    public Set<HorarioFuncion> getHorariosFunciones() {
        return horariosFunciones;
    }

    public void setHorariosFunciones(Set<HorarioFuncion> horariosFunciones) {
        this.horariosFunciones = horariosFunciones;
    }

    public Set<Programacion> getProgramaciones() {
        return programaciones;
    }

    public void setProgramaciones(Set<Programacion> programaciones) {
        this.programaciones = programaciones;
    }

    public BigDecimal getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(BigDecimal precioEntrada) {
        this.precioEntrada = precioEntrada;
    }
    
    /**
     * Obtenemos la Programacion vigente para este Cine
     * 
     * @return 
     */
    public Programacion obtenerProgramacionVigente () {
        Programacion vigente = null;
        
        Iterator<Programacion> iter = programaciones.iterator();
        while (iter.hasNext()) {
            Programacion p = iter.next();
            
            // si esta vigente la devolvemos
            if (p.estaVigente()) {
                vigente = p;
                break;
            }
        }
        
        return vigente;
    }
 
    /**
     * Devolvemos una represetación textual de Cine
     * 
     * @return 
     */
    @Override
    public String toString () {
        // creamos una instancia del formateador de fechas
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y");
        
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre del Cine: ").append(nombre).append(" - Dirección: ").append(direccion).append("\n");
        sb.append("Fecha Inauguración: ").append(sdf.format(fechaInauguracion)).append(" - Precio de la Entrada: $").append(precioEntrada).append("\n");
        sb.append("Salas: \n");
        
        // iteramos sobre las salas del cine
        Iterator<Sala> salasIt = salas.iterator();
        while (salasIt.hasNext()) {
            // llama automaticamenticamente al método toString() de la Sala
            sb.append(salasIt.next()).append("\n"); 
        }
        
        // iteramos sobre los horarios posibles de las funciones
        Iterator<HorarioFuncion> horariosIt = horariosFunciones.iterator();
        while (horariosIt.hasNext()) {
            // llama automaticamenticamente al método toString() de HorarioFuncion
            sb.append(horariosIt.next()).append("\n");
        }
        
        // agregamos las programacion vigente de este Cine
        sb.append("Programación vigente: \n").append(obtenerProgramacionVigente().toString());
        
        // devolvemos toda la cadena de texto resultante
        return sb.toString();
    }
}
