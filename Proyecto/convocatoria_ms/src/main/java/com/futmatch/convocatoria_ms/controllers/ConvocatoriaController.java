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

    @GetMapping("/convocatorias/{id}")
    Convocatoria getConvocatoria(@PathVariable String id){
        return convocatoriaRepository.findById(id)
                .orElseThrow(() -> new ConvocatoriaNotFoundException("No se encontro ninguna convocatoria con el id" + id));
    }

    @PostMapping("/convocatorias")
    Convocatoria newConvocatoria(@RequestBody Convocatoria convocatoria){
        return convocatoriaRepository.save(convocatoria);
    }
}
