package cv.report.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "stock_pin")
public class StockPin {
    @Id
    @Column(name = "stock_code")
    private String stockCode;
    @Column(name = "pin")
    private boolean pin;

    public StockPin(String stockCode, boolean pin) {
        this.stockCode = stockCode;
        this.pin = pin;
    }

    public StockPin() {
    }
}
