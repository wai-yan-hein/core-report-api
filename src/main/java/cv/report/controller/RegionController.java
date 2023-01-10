package cv.report.controller;

import cv.report.common.Response;
import cv.report.common.Util1;
import cv.report.entity.Region;
import cv.report.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RegionController {
    @Autowired
    private RegionService regionService;
    private final Response response = new Response();

    @PostMapping(path = "/save-region")
    public ResponseEntity<?> saveRegion(@RequestBody Region region) {
        if (isValidRegion(region)) {
            region = regionService.save(region);
            return ResponseEntity.ok(region);
        }
        return ResponseEntity.ok(response);
    }

    private boolean isValidRegion(Region region) {
        boolean status = true;
        if (Util1.isNullOrEmpty(region.getRegName())) {
            response.setMessage("Invalid Region Name");
            status = false;
        } else if (region.getStatus().equals("NEW")) {
            if (regionService.checkRegionExist(region)) {
                response.setMessage(region.getRegName() + " already exists.");
                status = false;
            }
        }
        return status;
    }

    @GetMapping(path = "/get-region")
    public ResponseEntity<?> getRegion() {
        return ResponseEntity.ok(regionService.getRegion());
    }
}
