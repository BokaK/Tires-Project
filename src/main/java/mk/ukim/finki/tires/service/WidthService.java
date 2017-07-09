package mk.ukim.finki.tires.service;

import mk.ukim.finki.tires.models.jpa.Width;

import java.util.List;

/**
 * Created by user on 09.7.2017.
 */
public interface WidthService {

    List<Width> findAll();
    Width findById(Long id);
    Width insert(Width entity);
    Width update(Long id, Width entity);
    void deleteById(Long id);
}
