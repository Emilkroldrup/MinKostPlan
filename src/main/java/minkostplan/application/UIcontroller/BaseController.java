package minkostplan.application.UIcontroller;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import minkostplan.application.entity.Users;
import minkostplan.application.DBcontroller.user.UserRepository;



@Controller
public class BaseController {

    //TODO take this into a serivce layer class (usecase)
    /*private int getCurrentUserId(Principal principal) {
        String email = principal.getName();
        Users currentUser = UserRepository.getUserByEmail(email);
        return currentUser.getUserId();
    }*/

    @GetMapping("")
    public String defaultpage() {
        return "homepage";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new Users());
        return "loginPage";
    }

    @PostMapping("changeProfilePicture")
    public String profilepicture(){
        return "profilepicture";
    }

}
        
