package edu.wctc.myComic.service;

import org.springframework.web.multipart.MultipartFile;

public interface PictureService {
    String saveFile(MultipartFile file,
                    String applicationPath,
                    String imageDirectory);
}
