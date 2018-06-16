package spring.galery.exercise;

import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.galery.exercise.data.Picture;
import spring.galery.exercise.service.PictureService;
import spring.galery.exercise.service.StorageService;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
@RestController
public class PictureController {


        @Autowired
        private PictureService pictureService;
//        private StorageService storageService;
        private String path="E:\\Java_Projects\\Student Projects\\Java_GCL07_lato_2018_Kacper_Szczygiel\\Cwiczenie_9\\src\\main\\resources\\image";
        @RequestMapping(value = "/gallery/pictures",method = RequestMethod.GET)
        public List<Picture> getImageInfo()
        {
            return  pictureService.getAllPictures();
        }

        @RequestMapping(value = "gallery/pictures/{index}",method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
        public void getImage(HttpServletResponse response, @PathVariable("index") int index) throws IOException {
            ClassPathResource imgFile= new ClassPathResource("image");
            File directory =new File(path);
            File[] files = directory.listFiles();
            index-=1;
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
           try (               FileInputStream f =new FileInputStream(files[index]);
           ) {
               StreamUtils.copy(f, response.getOutputStream());

           }
        }

        @RequestMapping(value = "gallery/pictures/{index}",method = RequestMethod.DELETE)
        public  boolean deleteImage(@PathVariable("index") int index) throws IOException {
            File directory = new File(path);
            File[] files = directory.listFiles();
            index -=1;
            return files[index].delete();
        }

//    @RequestMapping(method = RequestMethod.POST, value = "/gallery/pictures/uploads")
//    public String addImage(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
//        storageService.store(file);
//        redirectAttributes.addFlashAttribute("message","You succesfully upload "+ file.getOriginalFilename() +"!");
//        return "cos";
//    }
}

