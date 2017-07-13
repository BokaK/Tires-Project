package mk.ukim.finki.tires.models.jpa;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by Simona on 7/9/2017.
 */
@Entity
@Table(name = "delivery_info")
public class DeliveryInfo extends BaseEntity{

    private String city;

    private String address;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
