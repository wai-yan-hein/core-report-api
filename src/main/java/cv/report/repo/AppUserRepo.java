package cv.report.repo;

import cv.report.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AppUserRepo extends JpaRepository<AppUser, String> {
    @Query("select o from AppUser o where lower(replace(o.shortName,' ','')) =lower(replace(:name,' ',''))")
    List<AppUser> search(@Param(("name")) String name);

    @Query("select o from AppUser o where lower(replace(o.shortName,' ','')) =lower(replace(:name,' ','')) and o.password = :password")
    List<AppUser> login(@Param("name") String name, @Param("password") String password);

}
