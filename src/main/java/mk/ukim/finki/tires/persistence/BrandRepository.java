package mk.ukim.finki.tires.persistence;

import mk.ukim.finki.tires.models.jpa.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 03.6.2017.
 */
@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {
}
