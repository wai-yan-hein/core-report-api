package cv.report.controller;

import cv.report.common.Response;
import cv.report.common.Util1;
import cv.report.entity.CompanyInfo;
import cv.report.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CompanyController {
    @Autowired
    private CompanyInfoService companyInfoService;
    private final Response response = new Response();

    @PostMapping(path = "/save-company")
    public ResponseEntity<?> saveCompany(@RequestBody CompanyInfo info) {
        if (isValidCompany(info)) {
            info = companyInfoService.save(info);
            return ResponseEntity.ok(info);
        }
        return ResponseEntity.ok(response);
    }

    private boolean isValidCompany(CompanyInfo info) {
        boolean status = true;
        if (Util1.isNullOrEmpty(info.getCompName())) {
            response.setMessage("Invalid Company Name.");
            status = false;
        } else if (Util1.isNullOrEmpty(info.getStartDate())) {
            response.setMessage("Invalid Start Date.");
            status = false;
        } else if (Util1.isNullOrEmpty(info.getRegion())) {
            response.setMessage("Invalid Region.");
            status = false;
        } else if (info.getStatus().equals("NEW")) {
            if (companyInfoService.existCompany(info)) {
                response.setMessage(info.getCompName() + " already exists.");
                status = false;
            }
        }
        return status;
    }

    @GetMapping(path = "/get-company")
    public ResponseEntity<?> getCompany() {
        return ResponseEntity.ok(companyInfoService.getCompany());
    }
}
