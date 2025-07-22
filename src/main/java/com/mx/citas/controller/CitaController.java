package com.mx.citas.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mx.citas.model.Cita;
import com.mx.citas.service.CitaInterfaceService;

@RestController
public class CitaController {

    @Autowired
    CitaInterfaceService service;

    @PostMapping(value = "/crearCita")
    public ResponseEntity<?> crearCita(@RequestBody Cita cita) {
        Cita recuperado = service.buscarFecha(cita.getFecha());
        if (recuperado == null) {
            service.crearCita(cita);
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("exito", "La cita se a guardado correctamente"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "La cita ya se encuentra registrada"));
    }

    @PostMapping(value = "/buscarCita")
    public ResponseEntity<?> buscarCita(@RequestBody Cita cita) {
        Cita buscar = service.buscarFecha(cita.getFecha());
        if (buscar != null) {
            return ResponseEntity.status(HttpStatus.OK).body(buscar);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "servicio no encontrado"));

    }

    @PutMapping(value = "/actualizarCita/{idCita}")
    public ResponseEntity<?> actualizarCita(@RequestBody Cita cita, @PathVariable int idCita) {
        boolean recuperado = service.buscarPorId(idCita);
        if (recuperado == true) {
            service.actualizarCita(cita, idCita);
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("exito", "La cita se a actualizado correctamente"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "Cita no encontrada"));

    }

    @DeleteMapping(value = "/eliminarCita/{idCita}")
    public ResponseEntity<?> eliminarCita(@PathVariable int idCita) {
        boolean recuperado = service.buscarPorId(idCita);
        if (recuperado == true) {
            service.eliminarCita(idCita);
            return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonMap("exito", "La cita se a eliminado correctamente"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "Cita no encontrada"));
    }
}
