package edu.wctc.myComic.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "comedian_name")
public class ComedianName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comedian_id")
    private int id;

    @Column(name = "nm")
    private String name;
    @Column(name = "img_directory")
    private String imageDirectory;

    @OneToMany(mappedBy = "shop",
            cascade = CascadeType.ALL)
    private List<Comedian> comedians;

    public ComedianName() {
        //no argument const
    }

    public ComedianName(String name, String imageDirectory) {
        this.name = name;
        this.imageDirectory = imageDirectory;
    }

    public void add(Comedian tempDonut) {
        if (comedians == null) {
            comedians = new ArrayList<>();
        }
        comedians.add(tempDonut);
        tempDonut.setName(this);
    }

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

    public String getImageDirectory() {
        return imageDirectory;
    }

    public void setImageDirectory(String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }

    public List<Comedian> getComedians() {
        return comedians;
    }

    public void setComedians(List<Comedian> comedians) {
        this.comedians = comedians;
    }
}
