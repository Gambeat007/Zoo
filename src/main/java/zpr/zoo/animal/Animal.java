package zpr.zoo.animal;

import lombok.*;

import javax.persistence.*;

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

    public Animal() {
    }

    public Animal(String name, String kind, int food, long id) {
        this.name = name;
        this.kind = kind;
        this.food = food;
        this.areaId = areaId;
    }
}
