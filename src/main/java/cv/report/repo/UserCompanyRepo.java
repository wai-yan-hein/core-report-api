package cv.report.repo;

import cv.report.entity.UserCompany;
import cv.report.entity.UserCompanyKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserCompanyRepo extends JpaRepository<UserCompany, UserCompanyKey> {
    @Query("select o from UserCompany o where o.key.user.userCode = :userCode")
    List<UserCompany> search(@Param("userCode") String userCode);
}
