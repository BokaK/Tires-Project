package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.Brand;
import mk.ukim.finki.tires.models.jpa.Height;
import mk.ukim.finki.tires.service.BrandService;
import mk.ukim.finki.tires.service.HeightService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by user on 09.7.2017.
 */
@RestController
@RequestMapping(value = "/admin/height", produces = "application/json")
public class HeightResource implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        HeightService bean = applicationContext.getBean(HeightService.class);
        System.out.println(bean);
    }

    private HeightService service;

    @Autowired
    public HeightResource(HeightService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody Height height) {
        service.insert(height);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody Height height) {
        service.update(id, height);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Height> getAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Height getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}


