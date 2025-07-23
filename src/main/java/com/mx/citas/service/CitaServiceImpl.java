package com.mx.citas.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.citas.model.Cita;
import com.mx.citas.repository.CitaInterfaceRepository;

@Service
public class CitaServiceImpl implements CitaInterfaceService {

    @Autowired
    CitaInterfaceRepository repository;

    @Override
    public Cita crearCita(Cita cita) {
         Cita result = null;
        try {
            result = repository.save(cita);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public Cita buscarCita(Cita cita) {
        Cita resultado = null;
        try {
            resultado = repository.findByFecha(cita.getFecha());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }



    @Override
    public Cita actualizarCita(Cita cita, int idCita) {
       Cita guardar = new Cita();
        try {
            boolean recuperado = repository.existsById(idCita);
            if (recuperado == true) {
                guardar.setIdCita(idCita);
                guardar.setNombrePaciente(cita.getNombrePaciente());
                guardar.setTipoEspecialidad(cita.getTipoEspecialidad());
                guardar.setNumeroDeConsultorio(cita.getNumeroDeConsultorio());
                guardar.setFecha(cita.getFecha());
                guardar.setHora(cita.getHora());
                guardar = repository.save(guardar);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return guardar;
    }


    @Override
    public void eliminarCita(int idCita) {
        {
            int id = (int) idCita;
            try{
            repository.deleteById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

@Override 
    public boolean buscarPorId(int id){
            boolean recuperado = false; 
        try {
         recuperado = repository.existsById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return  recuperado;
}

 @Override
    public Cita buscarFecha(Date fecha) {
        Cita recuperado = null;
        try {
            recuperado = repository.findByFecha(fecha);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return recuperado;
    }


}