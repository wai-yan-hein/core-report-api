package cv.report.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "map_user_company")
public class UserCompany {
    @EmbeddedId
    private UserCompanyKey key;
    @Column(name = "active")
    private boolean active;
}
