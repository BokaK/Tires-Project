package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.Brand;
import mk.ukim.finki.tires.persistence.BrandRepository;
import mk.ukim.finki.tires.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 03.6.2017.
 */
@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> findAll() {
        return (List<Brand>) brandRepository.findAll();
    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findOne(id);
    }

    @Override
    public void insert(Brand entity) {
        brandRepository.save(entity);
    }

    @Override
    public void update(Long id, Brand entity) {
        brandRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        brandRepository.delete(id);
    }
}
