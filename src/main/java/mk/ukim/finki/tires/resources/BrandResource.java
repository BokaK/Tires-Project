package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.Brand;
import mk.ukim.finki.tires.service.BrandService;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by user on 03.6.2017.
 */

@RestController
@RequestMapping(value = "/admin/brand", produces = "application/json")
public class BrandResource implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        BrandService bean = applicationContext.getBean(BrandService.class);
        System.out.println(bean);
    }

    private BrandService service;

    @Autowired
    public BrandResource(BrandService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody Brand brand) {
        service.insert(brand);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody Brand brand) {
        service.update(id, brand);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Brand> getAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Brand getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
