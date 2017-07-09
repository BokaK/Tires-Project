package mk.ukim.finki.tires.service;

import mk.ukim.finki.tires.models.jpa.Inches;

import java.util.List;

/**
 * Created by user on 09.7.2017.
 */
public interface InchesService {

    List<Inches> findAll();
    Inches findById(Long id);
    Inches insert(Inches entity);
    Inches update(Long id, Inches entity);
    void deleteById(Long id);
}

