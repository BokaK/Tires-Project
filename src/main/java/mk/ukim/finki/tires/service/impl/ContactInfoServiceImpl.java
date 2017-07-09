package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.ContactInfo;
import mk.ukim.finki.tires.persistence.ContactInfoRepository;
import mk.ukim.finki.tires.service.ContactInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Simona on 7/10/2017.
 */
@Service
public class ContactInfoServiceImpl implements ContactInfoService{
    private final ContactInfoRepository contactInfoRepository;

    @Autowired
    public ContactInfoServiceImpl(ContactInfoRepository contactInfoRepository) {
        this.contactInfoRepository = contactInfoRepository;
    }

    @Override
    public List<ContactInfo> findAll() {
        return (List<ContactInfo>) contactInfoRepository.findAll();
    }

    @Override
    public ContactInfo findById(Long id) {
        return contactInfoRepository.findOne(id);
    }

    @Override
    public void insert(ContactInfo entity) {
        contactInfoRepository.save(entity);
    }

    @Override
    public void update(Long id, ContactInfo entity) {
        contactInfoRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        contactInfoRepository.delete(id);
    }
}
