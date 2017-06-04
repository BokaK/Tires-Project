package mk.ukim.finki.tires.models.jpa;

import javax.persistence.*;

/**
 * Created by user on 02.6.2017.
 */
@Entity
@Table(name = "tire_image")
public class TireImage extends BaseEntity {

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "tire_id")
    private Tire tire;

    private String imageUrl;

    public Tire getTire() {
        return tire;
    }

    public void setTire(Tire tire) {
        this.tire = tire;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}