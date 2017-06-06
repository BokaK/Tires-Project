package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.Tire;
import mk.ukim.finki.tires.models.jpa.TireImage;
import mk.ukim.finki.tires.service.TireImageService;
import mk.ukim.finki.tires.service.TireService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.List;

/**
 * Created by user on 02.6.2017.
 */
@RestController
@RequestMapping(value = "/admin/tireImage", produces = "application/json")
public class TireImageResource implements ApplicationContextAware{

    public final TireImageService tireImageService;
    public final TireService tireService;

    public TireImageResource(TireImageService tireImageService, TireService tireService) {
        this.tireImageService = tireImageService;
        this.tireService = tireService;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        TireImageService bean = applicationContext.getBean(TireImageService.class);
        System.out.println(bean);
    }

    @RequestMapping(value="/",  method = RequestMethod.POST)
    public void insert(MultipartHttpServletRequest request, HttpServletResponse response) {

        Iterator<String> itr=request.getFileNames();
        MultipartFile file=request.getFile(itr.next());

        Long id = Long.valueOf(request.getParameter("tire"));
        Tire tire = tireService.findById(id);

        String url = tireImageService.savePicture(file);

        TireImage tireImage = new TireImage();
        tireImage.setImageUrl(url);
        tireImage.setTire(tire);

        tireImageService.insert(tireImage);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody TireImage tireImage) {
        tireImageService.update(id, tireImage);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TireImage> getAll() {
        return tireImageService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TireImage getById(@PathVariable Long id) {
        return tireImageService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        tireImageService.deleteById(id);
    }



}
