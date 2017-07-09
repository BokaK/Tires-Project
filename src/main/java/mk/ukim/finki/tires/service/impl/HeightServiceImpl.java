package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.Height;
import mk.ukim.finki.tires.persistence.HeightRepository;
import mk.ukim.finki.tires.service.HeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 09.7.2017.
 */
@Service
public class HeightServiceImpl implements HeightService {

    private final HeightRepository heightRepository;

    @Autowired
    public HeightServiceImpl(HeightRepository heightRepository) {
        this.heightRepository = heightRepository;
    }

    @Override
    public List<Height> findAll() {
        return (List<Height>) heightRepository.findAll();
    }

    @Override
    public Height findById(Long id) {
        return heightRepository.findOne(id);
    }

    @Override
    public Height insert(Height entity) {
        return heightRepository.save(entity);
    }

    @Override
    public Height update(Long id, Height entity) {
        return heightRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        heightRepository.delete(id);
    }
}
