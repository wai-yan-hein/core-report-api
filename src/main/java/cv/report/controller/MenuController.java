package cv.report.controller;

import cv.report.entity.Menu;
import cv.report.repo.MenuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MenuController {
    @Autowired
    private MenuRepo menuRepo;

    @PostMapping(path = "/save-menu")
    public ResponseEntity<?> saveMenu(@RequestBody Menu menu) {
        menu = menuRepo.save(menu);
        return ResponseEntity.ok(menu);
    }

    @PostMapping(path = "/get-menu")
    public ResponseEntity<?> getMenu(@RequestParam String menuCode) {
        Optional<Menu> byId = menuRepo.findById(menuCode);
        return ResponseEntity.ok(byId.orElse(null));
    }
}
