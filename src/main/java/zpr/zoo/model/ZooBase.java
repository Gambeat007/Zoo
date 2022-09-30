package zpr.zoo.model;

import lombok.Getter;

import javax.persistence.*;

@Getter
@MappedSuperclass
public abstract class ZooBase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
}
