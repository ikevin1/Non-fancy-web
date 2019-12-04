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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private ComedianNameDetail detail;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "comedian_id")
    private ComedianName name;

    @Column(name = "img_directory")
    private String imageDirectory;

    @OneToMany(mappedBy = "shop",
            cascade = CascadeType.ALL)
    private List<Comedian> comedians;

    public ComedianName() {
        //no argument const
    }

    public ComedianName(String name, String imageDirectory) {
        this.imageDirectory = imageDirectory;
    }

    public void add(Comedian tempComedian) {
        if (comedians == null) {
            comedians = new ArrayList<>();
        }
        comedians.add(tempComedian);
        tempComedian.setName(this);
    }

    public ComedianNameDetail getDetail() {
        return detail;
    }

    public void setDetail(ComedianNameDetail detail) {
        this.detail = detail;
    }

    public ComedianName getName() {
        return name;
    }

    public void setName(ComedianName name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
