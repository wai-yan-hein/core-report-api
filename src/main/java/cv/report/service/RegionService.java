package cv.report.service;

import cv.report.entity.Region;

import java.util.List;

public interface RegionService {
    Region save(Region region);

    boolean checkRegionExist(Region region);

    List<Region> getRegion();
}
