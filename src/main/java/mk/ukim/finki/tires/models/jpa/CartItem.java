package mk.ukim.finki.tires.models.jpa;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Simona on 7/9/2017.
 */
@Entity
@Table(name = "cart_item")
public class CartItem extends BaseEntity {

    @NotNull
    @Min(value = 1)
    private int quantity;

    @ManyToOne
    private Tire tire;

    @ManyToOne
    private Cart cart;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Tire getTire() {
        return tire;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
