package mk.ukim.finki.tires.service;

import mk.ukim.finki.tires.models.jpa.Height;

import java.util.List;

/**
 * Created by user on 09.7.2017.
 */
public interface HeightService {

    List<Height> findAll();
    Height findById(Long id);
    Height insert(Height entity);
    Height update(Long id, Height entity);
    void deleteById(Long id);
}
