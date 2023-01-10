package cv.report.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class SeqKey implements Serializable {
    @Column(name = "seq_type")
    private String seqType;
    @Column(name = "period")
    private String period;

    public SeqKey() {
    }

    public SeqKey(String seqType, String period) {
        this.seqType = seqType;
        this.period = period;
    }
}
