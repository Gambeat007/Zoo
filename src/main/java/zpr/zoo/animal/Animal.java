package zpr.zoo.animal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import zpr.zoo.area.Area;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString

@Entity
@Table(name = "animal")
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "kind")
    private String kind;
    @Column(name = "food")
    private int food;
    @Column(name = "area_id")
    private long areaId;
//    @OneToMany
//    @JoinColumn(name="area_id", nullable = false)
//    private List<Animal> animals = new ArrayList<>();

    public Animal() {
    }

    public Animal(String name, String kind, int food, long areaId) {
        this.name = name;
        this.kind = kind;
        this.food = food;
        this.areaId = areaId;
    }
}
