package cv.report.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "stock_balance")
public class StockBalance {
    @EmbeddedId
    private StockBalanceKey key;
    @Column(name = "stock_name")
    private String stockName;
    @Column(name = "balance")
    private String balance;
    @Column(name = "loc_name")
    private String locName;
    @Column(name = "user_code")
    private String userCode;
    @Transient
    private boolean pin;
}
