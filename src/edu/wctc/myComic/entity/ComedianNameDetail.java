package edu.wctc.myComic.entity;

import javax.persistence.*;

@Entity
@Table(name = "detail")
public class ComedianNameDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private int id;

    @OneToOne(mappedBy = "detail",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private ComedianName name;

    @Column(name = "desc")
    private String description;

    public ComedianNameDetail() {
        //No arg const
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "ComedianNameDetail{" +
                "id=" + id +
                ", name=" + name +
                ", description='" + description + '\'' +
                '}';
    }
}
