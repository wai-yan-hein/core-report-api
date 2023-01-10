package cv.report.repo;

import cv.report.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyInfoRepo extends JpaRepository<CompanyInfo, String> {
    @Query("select o from CompanyInfo o where lower(replace(o.compName,' ','')) =lower(replace(:name,' ',''))")
    List<CompanyInfo> search(@Param(("name")) String name);
}
