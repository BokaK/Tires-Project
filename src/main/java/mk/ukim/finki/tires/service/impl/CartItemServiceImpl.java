package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.CartItem;
import mk.ukim.finki.tires.persistence.CartItemRepository;
import mk.ukim.finki.tires.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Simona on 7/10/2017.
 */
@Service
public class CartItemServiceImpl implements CartItemService{
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public List<CartItem> findAll() {
        return (List<CartItem>) cartItemRepository.findAll();
    }

    @Override
    public CartItem findById(Long id) {
        return cartItemRepository.findOne(id);
    }

    @Override
    public void insert(CartItem entity) {
        cartItemRepository.save(entity);
    }

    @Override
    public void update(Long id, CartItem entity) {
        cartItemRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        cartItemRepository.delete(id);
    }
}
