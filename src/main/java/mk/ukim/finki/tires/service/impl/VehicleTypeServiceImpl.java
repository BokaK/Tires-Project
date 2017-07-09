package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.VehicleType;
import mk.ukim.finki.tires.persistence.VehicleTypeRepository;
import mk.ukim.finki.tires.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 04.6.2017.
 */
@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {

    private final VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    public VehicleTypeServiceImpl(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    @Override
    public List<VehicleType> findAll() {
        return (List<VehicleType>) vehicleTypeRepository.findAll();
    }

    @Override
    public VehicleType findById(Long id) {
        return vehicleTypeRepository.findOne(id);
    }

    @Override
    public void insert(VehicleType entity) {
        vehicleTypeRepository.save(entity);
    }

    @Override
    public void update(Long id, VehicleType entity) {
        vehicleTypeRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        vehicleTypeRepository.delete(id);
    }
}
