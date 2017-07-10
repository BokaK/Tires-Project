package mk.ukim.finki.tires.models.jpa;

import mk.ukim.finki.tires.enums.InvoiceStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Simona on 7/9/2017.
 */
@Entity
@Table(name = "invoice")
public class Invoice  extends BaseEntity{
    @OneToOne
    public Checkout checkout;

    public Double grossPrice;

    public Double taxAmount;

    public LocalDateTime expiryDate;

    @Enumerated(EnumType.STRING)
    public InvoiceStatus status;
}