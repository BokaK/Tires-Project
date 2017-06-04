package mk.ukim.finki.tires.service;

import mk.ukim.finki.tires.models.jpa.VehicleType;

import java.util.List;

/**
 * Created by user on 04.6.2017.
 */
public interface VehicleTypeService {
    List<VehicleType> findAll();
    VehicleType findById(Long id);
    void insert(VehicleType entity);
    void update(Long id, VehicleType entity);
    void deleteById(Long id);
}
