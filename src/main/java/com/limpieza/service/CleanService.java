package com.limpieza.service;

import com.limpieza.model.Clean;
import com.limpieza.repository.CleanRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author desarrolloextremo
 */
@Service
public class CleanService {

    @Autowired
    private CleanRepository repositorio;

    public List<Clean> listAll() {
        return repositorio.listAll();
    }

    public Optional<Clean> getClean(Integer id) {
        return repositorio.getClean(id);
    }

    public Clean create(Clean supplement) {
        if (supplement.getId() == null) {
            return supplement;
        } else {
            return repositorio.create(supplement);
        }
    }

    public Clean update(Clean supplement) {

        if (supplement.getId() != null) {
            Optional<Clean> supplementDb = repositorio.getClean(supplement.getId());
            if (!supplementDb.isEmpty()) {
                if (supplement.getBrand() != null) {
                    supplementDb.get().setBrand(supplement.getBrand());
                }
                if (supplement.getCategory() != null) {
                    supplementDb.get().setCategory(supplement.getCategory());
                }

                if (supplement.getDescription() != null) {
                    supplementDb.get().setDescription(supplement.getDescription());
                }
                if (supplement.getPrice() != 0.0) {
                    supplementDb.get().setPrice(supplement.getPrice());
                }
                if (supplement.getQuantity() != 0) {
                    supplementDb.get().setQuantity(supplement.getQuantity());
                }
                if (supplement.getPhotography() != null) {
                    supplementDb.get().setPhotography(supplement.getPhotography());
                }
                supplementDb.get().setAvailability(supplement.isAvailability());
                repositorio.update(supplementDb.get());
                return supplementDb.get();
            } else {
                return supplement;
            }
        } else {
            return supplement;
        }
    }

    public boolean delete(Integer id) {
        Boolean aBoolean = getClean(id).map(supplement -> {
            repositorio.delete(supplement);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
