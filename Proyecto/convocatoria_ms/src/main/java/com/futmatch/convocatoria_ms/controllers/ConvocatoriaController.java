package com.futmatch.convocatoria_ms.controllers;

import com.futmatch.convocatoria_ms.exceptions.ConvocatoriaNotFoundException;
import com.futmatch.convocatoria_ms.models.Convocatoria;
import com.futmatch.convocatoria_ms.repositories.ConvocatoriaRepository;
import org.springframework.web.bind.annotation.*;

@RestController /*para que esa clase sea un controlador rest, crear vistas para rtas de http*/
public class ConvocatoriaController {

    private final ConvocatoriaRepository convocatoriaRepository;

    public ConvocatoriaController(ConvocatoriaRepository convocatoriaRepository) {
        this.convocatoriaRepository = convocatoriaRepository;
    }

    @GetMapping("/convocatoriasLocalidad/{localidad}")
    Convocatoria convocatoriaByLocalidad(@PathVariable String localidad){
        return convocatoriaRepository.findById(localidad)
                .orElseThrow(() -> new ConvocatoriaNotFoundException("No se encontró ninguna convocatoria en la localidad" + localidad));
    }

    @GetMapping("/convocatoriasFecha/{fecha}")
    Convocatoria convocatoriaByFecha(@PathVariable String fecha){
        return convocatoriaRepository.findByFecha(fecha);
    }

    @PostMapping("/convocatorias")
    Convocatoria newConvocatoria(@RequestBody Convocatoria convocatoria){
        return convocatoriaRepository.save(convocatoria);
    }


}
