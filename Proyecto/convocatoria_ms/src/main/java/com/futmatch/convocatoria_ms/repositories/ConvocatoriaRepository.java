package com.futmatch.convocatoria_ms.repositories;

import com.futmatch.convocatoria_ms.models.Convocatoria;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface ConvocatoriaRepository extends MongoRepository <Convocatoria, String> {
    List<Convocatoria> findByFecha(String fecha);
    List<Convocatoria> findByLocalidad(String localidad);
}
