package com.mx.citas.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="cita")
public class Cita {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name ="id_cita")
    private int idCita;
    @Column(name ="nombre_paciente")
    private String nombrePaciente;
    @Column(name ="tipo_especialidad")
    private String tipoEspecialidad;
    @Column(name ="numero_de_consultorio")
    private int numeroDeConsultorio;
    @Column(name ="fecha")
    private Date fecha;
    @Column(name ="hora")
    private String hora;


    public Cita(){
        
    }


    public Cita(int idCita, String nombrePaciente, String tipoEspecialidad, int numeroDeConsultorio, Date fecha,
            String hora) {
        this.idCita = idCita;
        this.nombrePaciente = nombrePaciente;
        this.tipoEspecialidad = tipoEspecialidad;
        this.numeroDeConsultorio = numeroDeConsultorio;
        this.fecha = fecha;
        this.hora = hora;
    }


    public int getIdCita() {
        return idCita;
    }


    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }


    public String getNombrePaciente() {
        return nombrePaciente;
    }


    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }


    public String getTipoEspecialidad() {
        return tipoEspecialidad;
    }


    public void setTipoEspecialidad(String tipoEspecialidad) {
        this.tipoEspecialidad = tipoEspecialidad;
    }


    public int getNumeroDeConsultorio() {
        return numeroDeConsultorio;
    }


    public void setNumeroDeConsultorio(int numeroDeConsultorio) {
        this.numeroDeConsultorio = numeroDeConsultorio;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public String getHora() {
        return hora;
    }


    public void setHora(String hora) {
        this.hora = hora;
    }

}
