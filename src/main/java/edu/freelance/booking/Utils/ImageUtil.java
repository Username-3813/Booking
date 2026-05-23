package edu.freelance.booking.Utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {
    public String UploadImage(MultipartFile imageFile) {
        try {
        String uploadPath = "src/main/resources/static/images";
            Path uploadDir = Paths.get(uploadPath);
            if(!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }

           //String filename = imageFile.getOriginalFilename();
           String ext = imageFile.getOriginalFilename().substring(imageFile.getOriginalFilename().lastIndexOf("."));
           String newFilename = UUID.randomUUID().toString() + ext; 
           Path targetPath = uploadDir.resolve(newFilename);
            imageFile.transferTo(targetPath);
            return newFilename;
        } catch (IOException ex) {
            System.out.println("Ошибка сохранения: " + ex.getMessage());
        }             
        return "";
    }
}
