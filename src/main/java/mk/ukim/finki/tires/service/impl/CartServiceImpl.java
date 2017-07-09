package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.Cart;
import mk.ukim.finki.tires.persistence.CartRepository;
import mk.ukim.finki.tires.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Simona on 7/10/2017.
 */
@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Cart> findAll() {
        return (List<Cart>) cartRepository.findAll();
    }

    @Override
    public Cart findById(Long id) {
        return cartRepository.findOne(id);
    }

    @Override
    public void insert(Cart entity) {
        cartRepository.save(entity);
    }

    @Override
    public void update(Long id, Cart entity) {
        cartRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        cartRepository.delete(id);
    }
}
