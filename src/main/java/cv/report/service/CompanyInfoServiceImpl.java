package cv.report.service;

import cv.report.common.Util1;
import cv.report.entity.CompanyInfo;
import cv.report.repo.CompanyInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {
    @Autowired
    private CompanyInfoRepo repo;
    @Autowired
    private SeqService seqService;

    @Override
    public CompanyInfo save(CompanyInfo info) {
        if (Util1.isNullOrEmpty(info.getCompCode())) {
            info.setCompCode(getCompanyCode());
        }
        return repo.save(info);
    }

    @Override
    public boolean existCompany(CompanyInfo info) {
        return !repo.search(info.getCompName()).isEmpty();
    }

    @Override
    public List<CompanyInfo> getCompany() {
        return repo.findAll();
    }

    private String getCompanyCode() {
        int seqNo = seqService.getSeqNo("Company", "-");
        return String.format("%0" + 5 + "d", seqNo);
    }
}
