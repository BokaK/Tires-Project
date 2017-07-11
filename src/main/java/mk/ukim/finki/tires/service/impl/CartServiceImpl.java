package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.Cart;
import mk.ukim.finki.tires.persistence.CartRepository;
import mk.ukim.finki.tires.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
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

    @Autowired
    private HttpSession httpSession;

    private static final String CART_ATTRIBUTE_NAME="shoppingcart";

    @Override
    public Cart getShoppingCartInSession() {
        Cart shoppingCart = (Cart)this.httpSession.getAttribute(CART_ATTRIBUTE_NAME);
        if (shoppingCart == null) {
            shoppingCart = new Cart();
            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_MONTH, 2);
            date = cal.getTime();
            shoppingCart.setExpiryDate(date);
            shoppingCart.setTotalPrice(0.0);
            shoppingCart = cartRepository.save(shoppingCart);
            this.httpSession.setAttribute(CART_ATTRIBUTE_NAME, shoppingCart);
        }
        return shoppingCart;
    }

    @Override
    public void updateCartInSession(Cart shoppingCart) {
        this.httpSession.setAttribute(CART_ATTRIBUTE_NAME, shoppingCart);
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
