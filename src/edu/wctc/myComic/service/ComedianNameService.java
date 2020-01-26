package edu.wctc.myComic.service;

import java.util.List;
import edu.wctc.myComic.entity.Comedian;

public interface ComedianNameService {
    List<Comedian> getComedians();

    Comedian getComedian(int id);
}
