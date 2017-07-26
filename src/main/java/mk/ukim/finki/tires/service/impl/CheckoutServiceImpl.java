package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.*;
import mk.ukim.finki.tires.persistence.*;
import mk.ukim.finki.tires.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Simona on 7/10/2017.
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final CheckoutRepository checkoutRepository;
    private final ContactInfoRepository contactInfoRepository;
    private final DeliveryInfoRepository deliveryInfoRepository;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    @Autowired
    public CheckoutServiceImpl(CheckoutRepository checkoutRepository, ContactInfoRepository contactInfoRepository, DeliveryInfoRepository deliveryInfoRepository, UserRepository userRepository, CartItemRepository cartItemRepository, CartRepository cartRepository) {
        this.checkoutRepository = checkoutRepository;
        this.contactInfoRepository = contactInfoRepository;
        this.deliveryInfoRepository = deliveryInfoRepository;
        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public List<Checkout> findAll() {
        return (List<Checkout>) checkoutRepository.findAll();
    }

    @Override
    public Checkout findById(Long id) {
        return checkoutRepository.findOne(id);
    }

    @Override
    public void insert(Checkout entity) {
        checkoutRepository.save(entity);
    }

    @Override
    public void update(Long id, Checkout entity) {
        checkoutRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        Checkout checkout = checkoutRepository.findOne(id);
        ContactInfo contactInfo = checkout.getContactInfo();
        DeliveryInfo deliveryInfo = checkout.getDeliveryInfo();
        User user = userRepository.findByContactInfo(contactInfo);
        Cart cart = checkout.getCart();
        List<CartItem> cartItems = cartItemRepository.findByCartId(cart.id);

        userRepository.delete(user);
        checkoutRepository.delete(id);
        contactInfoRepository.delete(contactInfo);
        deliveryInfoRepository.delete(deliveryInfo);
        cartItemRepository.delete(cartItems);
        cartRepository.delete(cart);
    }
}
