package edu.wctc.myComic.dao;

import java.util.List;

public interface ComedianNameDAO {
    List<String> getNames();

    String getName(int id);
}
