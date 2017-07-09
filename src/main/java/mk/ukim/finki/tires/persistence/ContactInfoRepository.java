package mk.ukim.finki.tires.persistence;

import mk.ukim.finki.tires.models.jpa.ContactInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Simona on 7/10/2017.
 */
@Repository
public interface ContactInfoRepository extends CrudRepository<ContactInfo,Long> {
}
