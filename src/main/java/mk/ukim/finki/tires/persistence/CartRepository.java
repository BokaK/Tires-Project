package mk.ukim.finki.tires.persistence;

import mk.ukim.finki.tires.models.jpa.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Simona on 7/10/2017.
 */
@Repository
public interface CartRepository extends CrudRepository<Cart,Long> {
}
