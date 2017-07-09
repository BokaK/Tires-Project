package mk.ukim.finki.tires.models.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by user on 09.7.2017.
 */
@Entity
@Table(name = "height")
public class Height extends BaseEntity{

    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
