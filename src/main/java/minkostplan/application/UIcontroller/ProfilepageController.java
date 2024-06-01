package minkostplan.application.UIcontroller;
import minkostplan.application.DBcontroller.user.UserRepository;
import minkostplan.application.DBcontroller.user.UserRepositoryImpl;
import minkostplan.application.entity.Users;
import minkostplan.application.usecase.UserService;
import minkostplan.application.usecase.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller for handling profile page related requests.
 */
@Controller
public class ProfilepageController {

    UserUtil userUtil;
    UserRepository userRepository;
    UserRepositoryImpl userRepositoryimpl;

    UserService userService;

    @Autowired
    public ProfilepageController(UserUtil userUtil, UserService userService, UserRepository userRepository) {
        this.userUtil = userUtil;
        this.userRepository = userRepository;
        this.userService = userService;
        UserUtil.setUserRepository(userRepository);
    }

    /**
     * Handles the profile page request.
     *
     * @param model the model to add attributes
     * @return the profile page view
     */
    @GetMapping("/profile")
    public String profilepage(Model model) {
        Users user = UserUtil.getCurrentUser();

        model.addAttribute("User", user);
        return "profilePage";
    }

    /**
     * Handles the profile picture change request.
     *
     * @return the profile page view
     */
    @PostMapping("/changeProfilePicture")
    public String profilePictureChange() {

        return "profilePage";
    }

    /**
     * Handles the edit profile page request.
     *
     * @param model the model to add attributes
     * @return the edit profile details view
     */
    @GetMapping("/editprofile")
    public String editProfilePage(Model model) {
        Users user = UserUtil.getCurrentUser();
        model.addAttribute("User", user);
        return "editProfileDetails";
    }

    /**
     * Handles the edit profile request.
     *
     * @param user  the user entity with updated details
     * @param model the model to add attributes
     * @return the edit profile details view
     */
    @PostMapping("/editprofile")
    public String editProfile(@ModelAttribute("User") Users user, Model model) {


        Users currentUserEmail = UserUtil.getCurrentUser();
        String editedEmail = user.getEmail();
        boolean editUserComplete = userService.editUserDetails(user);
        if (editUserComplete && !editedEmail.equals(currentUserEmail.getEmail())) {
                return "redirect:/login";
        }
            Users userupdate = UserUtil.getCurrentUser();
            model.addAttribute("User", userupdate);
            return "editProfileDetails";

        }
    }


