package com.web.proyectocanchasg1.controladores;

import com.web.proyectocanchasg1.modelo.Canchas;
import com.web.proyectocanchasg1.modelo.CanchasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CanchasControlador {

    @Autowired
    CanchasRepository canchasRepository;

    @CrossOrigin
    @PostMapping(value = "/Canchas", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insertarCancha(@RequestParam String nombre,
                                                 @RequestParam int hora_a,
                                                 @RequestParam int hora_c,
                                                 @RequestParam String fecha) throws Exception{
        Canchas cancha = new Canchas(nombre, hora_a, hora_c, fecha);
        canchasRepository.save(cancha);
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>( "{\"respuesta\":\"exito\"}", responseHeaders, HttpStatus.OK );
    }

    @CrossOrigin
    @GetMapping(value = "/Canchas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<String> getCanchas(@PathVariable Long id  ) throws Exception{
        Canchas cancha = canchasRepository.findById(id).get();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(cancha.toJSON().toString(), responseHeaders, HttpStatus.OK );
    }

    @CrossOrigin
    @GetMapping(value = "/Canchas/nombre_canchas/{nombre_canchas}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getFromNameCanchas(@PathVariable String nombre_canchas) throws Exception{
        List<Canchas> c = canchasRepository.findByName(nombre_canchas);
        String resCanchas = c.toString();
        HttpHeaders responseHeaders = new HttpHeaders();
        return  new ResponseEntity<String>(resCanchas, responseHeaders, HttpStatus.OK );
    }
}
