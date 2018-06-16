package spring.galery.exercise.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import spring.galery.exercise.data.Picture;

import javax.imageio.ImageIO;
import javax.servlet.ServletInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;
@Service
public class PictureService {
    private List<Picture> gallery=null;

    private String path="E:\\Java_Projects\\Student Projects\\Java_GCL07_lato_2018_Kacper_Szczygiel\\Cwiczenie_9\\src\\main\\resources\\image";

    public List<Picture> getAllPictures(){


        File directory = new File(path);
        File[] contents= directory.listFiles();
        int width = 963;
        int height = 640;
        int index=0;
        BufferedImage bf =null;
        gallery= new ArrayList<Picture>();
        BasicFileAttributes attr=null;
        for(File f : contents)
        {
            try {
                ++index;
                Path p = Paths.get(f.getPath());
                bf = ImageIO.read(f);
                attr= Files.readAttributes(p,BasicFileAttributes.class);
                String name=f.getName();
                long size=attr.size();
                FileTime date = attr.creationTime();
                int bfWidth = bf.getWidth();
                int bfHeight =bf.getHeight();
                String resolution = bfWidth +"x"+bfHeight;
                gallery.add(new Picture(index,name,resolution,size,date.toString()));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return gallery;
    }
    public String setImage(ServletInputStream inputStream) throws IOException{
            BufferedImage newImage;
            newImage= ImageIO.read(inputStream);

        return "cos";
    }
}
