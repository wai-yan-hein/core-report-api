package cv.report.controller;

import cv.report.common.Response;
import cv.report.common.Util1;
import cv.report.entity.ReportTime;
import cv.report.entity.StockBalance;
import cv.report.entity.StockPin;
import cv.report.repo.ReportTimeRepo;
import cv.report.repo.StockBalanceRepo;
import cv.report.repo.StockPinRepo;
import cv.report.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/api")
public class ReportController {
    @Autowired
    private StockBalanceRepo stockBalanceRepo;
    @Autowired
    private ReportTimeRepo reportTimeRepo;
    @Autowired
    private StockPinRepo stockPinRepo;
    @Autowired
    private ReportService reportService;
    private final Response response = new Response();

    @PostMapping(path = "/save-stock-balance")
    public ResponseEntity<?> saveStockBalance(@RequestBody List<StockBalance> balances) {
        int count = balances.size();
        if (!balances.isEmpty()) {
            stockBalanceRepo.delete(balances.get(0).getKey().getCompCode());
            for (StockBalance b : balances) {
                b.setStockName(Util1.zg12uni51(b.getStockName()));
                stockBalanceRepo.save(b);
                count = count - 1;
                log.info(count + "");
            }
            ReportTime time = new ReportTime();
            time.setRpKey("Stock");
            time.setRpTime(Util1.getTodayDate());
            reportTimeRepo.save(time);
            response.setMessage("Success");
            return ResponseEntity.ok(response);
        }
        return null;
    }

    @GetMapping(path = "/get-stock-balance")
    public ResponseEntity<?> getStockBalance(@RequestParam String compCode) {
        return ResponseEntity.ok(reportService.getStockBalance(compCode));
    }

    @GetMapping(path = "/get-report-time")
    public ResponseEntity<?> getReportTime(@RequestParam String key) {
        return ResponseEntity.ok(reportTimeRepo.findById(key));
    }

    @PostMapping(path = "/save-stock-pin")
    public ResponseEntity<?> savePin(@RequestBody StockPin pin) {
        return ResponseEntity.ok(stockPinRepo.save(pin));
    }

}
