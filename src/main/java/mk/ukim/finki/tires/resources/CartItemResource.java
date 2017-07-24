package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.CartItem;
import mk.ukim.finki.tires.service.CartItemService;
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
@RequestMapping(value = "/admin/cartItem", produces = "application/json")
public class CartItemResource implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        CartItemService bean = applicationContext.getBean(CartItemService.class);
        System.out.println(bean);
    }
    private CartItemService cartItemService;

    @Autowired
    public CartItemResource(CartItemService cartItemService){
        this.cartItemService = cartItemService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody CartItem cartItem) {
        cartItemService.insert(cartItem);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody CartItem cartItem) {
        cartItemService.update(id, cartItem);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<CartItem> getAll() {
        return cartItemService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CartItem getById(@PathVariable Long id) {
        return cartItemService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        cartItemService.deleteById(id);
    }


    @RequestMapping(value = "/cartId/{id}", method = RequestMethod.GET)
    public List<CartItem> getByCartId(@PathVariable Long id) {
        return cartItemService.findByCartId(id);
    }

}
