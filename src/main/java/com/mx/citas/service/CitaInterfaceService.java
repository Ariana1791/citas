package com.mx.citas.service;

import java.util.Date;

import com.mx.citas.model.Cita;

public interface CitaInterfaceService {

    Cita crearCita(Cita cita);

    Cita buscarCita(Cita cita);

    Cita actualizarCita(Cita cita, int idCita);

    void eliminarCita(int idCita);

    boolean buscarPorId(int Id);
    
    Cita buscarFecha(Date fecha);
}
