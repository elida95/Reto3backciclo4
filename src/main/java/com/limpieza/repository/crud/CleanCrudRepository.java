package com.limpieza.repository.crud;

import com.limpieza.model.Clean;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author desarrolloextremo
 */
public interface CleanCrudRepository extends MongoRepository<Clean, Integer> {
    
}
