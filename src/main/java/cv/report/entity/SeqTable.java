package cv.report.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "seq_table")
public class SeqTable {
    @EmbeddedId
    private SeqKey key;
    @Column(name = "seq_no")
    private Integer seqNo;
}
