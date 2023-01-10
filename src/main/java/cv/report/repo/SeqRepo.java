package cv.report.repo;

import cv.report.entity.SeqKey;
import cv.report.entity.SeqTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeqRepo extends JpaRepository<SeqTable, SeqKey> {
}
