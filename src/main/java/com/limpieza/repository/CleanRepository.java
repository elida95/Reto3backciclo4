package com.limpieza.repository;

import com.limpieza.model.Clean;
import com.limpieza.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.limpieza.repository.crud.CleanCrudRepository;

/**
 *
 * @author desarrolloextremo
 */
@Repository
public class CleanRepository {

    @Autowired
    private CleanCrudRepository crudInterface;

    public List<Clean> listAll() {
        return crudInterface.findAll();
    }

    public Optional<Clean> getClean(Integer id) {
        return crudInterface.findById(id);
    }

    public Clean create(Clean clothe) {
        return crudInterface.save(clothe);
    }

    public void update(Clean clothe) {
        crudInterface.save(clothe);
    }

    public void delete(Clean clothe) {
        crudInterface.delete(clothe);
    }
}
