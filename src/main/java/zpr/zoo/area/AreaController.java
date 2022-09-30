package zpr.zoo.area;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import zpr.zoo.model.Area;

import java.util.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AreaController {
    private final AreaRepository areaRepository;

    @GetMapping("/areas")
    public ResponseEntity<List<Area>> getAllAreas() {
        try {
            return new ResponseEntity<>(areaRepository.findAllAreas(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/areas/id")
    public ResponseEntity<Area> getAllAnimalsFromArea(long area_id) {
        try {
            Area area = areaRepository.findAllAnimalsFromArea(area_id);
            return new ResponseEntity<>(area, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/areas/leastPopulated")
    public ResponseEntity<Area> getLeastPopulatedArea() {
        try {
            return new ResponseEntity<>(areaRepository.findAllAreas()
                .stream()
                .min(Comparator.comparing(Area::calculateAnimalsQuantity))
                .orElseThrow(),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/areas/greatestFoodConsumption")
    public ResponseEntity<Area> getAreaOfGreatestFoodConsumption() {
        try {
            return new ResponseEntity<>(areaRepository.findAllAreas()
                    .stream()
                    .max(Comparator.comparing(Area::calculateFoodConsumption))
                    .orElseThrow(),
                        HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/areas")
    public ResponseEntity<Area> addArea(@RequestBody Area area) {
        try {
            Area _area = areaRepository.save(new Area(area.getName()));
            return new ResponseEntity<>(_area, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
