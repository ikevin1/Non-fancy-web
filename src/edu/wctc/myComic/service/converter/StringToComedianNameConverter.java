package edu.wctc.myComic.service.converter;

import edu.wctc.myComic.entity.Comedian;
import edu.wctc.myComic.service.ComedianNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

public class StringToComedianNameConverter implements Converter<String, Comedian> {
  //  @Autowired
    private ComedianNameService comedianNameService;

    @Override
    public Comedian convert(String s) {
        int comedianId = Integer.parseInt(s);

        Comedian aComedian = comedianNameService.getComedian(comedianId);

        return aComedian;
    }
}
