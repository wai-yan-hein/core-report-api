package cv.report.service;

import cv.report.entity.CompanyInfo;

import java.util.List;

public interface CompanyInfoService {
    CompanyInfo save(CompanyInfo info);

    boolean existCompany(CompanyInfo info);

    List<CompanyInfo> getCompany();
}
