package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.ContactInfo;
import mk.ukim.finki.tires.models.jpa.DeliveryInfo;
import mk.ukim.finki.tires.models.jpa.User;
import mk.ukim.finki.tires.service.ContactInfoService;
import mk.ukim.finki.tires.service.DeliveryInfoService;
import mk.ukim.finki.tires.service.UserService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by user on 13.7.2017.
 */
@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserResource implements ApplicationContextAware {

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        UserService bean = applicationContext.getBean(UserService.class);
        System.out.println(bean);
    }

    private UserService service;
    private ContactInfoService contactInfoService;
    private DeliveryInfoService deliveryInfoService;

    @Autowired
    public UserResource(UserService service, ContactInfoService contactInfoService, DeliveryInfoService deliveryInfoService)
    {
        this.service = service;
        this.contactInfoService = contactInfoService;
        this.deliveryInfoService = deliveryInfoService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody User user) {

        ContactInfo contact = new ContactInfo();
        contact.setFirstName(user.contactInfo.getFirstName());
        contact.setLastName(user.contactInfo.getLastName());
        contact.setPhone(user.contactInfo.getPhone());
        user.contactInfo = contact;
        contactInfoService.insert(contact);

        DeliveryInfo delivery = new DeliveryInfo();
        delivery.setAddress(user.deliveryInfo.getAddress());
        delivery.setCity(user.deliveryInfo.getCity());
        user.deliveryInfo = delivery;
        deliveryInfoService.insert(delivery);

        service.insert(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody User user) {
        service.update(id, user);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAll() {
        return service.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }


}
