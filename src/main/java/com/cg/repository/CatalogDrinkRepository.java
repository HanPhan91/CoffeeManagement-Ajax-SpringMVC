package com.cg.repository;

import com.cg.model.CatalogDrink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CatalogDrinkRepository extends JpaRepository<CatalogDrink, Long> {

    @Modifying
    @Query("UPDATE CatalogDrink c SET c.deleted = true WHERE c.id= :id")
    void deleteCatalog(@Param("id") Long id);

    @Modifying
    @Query("UPDATE CatalogDrink c SET c.deleted = false WHERE c.id= :id")
    void restoreCatalog(@Param("id") Long id);

    @Query("SELECT c FROM CatalogDrink c WHERE c.deleted = false")
    List<CatalogDrink> findAllNotDeleted();

    @Query("SELECT c FROM CatalogDrink c WHERE c.deleted = true")
    List<CatalogDrink> findAllDeleted();

    @Modifying
    @Query("UPDATE Drink d SET d.deleted = true WHERE d.idCatalog= :idCatalog")
    void deletedDrinkByCatalog(@Param("idCatalog") Long idCatalog);

    @Modifying
    @Query("UPDATE Drink d SET d.deleted = false WHERE d.idCatalog= :idCatalog")
    void restoreDrinkByCatalog(@Param("idCatalog") Long idCatalog);
}
