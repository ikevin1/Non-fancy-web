package edu.wctc.myComic.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "description")
public class ComedianDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comedian_id")
    private int id;

    @Column(name="description")
    private String Description;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "donut_id")
    private List<ComedianDescription> descriptions;

    public ComedianDescription() {
    }

    public ComedianDescription(String description) {
        Description = description;
    }

    public void add(ComedianDescription tempDescription) {
        if (descriptions == null) {
            descriptions = new ArrayList<>();
        }
        descriptions.add(tempDescription);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public List<ComedianDescription> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<ComedianDescription> descriptions) {
        this.descriptions = descriptions;
    }

    @Override
    public String toString() {
        return "ComedianDescription{" +
                "id=" + id +
                ", Description='" + Description + '\'' +
                ", descriptions=" + descriptions +
                '}';
    }
}
