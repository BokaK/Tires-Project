package mk.ukim.finki.tires.service;

import mk.ukim.finki.tires.models.jpa.Cart;

import java.util.List;

/**
 * Created by Simona on 7/10/2017.
 */
public interface CartService {

    Cart getShoppingCartInSession();
    void updateCartInSession();
    List<Cart> findAll();
    Cart findById(Long id);
    void insert(Cart entity);
    void update(Long id,Cart entity);
    void deleteById(Long id);
}
