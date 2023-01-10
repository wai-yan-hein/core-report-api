package cv.report.repo;

import cv.report.entity.ReportTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportTimeRepo extends JpaRepository<ReportTime, String> {
}
