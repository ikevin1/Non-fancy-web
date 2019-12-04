package edu.wctc.myComic.dao;

import edu.wctc.myComic.entity.ComedianName;

import java.util.List;

public interface ComedianNameDAO {
    List<ComedianName> getNames();

    ComedianName getName(int id);
}
