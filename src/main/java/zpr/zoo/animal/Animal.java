package zpr.zoo.animal;

import lombok.*;
import zpr.zoo.model.ZooBase;

import javax.persistence.*;

@Getter
@Setter
@ToString

@Entity
@Table(name = "animal")
public class Animal extends ZooBase {
    @Column(name = "name")
    private String name;
    @Column(name = "kind")
    private String kind;
    @Column(name = "food")
    private int food;
    @Column(name = "area_id")
    private long areaId;

    public Animal() {
    }

    public Animal(String name, String kind, int food, long areaId) {
        this.name = name;
        this.kind = kind;
        this.food = food;
        this.areaId = areaId;
    }
}
