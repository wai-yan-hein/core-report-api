package cv.report.repo;

import cv.report.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RegionRepo extends JpaRepository<Region, String> {
    @Query("select o from Region o where lower(replace(o.regName,' ','')) =lower(replace(:name,' ',''))")
    List<Region> search(@Param(("name")) String name);
}
