package cv.report.repo;

import cv.report.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepo extends JpaRepository<Menu, String> {
}
