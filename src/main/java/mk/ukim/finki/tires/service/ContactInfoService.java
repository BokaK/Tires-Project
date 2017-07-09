package mk.ukim.finki.tires.service;

import mk.ukim.finki.tires.models.jpa.ContactInfo;

import java.util.List;

/**
 * Created by Simona on 7/10/2017.
 */
public interface ContactInfoService {
    List<ContactInfo> findAll();
    ContactInfo findById(Long id);
    void insert(ContactInfo entity);
    void update(Long id,ContactInfo entity);
    void deleteById(Long id);
}
