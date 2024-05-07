package minkostplan.application.UIcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class LoginController {

    @GetMapping("")
    public String defaultpage() {
        return "loginPage";
    }

    @GetMapping("/login")
    public String login() {
        return "loginPage";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profilePage";
    }

    @PostMapping("changeProfilePicture")
    public String profilepicture(){

        
    }
        
    
}