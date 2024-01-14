package com.intraservice.alpha.service;

import com.intraservice.alpha.model.CityUnit;
import com.intraservice.alpha.repository.CategoryRepository;
import com.intraservice.alpha.repository.CityUnitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityUnitService {

    private final CityUnitRepository cityUnitRepository;
    private final CategoryRepository categoryRepository;

    public List<CityUnit> listCityUnits(Optional<String> category) {
        if (category.isPresent()) {
            return cityUnitRepository.listByCategory(category.get());
        } else {
            return cityUnitRepository.findAll();
        }
    }

    public Optional<CityUnit> findById(final long id) {
        return cityUnitRepository.findById(id);
    }

    public Optional<CityUnit> updateCityUnit(final long id, final CityUnit cityUnit) {
        Optional<CityUnit> maybeCityUnit = cityUnitRepository.findById(id);
        maybeCityUnit.ifPresent(unit -> cityUnitRepository.save(
            CityUnit.builder()
                .id(unit.getId())
                .name(cityUnit.getName() != null ? cityUnit.getName() : unit.getName())
                .address(cityUnit.getAddress() != null ? cityUnit.getAddress() : unit.getAddress())
                .visitors(cityUnit.getVisitors() != 0 ? cityUnit.getVisitors() : unit.getVisitors())
                .build()));

        return maybeCityUnit;
    }

    public List<CityUnit> addCityUnitVisitors(final int visitors) {
        List<CityUnit> cityUnits = cityUnitRepository.findAll();
        for (CityUnit cityUnit : cityUnits) {
            cityUnit.setVisitors(cityUnit.getVisitors() + visitors);
            cityUnitRepository.save(cityUnit);
        }

        return cityUnits;
    }
}
