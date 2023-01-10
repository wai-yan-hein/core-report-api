package cv.report.service;

import cv.report.entity.StockBalance;

import java.util.List;

public interface ReportService {
    List<StockBalance> getStockBalance(String compCode);
}
