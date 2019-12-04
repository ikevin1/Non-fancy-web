package edu.wctc.myComic.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "comedian")
public class Comedian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comedian_id")
    private int id;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "comedian_id")
    private ComedianName name;

    @Column(name = "img_filename")
    private String picture;

    @Column(name = "date_added")
    private Date dateAdded;

    @NotNull(message = "required")
    @Size(min = 1, max = 350, message = "1-350 characters")
    @Column(name = "desc")
    private String description;

    @NotNull(message = "required")
    @Min(value = 1, message = "good donations at least 10")
    @Column(name = "amount")
    private double price;

    public Comedian() {
        //no argument constructor
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Comedian(@NotNull(message = "required") @Size(min = 1, max = 30, message = "1-30 characters") String names, String picture, @NotNull(message = "required") @Size(min = 1, max = 350, message = "1-350 characters") String description, @NotNull(message = "required") @Min(value = 1, message = "good donations at least 10") double price) {
        this.picture = picture;
        this.description = description;
        this.price = price;
    }

    public String getImagePath() {
        if (name == null || picture == null) {
            return "none.jpg";
        }
        return name.getImageDirectory()
                + "/"
                + picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ComedianName getName() {
        return name;
    }

    public void setName(ComedianName name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Comedian{" +
                "id=" + id +
                ", name=" + name +
                ", picture='" + picture + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
