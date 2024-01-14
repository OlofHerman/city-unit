package com.intraservice.alpha.repository;

import com.intraservice.alpha.model.CityUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityUnitRepository extends JpaRepository<CityUnit, Long> {
    // List<CityUnit> findAllByCategory(final String category);

    @Query(value = "SELECT city_unit.* FROM city_unit LEFT JOIN category ON city_unit.id = category.city_unit_id WHERE category.name = ?", nativeQuery = true)
    List<CityUnit> listByCategory(final String category);

    List<CityUnit> findAll();
}
