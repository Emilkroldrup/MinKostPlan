package minkostplan.application.UIcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    @GetMapping("/home")
    public String home() {
        return "homepage";
    }
}
