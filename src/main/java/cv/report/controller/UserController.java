package cv.report.controller;

import cv.report.common.Response;
import cv.report.common.Util1;
import cv.report.entity.AppUser;
import cv.report.entity.UserCompany;
import cv.report.repo.UserCompanyRepo;
import cv.report.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private AppUserService userService;
    @Autowired
    private UserCompanyRepo userCompanyRepo;
    private final Response response = new Response();

    @PostMapping(path = "/save-user")
    public ResponseEntity<?> saveUser(@RequestBody AppUser user) {
        if (isValidUser(user)) {
            user = userService.save(user);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.ok(response);
    }

    private boolean isValidUser(AppUser user) {
        boolean status = true;
        if (Util1.isNullOrEmpty(user.getUserName())) {
            response.setMessage("Invalid User Name");
            status = false;
        } else if (Util1.isNullOrEmpty(user.getShortName())) {
            response.setMessage("Invalid User Short");
            status = false;
        } else if (Util1.isNullOrEmpty(user.getPassword())) {
            response.setMessage("Invalid User Password");
            status = false;
        } else if (user.getStatus().equals("NEW")) {
            if (userService.existUser(user)) {
                response.setMessage(user.getShortName() + " already exists.");
                status = false;
            }
        }
        return status;
    }

    @PostMapping(path = "/save-user-company")
    public ResponseEntity<?> saveUserCompany(@RequestBody UserCompany uc) {
        uc = userCompanyRepo.save(uc);
        return ResponseEntity.ok(uc);
    }
    @GetMapping(path = "/get-user-company")
    public ResponseEntity<?> getUserCompany() {
        return ResponseEntity.ok(userCompanyRepo.findAll());
    }
    @GetMapping(path = "/find-user-company")
    public ResponseEntity<?> findUserCompany(@RequestParam String userCode) {
        return ResponseEntity.ok(userCompanyRepo.search(userCode));
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> saveUserCompany(@RequestBody AppUser uc) {
        if (Util1.isNullOrEmpty(uc.getShortName())) {
            response.setMessage("Invalid User Name");
            return ResponseEntity.badRequest().body(response);
        } else if (Util1.isNullOrEmpty(uc.getPassword())) {
            response.setMessage("Invalid Password.");
            return ResponseEntity.badRequest().body(response);
        }
        uc = userService.login(uc);
        return ResponseEntity.ok(uc);
    }

    @GetMapping(path = "/get-user")
    public ResponseEntity<?> getUser() {
        return ResponseEntity.ok(userService.getUser());
    }
}
