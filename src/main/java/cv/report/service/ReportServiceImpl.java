package cv.report.service;

import cv.report.dao.AbstractDao;
import cv.report.entity.StockBalance;
import cv.report.entity.StockBalanceKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@Transactional("hibernate")
public class ReportServiceImpl extends AbstractDao<String, String> implements ReportService {

    @Override
    public List<StockBalance> getStockBalance(String compCode) {
        String sql = "select s.*,ifnull(p.pin,0) pin\n" +
                "from stock_balance s\n" +
                "left join stock_pin p \n" +
                "on s.stock_code = p.stock_code\n" +
                "where comp_code = '" + compCode + "'\n" +
                "order by pin desc,user_code,stock_name";
        ResultSet rs = getResultSet(sql);
        List<StockBalance> balances = new ArrayList<>();
        if (!Objects.isNull(rs)) {
            try {
                while (rs.next()) {
                    StockBalance b = new StockBalance();
                    StockBalanceKey key = new StockBalanceKey();
                    key.setStockCode(rs.getString("stock_code"));
                    key.setCompCode(rs.getString("comp_code"));
                    key.setLocCode(rs.getString("loc_code"));
                    b.setKey(key);
                    b.setStockName(rs.getString("stock_name"));
                    b.setLocName(rs.getString("loc_name"));
                    b.setUserCode(rs.getString("user_code"));
                    b.setBalance(rs.getString("balance"));
                    b.setPin(rs.getBoolean("pin"));
                    balances.add(b);
                }
            } catch (SQLException e) {
                log.error(e.getMessage());
            }


        }
        return balances;
    }
}
