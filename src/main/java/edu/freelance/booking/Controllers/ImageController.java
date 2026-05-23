package edu.freelance.booking.Controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.freelance.booking.Models.Images;
import edu.freelance.booking.Repositories.ImageRepository;
import edu.freelance.booking.Utils.ImageUtil;

@Controller
public class ImageController {

    private ImageRepository imageRepository;

    public ImageController(ImageRepository repo){
        imageRepository = repo;
    }
    
    
    @PostMapping("/upload")
    //Прием и сохранение картинки
    public String uploadImage(@RequestParam("title") String title, 
                              @RequestParam("picture") MultipartFile imageFile) {
            
        ImageUtil util = new ImageUtil();
        String newFilename = util.UploadImage(imageFile);

        Images img = new Images();
        img.setTitle(title);
        img.setFilename(newFilename);
        imageRepository.save(img);

         return "redirect:/upload";
    }

    @GetMapping("/upload")
    public String formUpload() {
        return "upload/form";
    }

    @GetMapping("/gallery")
    public String gallery(Model data) {
        List<Images> pics =  imageRepository.findAll();
        data.addAttribute("pictures", pics);
        return "images/catalog";
    }
}
