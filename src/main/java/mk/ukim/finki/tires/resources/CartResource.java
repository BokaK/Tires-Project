package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.Cart;
import mk.ukim.finki.tires.service.CartService;
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
@RequestMapping(value = "/admin/cart", produces = "application/json")
public class CartResource implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CartService bean = applicationContext.getBean(CartService.class);
        System.out.println(bean);
    }

    private CartService cartService;

    @Autowired
    public CartResource(CartService cartService) {
        this.cartService = cartService;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody Cart cart) {
        cartService.insert(cart);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody Cart cart) {
        cartService.update(id, cart);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Cart> getAll() {
        return cartService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Cart getById(@PathVariable Long id) {
        return cartService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        cartService.deleteById(id);
    }

}
