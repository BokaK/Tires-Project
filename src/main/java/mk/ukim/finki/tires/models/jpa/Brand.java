package mk.ukim.finki.tires.models.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by user on 03.6.2017.
 */
@Entity
@Table(name="brand")
public class Brand extends BaseEntity{

    private String brandName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
