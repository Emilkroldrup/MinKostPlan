package minkostplan.application.UIcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import minkostplan.application.DBcontroller.picture.PictureStorage;
import minkostplan.application.entity.ImageRecipeInfo;

public class ImageController {

    @Autowired
    PictureStorage pictureStorage;

    /**
     * Redirects to the home page.
     * @return the home page
     * 
     */
    @GetMapping("/")
    public String homepage() {
        return "redirect:/home";
    }

    /**
     * Redirects to the uploadform
     * @return the upload form
     * 
     */
    @GetMapping("/images/new")
    public String newImage (Model model)  {
        return "uploadForm";
    }

   
    /**
     * Uploads the specified image.
     * @param model
     * @param file
     * @return the upload form
     */
    @PostMapping("/images/upload")
    public String uploadImage(Model model, @RequestParam("file") MultipartFile file) {
        String message = "";

        try {
            pictureStorage.save(file);

            message = "Uploaded the image succesfully: " + file.getOriginalFilename();
            model.addAttribute("message", message);
        } catch (Exception e) {
            message = "Could not upload the image: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            model.addAttribute("message", message);
        }

        return "uploadForm";
    }


    /**
     * Lists all the images in the uploads folder.
     * @param model
     * @return the images view
     */
    //  Might be useful for the recipes
    @GetMapping("/imagetester/list")
    public String getListImages(Model model) {
        List<ImageRecipeInfo> imageInfos = pictureStorage.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder.fromMethodName(ImageController.class, "getImage", path.getFileName().toString()).build().toString();

            return new ImageRecipeInfo(filename, url);
        }).collect(Collectors.toList());

        model.addAttribute("imagetester", imageInfos);
        return "imagetester"; // add new mapping for the specified wanted view
    }


    /**
     * Gets the specified image.
     * @param filename
     * @return
     */
    // Use this to load the users profile picture when they login
    @GetMapping("/images/{filename:.+}")
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        Resource file = pictureStorage.load(filename);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
        
    }


    /**
     * Deletes the specified image.
     * @param filename
     * @param model
     * @param redirectAttributes
     * @return the images view
     */
    public String deleteImage(@PathVariable String filename, Model model, RedirectAttributes redirectAttributes) {
        try {
            boolean existed = pictureStorage.delete(filename);

            if (existed) {
                redirectAttributes.addFlashAttribute("message", "Delete the image succesfully: " + filename);
            } else {
                redirectAttributes.addFlashAttribute("message", "The image does not exist.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("message", "Could not delete the image: " + filename + ". Error: " + e.getMessage());
        }

        return "redirect:/images";

    }
}
