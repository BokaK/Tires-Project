package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.Width;
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
@RequestMapping(value = "/admin/width", produces = "application/json")
public class WidthResource implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        WidthService bean = applicationContext.getBean(WidthService.class);
        System.out.println(bean);
    }

    private WidthService service;

    @Autowired
    public WidthResource(WidthService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody Width width) {
        service.insert(width);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody Width width) {
        service.update(id, width);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Width> getAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Width getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
