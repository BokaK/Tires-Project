package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.VehicleType;
import mk.ukim.finki.tires.service.VehicleTypeService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by user on 04.6.2017.
 */
@RestController
@RequestMapping(value = "/vehicleType", produces = "application/json")
public class VehicleTypeResource implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        VehicleTypeService bean = applicationContext.getBean(VehicleTypeService.class);
        System.out.println(bean);
    }

    private VehicleTypeService service;

    @Autowired
    public VehicleTypeResource(VehicleTypeService service)
    {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody VehicleType vehicleType) {
        service.insert(vehicleType);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody VehicleType vehicleType) {
        service.update(id, vehicleType);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<VehicleType > getAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public VehicleType getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }


}

