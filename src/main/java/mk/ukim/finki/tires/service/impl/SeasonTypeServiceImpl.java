package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.SeasonType;
import mk.ukim.finki.tires.persistence.SeasonTypeRepository;
import mk.ukim.finki.tires.service.SeasonTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 03.6.2017.
 */
@Service
public class SeasonTypeServiceImpl implements SeasonTypeService {

    private final SeasonTypeRepository seasonTypeRepository;

    public SeasonTypeServiceImpl(SeasonTypeRepository seasonTypeRepository) {
        this.seasonTypeRepository = seasonTypeRepository;
    }

    @Override
    public List<SeasonType> findAll() {
        return (List<SeasonType>) seasonTypeRepository.findAll();
    }

    @Override
    public SeasonType findById(Long id) {
        return seasonTypeRepository.findOne(id);
    }

    @Override
    public void insert(SeasonType entity) {
        seasonTypeRepository.save(entity);
    }

    @Override
    public void update(Long id, SeasonType entity) {
        seasonTypeRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        seasonTypeRepository.delete(id);
    }
}
