package zpr.zoo.area;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import zpr.zoo.animal.Animal;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api")
public class AreaController {

    private final AreaRepository areaRepository;

    @GetMapping("/areas")
    public ResponseEntity<List<Area>> getAllAreas() {
        try {
            return new ResponseEntity<>(areaRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/areas/id")
//    public ResponseEntity<Optional<Area>> getAllAnimalsInArea (Long id) {
//        try {
//            Optional<Area> area = areaRepository.findById(id);
////            if (area.isEmpty()) {
////                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
////            }
//            return new ResponseEntity<>(area, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/areas/add")
    public ResponseEntity<Area> addArea (@RequestBody Area area) {
        try {
            Area _area = areaRepository.save(new Area(area.getName()));
            return new ResponseEntity<>(_area, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
