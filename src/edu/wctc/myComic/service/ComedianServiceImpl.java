package edu.wctc.myComic.service;

import edu.wctc.myComic.dao.ComedianDAO;
import edu.wctc.myComic.entity.Comedian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.transaction.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ComedianServiceImpl implements ComedianService {

    @Autowired
    private PictureService pictureService;

    @Autowired
    private ComedianDAO comedianDAO;

    @Override
    @Transactional
    public List<Comedian> getComedians() {
        return comedianDAO.getComedians();
    }

    @Override
    @Transactional
    public void saveComedian(Comedian aComedian,
                          MultipartFile file,
                          String applicationPath) {
        if (aComedian.getDateAdded() == null) {
            aComedian.setDateAdded(new Date());
        }

        String filename = pictureService.saveFile(
                file,
                applicationPath,
                aComedian.getName().getImageDirectory());

        if (filename != null) {
            aComedian.setPicture(filename);
        }

        comedianDAO.saveComedian(aComedian);
    }

    @Override
    @Transactional
    public Comedian getComedian(int theId) {
        return comedianDAO.getComedian(theId);
    }

    @Override
    @Transactional
    public void deleteComedian(int theId) {
        comedianDAO.deleteComedian(theId);
    }

    @Override
    @Transactional
    public List<Comedian> getComediansByName(String theSearchTerm) {
        return comedianDAO.getComediansByName(theSearchTerm);
    }
}
