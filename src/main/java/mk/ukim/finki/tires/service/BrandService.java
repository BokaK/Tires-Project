package mk.ukim.finki.tires.service;

import mk.ukim.finki.tires.models.jpa.Brand;
import mk.ukim.finki.tires.models.jpa.User;

import java.util.List;

/**
 * Created by user on 03.6.2017.
 */
public interface BrandService {

    List<Brand> findAll();
    Brand findById(Long id);
    void insert(Brand entity);
    void update(Long id,Brand entity);
    void deleteById(Long id);
}
