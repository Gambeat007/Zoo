package zpr.zoo.area;

import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface AreaRepository extends JpaRepository<Area, Long> {
    @Query("SELECT area FROM Area area")
    List<Area> findAllAreas();
    @Query("SELECT area FROM Area area WHERE area.id=?1")
    Area findAllAnimalsFromArea(long area_id);
}
