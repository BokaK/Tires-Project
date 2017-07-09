package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.Inches;
import mk.ukim.finki.tires.persistence.InchesRepository;
import mk.ukim.finki.tires.service.InchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 09.7.2017.
 */
@Service
public class InchesServiceImpl implements InchesService {

    private final InchesRepository inchesRepository;

    @Autowired
    public InchesServiceImpl(InchesRepository inchesRepository) {
        this.inchesRepository = inchesRepository;
    }

    @Override
    public List<Inches> findAll() {
        return (List<Inches>) inchesRepository.findAll();
    }

    @Override
    public Inches findById(Long id) {
        return inchesRepository.findOne(id);
    }

    @Override
    public Inches insert(Inches entity) {
        return inchesRepository.save(entity);
    }

    @Override
    public Inches update(Long id, Inches entity) {
        return inchesRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        inchesRepository.delete(id);
    }
}
