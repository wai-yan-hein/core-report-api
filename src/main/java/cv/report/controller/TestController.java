package cv.report.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class TestController {
    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello Back.";
    }
}
