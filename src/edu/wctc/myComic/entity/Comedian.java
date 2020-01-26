package edu.wctc.myComic.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "comedian")
public class Comedian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comedian_id")
    private int id;


    @Column(name = "name")
    private String name;

    @Column(name = "picture_name")
    private java.lang.String picture;

    @NotNull(message = "required")
    @Size(min = 1, max = 350, message = "1-350 characters")
    @Column(name = "description")
    private java.lang.String description;

    @NotNull(message = "required")
    @Min(value = 1, message = "good donations at least 10")
    @Column(name = "price")
    private double price;

    public Comedian() {
        //no argument constructor
    }

    public Comedian(String name, String picture, String description, @NotNull(message = "required") @Min(value = 1, message = "good donations at least 10") double price) {
        this.name = name;
        this.picture = picture;
        this.description = description;
        this.price = price;
    }

    public java.lang.String getImagePath() {
        if (name == null || picture == null) {
            return "none.jpg";
        }
        return getPicture()
                + "/"
                + picture;
    }
//    public void add(Comedian tempComedian) {
//        if (name == null) {
//            name = new ArrayList<Comedian>();
//        }
//        name.add(tempComedian);
//        tempComedian.setName(this);
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(java.lang.String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(java.lang.String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public java.lang.String toString() {
        return "Comedian{" +
                "id=" + id +
                ", name=" + name +
                ", picture='" + picture + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
