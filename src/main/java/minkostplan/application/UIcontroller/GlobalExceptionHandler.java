package minkostplan.application.UIcontroller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jakarta.servlet.http.HttpServletRequest;
import minkostplan.application.usecase.CustomExceptions.InvalidDetailsException;
import minkostplan.application.usecase.CustomExceptions.RecipeNameAlreadyExistsException;
import minkostplan.application.usecase.CustomExceptions.UnexpectedDataErrorExpception;
import minkostplan.application.usecase.CustomExceptions.UserEmailAlreadyExistsException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LogManager.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler(RecipeNameAlreadyExistsException.class)
    public String handleRecipeNameAlreadyExistsException(RecipeNameAlreadyExistsException rn, RedirectAttributes redirectAttributes,HttpServletRequest request) {
        logger.error("Same recipe name already exists", rn);
        String originalUrl = request.getRequestURI();
        String fragment = request.getQueryString();

        if (originalUrl.contains("/addrecipe")) {
            redirectAttributes.addFlashAttribute("errorMessage", "Same recipe name already exists");
            return "redirect:/adminrecipe";

        } else {
            String redirectUrl = "redirect:" + originalUrl;
            if (fragment != null) {
                redirectUrl += "?" + fragment;
            }
            redirectAttributes.addFlashAttribute("errorMessage", "Same recipe name already exists");
            return "redirect:" + redirectUrl;
        }
    }
    @ExceptionHandler(UserEmailAlreadyExistsException.class)
    public String handleUserEmailAlreadyExistsException(UserEmailAlreadyExistsException us, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        logger.error("Same email already exists", us);
        String originalUrl = request.getRequestURI();
        redirectAttributes.addFlashAttribute("errorMessage", "Same email already exists");
        return "redirect:" + originalUrl;
    }

    @ExceptionHandler(InvalidDetailsException.class)
    public String handleInvalidlDetailsException(InvalidDetailsException in, RedirectAttributes redirectAttributes, HttpServletRequest request) {
        logger.error("Invalid details provided", in);
        String originalUrl = request.getRequestURI();
        redirectAttributes.addFlashAttribute("errorMessage", "Invalid details provided");
        return "redirect:" + originalUrl;
    }

    @ExceptionHandler(UnexpectedDataErrorExpception.class)
    public String handleDataAccessException(UnexpectedDataErrorExpception ex, Model model, RedirectAttributes redirectAttributes) {
        logger.error("Unexpected error occurred", ex);
        model.addAttribute("errorMessage", "Unexpected error happened");
        return "errorpage";
    }

}