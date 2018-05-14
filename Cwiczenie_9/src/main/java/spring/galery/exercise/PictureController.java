package spring.galery.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import spring.galery.exercise.data.Picture;
import spring.galery.exercise.service.PictureService;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
@RestController
public class PictureController {


        @Autowired
        private PictureService pictureService;

        @RequestMapping(value = "/gallery/pictures",method = RequestMethod.GET)
        public List<Picture> getImageInfo()
        {
            return  pictureService.getAllPictures();
        }

        @RequestMapping(value = "gallery/pictures/{index}",method = RequestMethod.GET,produces = MediaType.IMAGE_JPEG_VALUE)
        public void getImage(HttpServletResponse response, @PathVariable("index") int index) throws IOException {
            ClassPathResource imgFile= new ClassPathResource("image");
            File directory =imgFile.getFile();
            File[] files = directory.listFiles();
            // int i =Integer.getInteger(index);
            index-=1;
            ClassPathResource img= new ClassPathResource("image/" +files[index].getName());
            response.setContentType(MediaType.IMAGE_JPEG_VALUE);
            StreamUtils.copy(img.getInputStream(),response.getOutputStream());
        }

        @RequestMapping(value = "gallery/pictures/{index}",method = RequestMethod.DELETE)
        public  boolean deleteImage(@PathVariable("index") int index) throws IOException {
            ClassPathResource dir = new ClassPathResource("image");
            File directory = dir.getFile();
            File[] files = directory.listFiles();
            index -=1;
            if(files[index]!=null) {
                return files[index].delete();
            }
            else
                return false;
        }
}

