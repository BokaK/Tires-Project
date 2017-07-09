package mk.ukim.finki.tires.service;

import mk.ukim.finki.tires.models.jpa.Checkout;

import java.util.List;

/**
 * Created by Simona on 7/10/2017.
 */
public interface CheckoutService {
    List<Checkout> findAll();
    Checkout findById(Long id);
    void insert(Checkout entity);
    void update(Long id,Checkout entity);
    void deleteById(Long id);
}
