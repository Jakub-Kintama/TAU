package pl.edu.pjwstk.Data.description;

import javax.persistence.*;

@Entity
@Table(name = "description")
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name = "ingredients")
    private String ingredients;
    @Column(nullable = false, name = "steps")
    private String steps;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    @Override
    public String toString() {
        return "description{" +
                "id=" + id +
                ", ingredients='" + ingredients + '\'' +
                ", steps='" + steps + '\'' +
                '}';
    }
}
