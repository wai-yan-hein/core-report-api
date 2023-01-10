package cv.report.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Embeddable
public class UserCompanyKey implements Serializable {
    @ManyToOne
    @JoinColumn(name = "user_code")
    private AppUser user;
    @ManyToOne
    @JoinColumn(name = "comp_code")
    private CompanyInfo companyInfo;
}
