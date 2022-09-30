package zpr.zoo.area;

import lombok.*;

import javax.persistence.*;

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

    public Area() {
    }

    public Area(String name) {
        this.name = name;
    }
}
