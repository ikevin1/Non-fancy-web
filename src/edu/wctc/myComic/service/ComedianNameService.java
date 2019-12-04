package edu.wctc.myComic.service;

import java.util.List;

public interface ComedianNameService {
    List<String> getNames();

    String getName(int id);
}
