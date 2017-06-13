package mk.ukim.finki.tires.service;

import mk.ukim.finki.tires.models.jpa.TireImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by user on 02.6.2017.
 */
public interface TireImageService {
    List<TireImage> findAll();
    TireImage findById(Long id);
    TireImage insert(TireImage entity);
    TireImage update(Long id, TireImage entity);
    void deleteById(Long id);

    String savePicture(MultipartFile file);

    TireImage getByTireId(Long id);
}
