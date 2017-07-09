package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.Brand;
import mk.ukim.finki.tires.models.jpa.Inches;
import mk.ukim.finki.tires.models.jpa.Width;
import mk.ukim.finki.tires.service.BrandService;
import mk.ukim.finki.tires.service.InchesService;
import mk.ukim.finki.tires.service.WidthService;
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
@RequestMapping(value = "/admin/inches", produces = "application/json")
public class InchesResource implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        InchesService bean = applicationContext.getBean(InchesService.class);
        System.out.println(bean);
    }

    private InchesService service;

    @Autowired
    public InchesResource(InchesService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody Inches inches) {
        service.insert(inches);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody Inches inches) {
        service.update(id, inches);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Inches> getAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Inches getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
