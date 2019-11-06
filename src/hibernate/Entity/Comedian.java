package hibernate.Entity;

import javax.persistence.*;

@Entity
@Table(name="comedian")
public class Comedian {

    @javax.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="comedian_id")
    private int Id;
   // private int ComedianId;
    @Column(name="nm")
    private String name;
    @OneToOne(mappedBy = "detail",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    private String description;
    @Column(name="img_filename")
    private String picture;
    @Column(name="price")
    private int price;

    public Comedian() {
        //No argument constructor
    }
//This is a constructor that accepts all arguments
    public Comedian(int comedianId, String name, String description, String picture, int price) {
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.price = price;
    }
//This is the getter and setter
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
    //This is the toString with override

    @Override
    public String toString() {
        return "Comedian{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", price=" + price +
                '}';
    }
}
