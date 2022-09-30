package zpr.zoo.area;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
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

    @GetMapping("/areas/id")
    public ResponseEntity<Area> getAllAnimalsFromArea(long area_id) {
        try {
            Area area = areaRepository.findAllAnimalsFromArea(area_id);
            return new ResponseEntity<>(area, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/areas/add")
//    public ResponseEntity<Area> addArea (@RequestBody Area area) {
//        try {
//            Area _area = areaRepository.save(new Area(area.getName()));
//            return new ResponseEntity<>(_area, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
