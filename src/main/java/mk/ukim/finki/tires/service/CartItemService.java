package mk.ukim.finki.tires.service;

import mk.ukim.finki.tires.models.jpa.CartItem;

import java.util.List;

/**
 * Created by Simona on 7/10/2017.
 */
public interface CartItemService {
    List<CartItem> findAll();
    CartItem findById(Long id);
    void insert(CartItem entity);
    void update(Long id,CartItem entity);
    void deleteById(Long id);
}
