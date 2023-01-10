package cv.report.repo;

import cv.report.entity.StockBalance;
import cv.report.entity.StockBalanceKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface StockBalanceRepo extends JpaRepository<StockBalance, StockBalanceKey> {
    @Query("select o from StockBalance o where o.key.compCode = :compCode order by o.userCode")
    List<StockBalance> search(@Param("compCode") String compCode);

    @Transactional
    @Modifying
    @Query("delete from StockBalance o where o.key.compCode = :compCode")
    void delete(@Param("compCode") String compCode);
}
