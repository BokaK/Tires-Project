package mk.ukim.finki.tires.service;

import mk.ukim.finki.tires.models.jpa.DeliveryInfo;

import java.util.List;

/**
 * Created by Simona on 7/10/2017.
 */
public interface DeliveryInfoService {
    List<DeliveryInfo> findAll();
    DeliveryInfo findById(Long id);
    void insert(DeliveryInfo entity);
    void update(Long id,DeliveryInfo entity);
    void deleteById(Long id);
}
