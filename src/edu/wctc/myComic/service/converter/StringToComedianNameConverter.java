package edu.wctc.myComic.service.converter;

import edu.wctc.myComic.entity.ComedianName;
import edu.wctc.myComic.service.ComedianNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToComedianNameConverter implements Converter<String, ComedianName> {
    @Autowired
    private ComedianNameService comedianNameService;

    @Override
    public ComedianName convert(String s) {
        int nameId = Integer.parseInt(s);

        ComedianName aName = comedianNameService.getName(nameId);

        return aName;
    }
}
