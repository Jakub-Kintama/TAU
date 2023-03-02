package pl.edu.pjwstk.Data.recipes;

import javax.persistence.*;

@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "creator")
    private String creator;
    @Column(name = "minutes")
    private int minutes;
    @Column(name = "plates")
    private int plates;
    @Column(name = "vege")
    private boolean vege;
    @Column(name = "description_id")
    private int description_id;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getPlates() {
        return plates;
    }

    public void setPlates(int plates) {
        this.plates = plates;
    }

    public boolean isVege() {
        return vege;
    }

    public void setVege(boolean vege) {
        this.vege = vege;
    }

    public int getDescription_id() {
        return description_id;
    }

    public void setDescription_id(int description_id) {
        this.description_id = description_id;
    }
}
