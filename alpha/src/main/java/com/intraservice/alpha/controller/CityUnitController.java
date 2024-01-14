package com.intraservice.alpha.controller;

import com.intraservice.alpha.exception.NotFoundException;
import com.intraservice.alpha.model.CityUnit;
import com.intraservice.alpha.service.CityUnitService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/alpha")
public class CityUnitController {

    private final CityUnitService cityUnitService;

    @GetMapping(path = "/units")
    public ResponseEntity<List<CityUnit>> listUnits(final @RequestParam(value = "category") Optional<String> category) {
        return new ResponseEntity<>(cityUnitService.listCityUnits(category), HttpStatus.OK);
    }

    @GetMapping(path = "/units/{id}")
    public ResponseEntity<CityUnit> findById(final @PathVariable long id) {
        return cityUnitService.findById(id).map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @PatchMapping(path = "/units/{id}")
    public ResponseEntity<CityUnit> updateCityUnit(final @PathVariable long id, final @RequestBody CityUnit patchCityUnit) {
        return cityUnitService.updateCityUnit(id, patchCityUnit).map(ResponseEntity::ok)
                .orElseThrow(() -> new NotFoundException(id));
    }

    @PatchMapping(path = "/units/add-visitors/{visitors}")
    public ResponseEntity<List<CityUnit>> addCityUnitVisitors(final @PathVariable int visitors) {
        return new ResponseEntity<>(cityUnitService.addCityUnitVisitors(visitors), HttpStatus.OK);
    }

}
