package minkostplan.application.UIcontroller;
import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.entity.Users;
import minkostplan.application.usecase.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProfilepageController {

    UserUtil userUtil;
    UserRepository userRepository;

    @Autowired
    public ProfilepageController(UserUtil userUtil, UserRepository userRepository) {
        this.userUtil = userUtil;
        this.userRepository = userRepository;
        UserUtil.setUserRepository(userRepository);
    }

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
