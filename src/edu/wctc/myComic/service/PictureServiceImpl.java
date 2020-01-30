package edu.wctc.myComic.service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Service
public class PictureServiceImpl implements PictureService{
    @Override
    public String saveFile(MultipartFile file, String applicationPath, String imageDirectory) {
        String fileName = null;
        try {
            if (!file.isEmpty()) {
                String artifactPath = applicationPath
                        + "WEB-INF\\resources\\img\\"
                        + imageDirectory;

                String sourcePath = applicationPath + "..\\..\\..\\"
                        + "web\\WEB-INF\\resources\\img\\"
                        + imageDirectory;

                fileName = file.getOriginalFilename();


                File imageFile = new File(artifactPath, fileName);
                file.transferTo(imageFile);

                File copyOfImage = new File(sourcePath, fileName);
                FileUtils.copyFile(imageFile, copyOfImage);
            }
        } catch (Exception e) {
        }

        return fileName;
    }
}
