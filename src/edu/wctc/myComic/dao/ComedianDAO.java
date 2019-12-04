package edu.wctc.myComic.dao;

import edu.wctc.myComic.entity.Comedian;

import java.util.List;

public interface ComedianDAO {
    List<Comedian> getComedians();

    void saveComedian(Comedian aComedian);

    Comedian getComedian(int theId);

    void deleteComedian(int theId);

    List<Comedian> getComediansByName(String theSearchTerm);
}
