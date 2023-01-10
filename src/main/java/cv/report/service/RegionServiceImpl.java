package cv.report.service;

import cv.report.common.Util1;
import cv.report.entity.Region;
import cv.report.repo.RegionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionRepo repo;
    @Autowired
    private SeqService seqService;

    @Override
    public Region save(Region region) {
        if (Util1.isNullOrEmpty(region.getRegCode())) {
            region.setRegCode(getRegCode());
        }
        return repo.save(region);
    }

    @Override
    public boolean checkRegionExist(Region region) {
        return !repo.search(region.getRegName()).isEmpty();
    }

    @Override
    public List<Region> getRegion() {
        return repo.findAll();
    }

    private String getRegCode() {
        int seqNo = seqService.getSeqNo("Region", "-");
        return String.format("%0" + 5 + "d", seqNo);
    }
}
