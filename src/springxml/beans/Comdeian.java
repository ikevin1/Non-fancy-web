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
    public Comdeian(LoggingService logService) {
        this.loggingService = logService;
    }

    public void loggingChange(){
        loggingService.log("voce fala aqui?");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
