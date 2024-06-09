package minkostplan.application.UIcontroller;

import jakarta.servlet.http.HttpServletRequest;
import minkostplan.application.usecase.CustomExceptions.InvalidDetailsException;
import minkostplan.application.usecase.CustomExceptions.RecipeNameAlreadyExistsException;
import minkostplan.application.usecase.CustomExceptions.UserEmailAlreadyExistsException;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecipeNameAlreadyExistsException.class)
    public String handleRecipeNameAlreadyExistsException(RedirectAttributes redirectAttributes,HttpServletRequest request) {
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
    public String handleUserEmailAlreadyExistsException( RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String originalUrl = request.getRequestURI();
        redirectAttributes.addFlashAttribute("errorMessage","Same email already exists");
        return "redirect:" + originalUrl;
    }

    @ExceptionHandler(InvalidDetailsException.class)
    public String handleInvalidlDetailsException( RedirectAttributes redirectAttributes, HttpServletRequest request) {
        String originalUrl = request.getRequestURI();
        redirectAttributes.addFlashAttribute("errorMessage","Same email already exists");
        return "redirect:" + originalUrl;
    }
    @ExceptionHandler(DataAccessException.class)
    public String handleDataAccessException(DataAccessException ex,Model model, RedirectAttributes redirectAttributes) {
        model.addAttribute("errorMessage","Unexpected error happend");
        return "errorpage";
    }

}