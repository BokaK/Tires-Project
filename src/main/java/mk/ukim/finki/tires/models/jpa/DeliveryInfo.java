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
    private String country;

    private String city;

    private String postalCode;

    private String address;

    @ManyToOne
    public User customer;
}
