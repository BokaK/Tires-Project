package mk.ukim.finki.tires.models.jpa;

import mk.ukim.finki.tires.enums.CheckoutStatus;

import javax.persistence.*;

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

    @Enumerated(EnumType.STRING)
    public CheckoutStatus status;

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
