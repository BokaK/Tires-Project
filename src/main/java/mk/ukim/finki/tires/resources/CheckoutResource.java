package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.Checkout;
import mk.ukim.finki.tires.service.CheckoutService;
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
@RequestMapping(value = "/admin/checkout", produces = "application/json")
public class CheckoutResource implements ApplicationContextAware{

    private CheckoutService checkoutService;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CheckoutService bean = applicationContext.getBean(CheckoutService.class);
        System.out.println(bean);
    }

    @Autowired
    public CheckoutResource(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody Checkout checkout) {
        checkoutService.insert(checkout);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody Checkout checkout) {
        checkoutService.update(id, checkout);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Checkout> getAll() {
        return checkoutService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Checkout getById(@PathVariable Long id) {
        return checkoutService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        checkoutService.deleteById(id);
    }
}
