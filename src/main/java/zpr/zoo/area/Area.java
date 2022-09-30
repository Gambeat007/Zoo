package zpr.zoo.area;

import lombok.*;
import zpr.zoo.animal.Animal;
import zpr.zoo.model.ZooBase;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@ToString

@Entity
@Table(name = "area")
public class Area extends ZooBase {
    @Column(name = "name")
    private String name;

    @OneToMany
    @JoinColumn(name="area_id")
    private List<Animal> animals = new ArrayList<>();

    public Area() {
    }

    public Area(String name) {
        this.name = name;
    }

    public int calculateAnimalsQuantity() {
        return animals.size();
    }

    public int calculateFoodConsumption() {
        return animals
                .stream()
                .mapToInt(Animal::getFood)
                .sum();
    }
}
