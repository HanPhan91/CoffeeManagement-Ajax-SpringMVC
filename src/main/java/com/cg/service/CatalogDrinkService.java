package com.cg.service;

import com.cg.model.CatalogDrink;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CatalogDrinkService extends IGeneralService<CatalogDrink>{
    @Override
    List<CatalogDrink> findAll();

    @Override
    Optional<CatalogDrink> findById(Long id);

    @Override
    CatalogDrink getById(Long id);

    @Override
    CatalogDrink save(CatalogDrink catalogDrink);

    @Override
    void remove(Long id);

    void deleteCatalog(@Param("id") Long id);

    void restoreCatalog(@Param("id") Long id);

    List<CatalogDrink> findAllNotDeleted();

    List<CatalogDrink> findAllDeleted();

    void deletedDrinkByCatalog(@Param("idCatalog") Long idCatalog);

    void restoreDrinkByCatalog(@Param("idCatalog") Long idCatalog);
}
