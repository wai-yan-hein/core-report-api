package cv.report.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "company_info")
public class CompanyInfo {
    @Id
    @Column(name = "comp_code")
    private String compCode;
    @Column(name = "comp_name")
    private String compName;
    @Column(name = "active")
    private boolean active;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @NonNull
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;
    @ManyToOne
    @JoinColumn(name = "reg_code")
    private Region region;
    @Transient
    private String status = "NEW";

    public CompanyInfo() {
    }
}
