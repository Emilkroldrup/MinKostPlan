package minkostplan.application.UIcontroller;
import minkostplan.application.entity.Users;
import minkostplan.application.usecase.UserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProfilepageController {

    @GetMapping("/profile")
    public String profilepage(Model model){
        Users user = UserUtil.getCurrentUser();
        System.out.println("User" + user);
        model.addAttribute("User",user);
        return"profilePage";
    }

    @PostMapping("/changeProfilePicture")
    public String profilepicturechange(){

        return"profilePage";
    }
}
