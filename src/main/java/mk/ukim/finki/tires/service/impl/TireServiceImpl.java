package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.Tire;
import mk.ukim.finki.tires.models.jpa.TireImage;
import mk.ukim.finki.tires.persistence.TireImageRepository;
import mk.ukim.finki.tires.persistence.TireRepository;
import org.springframework.stereotype.Service;
import mk.ukim.finki.tires.service.TireService;

import java.io.File;
import java.util.List;

/**
 * Created by user on 31.5.2017.
 */
@Service
public class TireServiceImpl implements TireService {

    private final TireRepository tireRepository;
    private final TireImageRepository tireImageRepository;

    public TireServiceImpl(TireRepository tireRepository, TireImageRepository tireImageRepository) {
        this.tireRepository = tireRepository;
        this.tireImageRepository = tireImageRepository;
    }

    @Override
    public List<Tire> findAll() {
        return (List<Tire>) tireRepository.findAll();
    }

    @Override
    public Tire findById(Long id) {
        return tireRepository.findOne(id);
    }

    @Override
    public Tire insert(Tire entity) {
        return tireRepository.save(entity);
    }

    @Override
    public Tire update(Long id, Tire entity) {
        return tireRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        Tire tire = tireRepository.findOne(id);
        TireImage tireImage = tireImageRepository.findByTireId(tire.id);
        if(tireImage != null)
        {
            if(tireImage.getImageUrl() != null)
            {
                File f = new File(tireImage.getImageUrl());
                f.delete();
            }
            tireImageRepository.delete(tireImage.id);
        }


        tireRepository.delete(id);

    }

}
