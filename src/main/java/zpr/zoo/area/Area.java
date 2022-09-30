package zpr.zoo.area;

import lombok.*;
import zpr.zoo.animal.Animal;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString

@Entity
@Table(name = "area")
public class Area {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
