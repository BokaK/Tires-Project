package mk.ukim.finki.tires.models.jpa;

import mk.ukim.finki.tires.models.jpa.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by user on 31.5.2017.
 */
@Entity
@Table(name="user")
public class User extends BaseEntity {
}
