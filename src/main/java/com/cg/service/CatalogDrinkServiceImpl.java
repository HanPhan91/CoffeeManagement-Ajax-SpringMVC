package com.cg.service;

import com.cg.model.CatalogDrink;
import com.cg.repository.CatalogDrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CatalogDrinkServiceImpl implements CatalogDrinkService {

    @Autowired
    CatalogDrinkRepository catalogDrinkRepository;

    @Override
    public List<CatalogDrink> findAll() {
        return catalogDrinkRepository.findAll();
    }

    @Override
    public Optional<CatalogDrink> findById(Long id) {
        return catalogDrinkRepository.findById(id);
    }

    @Override
    public CatalogDrink getById(Long id) {
        return null;
    }

    @Override
    public CatalogDrink save(CatalogDrink catalogDrink) {
        return catalogDrinkRepository.save(catalogDrink);
    }

    @Override
    public void remove(Long id) {
    }

    @Override
    public void deleteCatalog(Long id) {
        catalogDrinkRepository.deleteCatalog(id);
    }

    @Override
    public void restoreCatalog(Long id) {
        catalogDrinkRepository.restoreCatalog(id);
    }

    @Override
    public List<CatalogDrink> findAllNotDeleted() {
        return catalogDrinkRepository.findAllNotDeleted();
    }

    @Override
    public List<CatalogDrink> findAllDeleted() {
        return catalogDrinkRepository.findAllDeleted();
    }

    @Override
    public void deletedDrinkByCatalog(Long idCatalog) {
        catalogDrinkRepository.deletedDrinkByCatalog(idCatalog);
    }

    @Override
    public void restoreDrinkByCatalog(Long idCatalog) {
        catalogDrinkRepository.restoreDrinkByCatalog(idCatalog);
    }
}
