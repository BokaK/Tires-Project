package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.DeliveryInfo;
import mk.ukim.finki.tires.service.DeliveryInfoService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Simona on 7/10/2017.
 */

@RestController
@RequestMapping(value = "/admin/deliveryInfo", produces = "application/json")
public class DeliveryInfoResource implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        DeliveryInfoService bean = applicationContext.getBean(DeliveryInfoService.class);
        System.out.println(bean);
    }
    private DeliveryInfoService deliveryInfoService;

    @Autowired
    public DeliveryInfoResource(DeliveryInfoService deliveryInfoService){
        this.deliveryInfoService = deliveryInfoService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody DeliveryInfo deliveryInfo) {
        deliveryInfoService.insert(deliveryInfo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody DeliveryInfo deliveryInfo) {
        deliveryInfoService.update(id, deliveryInfo);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<DeliveryInfo> getAll() {
        return deliveryInfoService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public DeliveryInfo getById(@PathVariable Long id) {
        return deliveryInfoService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        deliveryInfoService.deleteById(id);
    }

}
