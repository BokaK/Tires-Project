package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.DeliveryInfo;
import mk.ukim.finki.tires.persistence.DeliveryInfoRepository;
import mk.ukim.finki.tires.service.DeliveryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Simona on 7/10/2017.
 */
@Service
public class DeliveryInfoServiceImpl implements DeliveryInfoService {
    private final DeliveryInfoRepository deliveryInfoRepository;

    @Autowired
    public DeliveryInfoServiceImpl(DeliveryInfoRepository deliveryInfoRepository) {
        this.deliveryInfoRepository = deliveryInfoRepository;
    }

    @Override
    public List<DeliveryInfo> findAll() {
        return (List<DeliveryInfo>) deliveryInfoRepository.findAll();
    }

    @Override
    public DeliveryInfo findById(Long id) {
        return deliveryInfoRepository.findOne(id);
    }

    @Override
    public void insert(DeliveryInfo entity) {
        deliveryInfoRepository.save(entity);
    }

    @Override
    public void update(Long id, DeliveryInfo entity) {
        deliveryInfoRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        deliveryInfoRepository.delete(id);
    }
}
