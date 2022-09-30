package zpr.zoo.area;

import org.springframework.data.jpa.repository.*;
import zpr.zoo.animal.Animal;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Long> {

    @Query("SELECT area FROM Area area WHERE area.id=?1")
    List<Animal> findById(String name);

}
