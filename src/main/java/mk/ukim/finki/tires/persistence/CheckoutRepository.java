package mk.ukim.finki.tires.persistence;

import mk.ukim.finki.tires.models.jpa.Checkout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Simona on 7/10/2017.
 */
@Repository
public interface CheckoutRepository extends CrudRepository<Checkout,Long>{
}
