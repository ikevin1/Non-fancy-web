package edu.wctc.myComic.service;

import edu.wctc.myComic.entity.ComedianName;

import java.util.List;

public interface ComedianNameService {
    List<ComedianName> getNames();

    ComedianName getName(int id);
}
