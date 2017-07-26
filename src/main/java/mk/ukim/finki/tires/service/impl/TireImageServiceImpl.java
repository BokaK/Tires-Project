package mk.ukim.finki.tires.service.impl;

import mk.ukim.finki.tires.models.jpa.Tire;
import mk.ukim.finki.tires.models.jpa.TireImage;
import mk.ukim.finki.tires.persistence.TireImageRepository;
import mk.ukim.finki.tires.service.TireImageService;
import mk.ukim.finki.tires.service.TireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Created by user on 02.6.2017.
 */
@Service
public class TireImageServiceImpl implements TireImageService {


    private String URL_PATTERN = "/images/";
    //private String URL_PATTERN = "C:/opt/tomcat/lib/Tires-Project/images/";

    public final TireImageRepository tireImageRepository;

    @Autowired
    public TireImageServiceImpl(TireImageRepository tireImageRepository) {
        this.tireImageRepository = tireImageRepository;
    }

    @Override
    public List<TireImage> findAll() {
        return (List<TireImage>) tireImageRepository.findAll();
    }

    @Override
    public TireImage findById(Long id) {
        return tireImageRepository.findOne(id);
    }

    @Override
    public TireImage insert(TireImage entity) {
        return tireImageRepository.save(entity);
    }

    @Override
    public TireImage update(Long id, TireImage entity) {
        return tireImageRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {

        TireImage tireImage = tireImageRepository.findOne(id);
        if(tireImage.getImageUrl() != null)
        {
            File f = new File(tireImage.getImageUrl());
            f.delete();
        }
        tireImageRepository.delete(id);
    }


    @Override
    public String savePicture(MultipartFile file) {
        String destLocation;
        if(file.isEmpty())
        {
            return null;
        }

        try{
            if (!new File(URL_PATTERN). exists()) {
                new File(URL_PATTERN).mkdirs( );
            }

            String orgName = file.getOriginalFilename();
            String ext = orgName.split("\\.")[1];

            String newNamePart1 = UUID.randomUUID().toString();
            String newNamePart2 = UUID.randomUUID().toString();
            String newName = String.format("%s-%s.%s", newNamePart1, newNamePart2, ext);
            destLocation = String.format(URL_PATTERN+newName);

            File dest = new File(destLocation);
            file.transferTo(dest);

        }
        catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

        return destLocation;
    }

    @Override
    public TireImage getByTireId(Long id) {

        return tireImageRepository.findByTireId(id);
    }

}
