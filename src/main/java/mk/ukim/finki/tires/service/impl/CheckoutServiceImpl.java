package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.Checkout;
import mk.ukim.finki.tires.persistence.CheckoutRepository;
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

    @Autowired
    public CheckoutServiceImpl(CheckoutRepository checkoutRepository) {
        this.checkoutRepository = checkoutRepository;
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
        checkoutRepository.delete(id);
    }
}
