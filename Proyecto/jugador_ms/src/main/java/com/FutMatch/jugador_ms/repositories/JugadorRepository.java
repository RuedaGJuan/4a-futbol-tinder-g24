package com.FutMatch.jugador_ms.repositories;

import com.FutMatch.jugador_ms.models.Jugador;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JugadorRepository extends MongoRepository <Jugador, String> {
}
