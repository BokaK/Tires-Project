package mk.ukim.finki.tires.persistence;

import mk.ukim.finki.tires.models.jpa.Tire;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 31.5.2017.
 */
@Repository
public interface TireRepository extends CrudRepository<Tire,Long>{
}
