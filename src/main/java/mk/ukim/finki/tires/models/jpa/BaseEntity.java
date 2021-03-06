package mk.ukim.finki.tires.models.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}