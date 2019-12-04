package edu.wctc.myComic.service.converter;

import java.util.Date;

import edu.wctc.myComic.DateUtils;
import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        return DateUtils.parseWebDate(s);
    }
}
