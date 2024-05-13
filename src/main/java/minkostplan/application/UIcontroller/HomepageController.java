package minkostplan.application.UIcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

    @GetMapping("/home")
    public String home() {
        return "homepage";
    }

    @GetMapping("/footer")
    public String footer() {
        return "footer";
    }


    @GetMapping("/about")
    public String aboutPage(){
        return "aboutPage";
    }

    @GetMapping("/admin")
    public String admin(){
        return "adminPage";
    }
}
