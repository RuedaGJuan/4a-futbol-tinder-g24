package com.futmatch.convocatoria_ms.controllers;

import com.futmatch.convocatoria_ms.models.Convocatoria;
import com.futmatch.convocatoria_ms.repositories.ConvocatoriaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController /*para que esa clase sea un controlador rest, crear vistas para rtas de http*/
public class ConvocatoriaController {

    private final ConvocatoriaRepository convocatoriaRepository;

    public ConvocatoriaController(ConvocatoriaRepository convocatoriaRepository) {
        this.convocatoriaRepository = convocatoriaRepository;
    }

    @GetMapping("/convocatoriaslocalidad/{localidad}")
    List<Convocatoria> convocatoriaByLocalidad(@PathVariable String localidad){
        return convocatoriaRepository.findByLocalidad(localidad);
    }

    @GetMapping("/convocatoriasfecha/{fecha}")
    List<Convocatoria> convocatoriaByFecha(@PathVariable String fecha){
        return convocatoriaRepository.findByFecha(fecha);
    }

    @GetMapping("/convocatorias")
    List<Convocatoria> convocatoriasLista(){
        return convocatoriaRepository.findAll();
    }

    @PostMapping("/convocatoria")
    Convocatoria newConvocatoria(@RequestBody Convocatoria convocatoria){
        return convocatoriaRepository.save(convocatoria);
    }


}
