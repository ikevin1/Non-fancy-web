package springxml.beans;

import springxml.services.LoggingService;

public class Comdeian {
    private Object LoggingService;

    public void setLoggingService(LoggingService loggingService) {
        LoggingService = loggingService;
    }
    private LoggingService loggingService;

    private String name;
    private String description;
    private String picture;
    private int price;

    public Comdeian() {
    }


}
