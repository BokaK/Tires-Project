package mk.ukim.finki.tires.models.jpa;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Simona on 7/9/2017.
 */
@Entity
@Table(name = "checkout")
public class Checkout extends BaseEntity{
    @OneToOne
    private Cart cart;

    @ManyToOne
    private DeliveryInfo deliveryInfo;

    @ManyToOne
    private ContactInfo contactInfo;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}
