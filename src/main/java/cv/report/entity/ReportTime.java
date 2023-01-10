package cv.report.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "report_time")
public class ReportTime {
    @Id
    @Column(name = "rp_key")
    private String rpKey;
    @Column(name = "rp_time")
    private Date rpTime;
}
