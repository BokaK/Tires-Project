package mk.ukim.finki.tires.models.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by user on 09.7.2017.
 */
@Entity
@Table(name="inches")
public class Inches extends BaseEntity{

    private int inches;

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }
}
