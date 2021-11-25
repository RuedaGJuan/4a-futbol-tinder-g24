package com.futmatch.convocatoria_ms.repositories;

import com.futmatch.convocatoria_ms.models.Convocatoria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ConvocatoriaRepository extends MongoRepository <Convocatoria, String> { }
