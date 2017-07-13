package mk.ukim.finki.tires.models.jpa;

import mk.ukim.finki.tires.enums.Provider;
import mk.ukim.finki.tires.enums.UserType;
import mk.ukim.finki.tires.models.jpa.BaseEntity;

import javax.persistence.*;

/**
 * Created by user on 31.5.2017.
 */
@Entity
@Table(name="user")
public class User extends BaseEntity {

    public String username;

    public String password;

    public String email;

    @Enumerated(EnumType.STRING)
    public UserType type;

    @Enumerated(EnumType.STRING)
    public Provider provider;

    @OneToOne
    public ContactInfo contactInfo;

    @OneToOne
    public DeliveryInfo deliveryInfo;


}
