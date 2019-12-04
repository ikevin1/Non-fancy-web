package edu.wctc.myComic.service;

import edu.wctc.myComic.entity.Comedian;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ComedianServices {
    List<Comedian> getDonuts();

    void saveDonut(Comedian aComedian, MultipartFile file, String applicationPath);

    Comedian getComedian(int theId);

    void deleteComedian(int theId);

    List<Comedian> getComediansByName(String theSearchTerm);
}
