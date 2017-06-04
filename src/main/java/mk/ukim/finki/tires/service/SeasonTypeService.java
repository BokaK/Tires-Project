package mk.ukim.finki.tires.service;

import mk.ukim.finki.tires.models.jpa.SeasonType;
import mk.ukim.finki.tires.models.jpa.TireImage;

import java.util.List;

/**
 * Created by user on 03.6.2017.
 */
public interface SeasonTypeService {
    List<SeasonType> findAll();
    SeasonType findById(Long id);
    void insert(SeasonType entity);
    void update(Long id, SeasonType entity);
    void deleteById(Long id);
}
