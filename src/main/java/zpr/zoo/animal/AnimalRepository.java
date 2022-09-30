package zpr.zoo.animal;

import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("SELECT animal FROM Animal animal WHERE animal.name=?1")
    List<Animal> findByName(String name);
}
