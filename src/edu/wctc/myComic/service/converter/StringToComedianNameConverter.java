package edu.wctc.myComic.service.converter;

import edu.wctc.myComic.service.ComedianNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToComedianNameConverter implements Converter<java.lang.String, String> {
    @Autowired
    private ComedianNameService comedianNameService;

    @Override
    public String convert(java.lang.String s) {
        int nameId = Integer.parseInt(s);

        String aName = comedianNameService.getName(nameId);

        return aName;
    }
}
