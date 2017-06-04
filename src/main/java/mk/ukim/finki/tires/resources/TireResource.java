package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.Tire;
import mk.ukim.finki.tires.service.TireService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by user on 01.6.2017.
 */

@RestController
@RequestMapping(value = "/tires", produces = "application/json")
public class TireResource implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        TireService bean = applicationContext.getBean(TireService.class);
        System.out.println(bean);
    }

    private TireService service;

    @Autowired
    public TireResource(TireService service)
    {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Tire insert(@Valid @RequestBody Tire tire) {
        return service.insert(tire);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody Tire tire) {
        service.update(id, tire);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Tire> getAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Tire getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
