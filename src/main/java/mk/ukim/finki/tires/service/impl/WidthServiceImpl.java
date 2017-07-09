package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.Width;
import mk.ukim.finki.tires.persistence.WidthRepository;
import mk.ukim.finki.tires.service.WidthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 09.7.2017.
 */
@Service
public class WidthServiceImpl implements WidthService {

    private final WidthRepository widthRepository;

    @Autowired
    public WidthServiceImpl(WidthRepository widthRepository) {
        this.widthRepository = widthRepository;
    }

    @Override
    public List<Width> findAll() {
        return (List<Width>)widthRepository.findAll();
    }

    @Override
    public Width findById(Long id) {
        return widthRepository.findOne(id);
    }

    @Override
    public Width insert(Width entity) {
        return widthRepository.save(entity);
    }

    @Override
    public Width update(Long id, Width entity) {
        return widthRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        widthRepository.delete(id);
    }
}
