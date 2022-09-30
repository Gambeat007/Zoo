package zpr.zoo.animal;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zoo")
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalRepository animalRepository;

    @GetMapping("/animals")
    public ResponseEntity<List<Animal>> getAllAnimals() {
        try {
            return new ResponseEntity<>(animalRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/animals/{name}")
    public ResponseEntity<List<Animal>> findAnimalByName(String name) {
        try {
            List<Animal> animals = animalRepository.findByName(name);
            if (animals.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(animals, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/animals")
    public ResponseEntity<Animal> addAnimal (@RequestBody Animal animal) {
        try {
            Animal _animal = animalRepository.save(new Animal(animal.getName(),
                    animal.getKind(), animal.getFood(), animal.getAreaId()));
            return new ResponseEntity<>(_animal, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
