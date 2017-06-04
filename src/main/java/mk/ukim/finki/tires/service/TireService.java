package mk.ukim.finki.tires.service;

import mk.ukim.finki.tires.models.jpa.Tire;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by user on 31.5.2017.
 */
public interface TireService {

    List<Tire> findAll();
    Tire findById(Long id);
    Tire insert(Tire entity);
    Tire update(Long id, Tire entity);
    void deleteById(Long id);

}
