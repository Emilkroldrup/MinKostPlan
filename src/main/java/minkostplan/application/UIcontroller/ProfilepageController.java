package minkostplan.application.UIcontroller;
import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.DBcontroller.user.UserRepositoryImpl;
import minkostplan.application.entity.Users;
import minkostplan.application.usecase.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProfilepageController {

    UserUtil userUtil;
    UserRepository userRepository;
    UserRepositoryImpl userRepositoryimpl;

    @Autowired
    public ProfilepageController(UserUtil userUtil, UserRepository userRepository) {
        this.userUtil = userUtil;
        this.userRepository = userRepository;
        UserUtil.setUserRepository(userRepository);
    }

    @GetMapping("/profile")
    public String profilepage(Model model){
        Users user = UserUtil.getCurrentUser();
        model.addAttribute("User",user);
        return"profilePage";
    }

    @PostMapping("/changeProfilePicture")
    public String profilePictureChange(){

        return"profilePage";
    }
    @GetMapping("/editprofile")
    public String editProfilePage(Model model){
        Users user = UserUtil.getCurrentUser();
        System.out.println("User" + user);
        model.addAttribute("User",user);
        return "editProfileDetails";
    }
    @PostMapping("/editprofile")
    public String editProfile(@ModelAttribute("User") Users user, Model model) {
        System.out.println("Received User: " + user);
        try {
            System.out.println("Attempting to edit user details...");
            userRepository.editUserDetails(user);
            System.out.println("User details edited successfully.");
            model.addAttribute("successMessage", "Profile updated successfully.");
        } catch (DuplicateKeyException e) {
            System.out.println("DuplicateKeyException caught: " + e.getMessage());
            model.addAttribute("errorMessage", "Email already exists. Please choose a different email.");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
            model.addAttribute("errorMessage", "An unexpected error occurred.");
        }
        model.addAttribute("User", user);
        return "editProfileDetails";
    }
}
