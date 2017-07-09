package mk.ukim.finki.tires.persistence;

import mk.ukim.finki.tires.models.jpa.Width;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 09.7.2017.
 */
@Repository
public interface WidthRepository extends CrudRepository<Width,Long> {
}
