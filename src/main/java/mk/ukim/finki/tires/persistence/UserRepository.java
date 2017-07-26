package mk.ukim.finki.tires.persistence;

import mk.ukim.finki.tires.models.jpa.ContactInfo;
import mk.ukim.finki.tires.models.jpa.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by user on 31.5.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User,Long>{
    User findByUsername(String username);
    User findByContactInfo(ContactInfo contactInfo);
}
