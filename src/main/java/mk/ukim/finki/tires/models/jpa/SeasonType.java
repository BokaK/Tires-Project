package mk.ukim.finki.tires.models.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by user on 03.6.2017.
 */
@Entity
@Table(name="seasonType")
public class SeasonType extends BaseEntity {

    private String seasonType;

    public String getSeasonType() {
        return seasonType;
    }

    public void setSeasonType(String seasonType) {
        this.seasonType = seasonType;
    }
}
