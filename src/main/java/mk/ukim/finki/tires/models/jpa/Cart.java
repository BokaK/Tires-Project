package mk.ukim.finki.tires.models.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by Simona on 7/9/2017.
 */
@Entity
@Table(name = "cart")
public class Cart extends BaseEntity{

    private LocalDateTime expiryDate;
    private Double totalPrice;

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }
}
