package com.FutMatch.jugador_ms.controllers;

import com.FutMatch.jugador_ms.exceptions.JugadorNotFoundException;
import com.FutMatch.jugador_ms.models.Jugador;
import com.FutMatch.jugador_ms.repositories.JugadorRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class JugadorController {

    private final JugadorRepository jugadorRepository;

    public JugadorController(JugadorRepository jugadorRepository) {
        this.jugadorRepository = jugadorRepository;
    }

    @GetMapping("/jugador/{nombre}")
    Jugador getJugador(@PathVariable String nombre){
        return jugadorRepository.findById(nombre)
                .orElseThrow(() -> new JugadorNotFoundException("No se encontró un jugador con el nombre: " + nombre));
    }

    @PostMapping("/jugador")
    Jugador newJugador(@RequestBody Jugador jugador){
        return jugadorRepository.save(jugador);
    }


}
