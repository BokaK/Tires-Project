package mk.ukim.finki.tires.persistence;

import mk.ukim.finki.tires.models.jpa.Tire;
import mk.ukim.finki.tires.models.jpa.TireImage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 02.6.2017.
 */
@Repository
public interface TireImageRepository extends CrudRepository<TireImage,Long> {
    TireImage findByTireId(Long id);
}
