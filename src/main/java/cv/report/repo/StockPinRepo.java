package cv.report.repo;

import cv.report.entity.StockPin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockPinRepo extends JpaRepository<StockPin,String> {
}
