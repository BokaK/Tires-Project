package mk.ukim.finki.tires.persistence;

import mk.ukim.finki.tires.models.jpa.VehicleType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 04.6.2017.
 */
@Repository
public interface VehicleTypeRepository extends CrudRepository<VehicleType, Long>{
}
