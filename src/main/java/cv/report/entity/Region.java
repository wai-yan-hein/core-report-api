package cv.report.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "region")
public class Region {
    @Id
    @Column(name = "reg_code")
    private String regCode;
    @Column(name = "reg_name")
    private String regName;
    @Transient
    private String status = "NEW";

}
