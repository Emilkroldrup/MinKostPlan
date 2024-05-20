package minkostplan.application.UIcontroller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserRecipeController {
    @GetMapping("/recipelist")
    public String userRecipeList(){
        return "userRecipeList";
    }
}
