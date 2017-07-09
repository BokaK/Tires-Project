package mk.ukim.finki.tires.models.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by user on 09.7.2017.
 */
@Entity
@Table(name = "width")
public class Width extends BaseEntity {

    public int width;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
