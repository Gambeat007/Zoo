package zpr.zoo.animal;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(AnimalController.class)
public class AnimalControllerTests {
    @MockBean
    private AnimalRepository animalRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnListOfAnimals() throws Exception {
        List<Animal> animals = new ArrayList<>(Arrays.asList(
                new Animal("Meow", "Regular cat", 7, 3),
                new Animal("Woem", "Reverse cat", 7, 3)));

        when(animalRepository.findAll()).thenReturn(animals);
        mockMvc.perform(get("/zoo/animals"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(animals.size()))
                .andDo(print());
    }

    @Test
    void shouldReturnAnimalsFiltered() throws Exception {
        List<Animal> animals = new ArrayList<>(Arrays.asList(
                new Animal("M", "Cat", 7, 3),
                new Animal("W", "Cat", 7, 3)));

        String name = "Meow";
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("name", name);

        when(animalRepository.findByName(name)).thenReturn(animals);
        mockMvc.perform(get("/zoo/animals/name").params(map))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(animals.size()))
                .andDo(print());

        animals = Collections.emptyList();

        when(animalRepository.findByName(name)).thenReturn(animals);
        mockMvc.perform(get("/zoo/animals/name").params(map))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
    void shouldAddAnimal() throws Exception {
        Animal animal = new Animal("Meow", "Regular cat", 7, 3);

        mockMvc.perform(post("/zoo/animals").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(animal)))
                .andExpect(status().isCreated())
                .andDo(print());
    }
}
