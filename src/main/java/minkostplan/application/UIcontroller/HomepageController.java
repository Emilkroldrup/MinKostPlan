package minkostplan.application.UIcontroller;

import minkostplan.application.entity.Users;
import minkostplan.application.usecase.UserUtil;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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


    @GetMapping("/profile")
    public String profilepage(Authentication authentication, Model model){
        Users user = UserUtil.getCurrentUser();
        System.out.println("User" + user);
        model.addAttribute("User",user);
        // Your POST method logic here
        return"profilePage";
    }


    @PostMapping("/changeProfilePicture")
    public String profilepicturechange(){

        return"profilePage";
    }
}
