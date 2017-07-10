package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.ContactInfo;
import mk.ukim.finki.tires.service.CheckoutService;
import mk.ukim.finki.tires.service.ContactInfoService;
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
@RequestMapping(value = "/admin/contactInfo", produces = "application/json")
public class ContactInfoResources implements ApplicationContextAware {
    private ContactInfoService contactInfoService;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ContactInfoService bean = applicationContext.getBean(ContactInfoService.class);
        System.out.println(bean);
    }


    @Autowired
    public ContactInfoResources(ContactInfoService contactInfoService) {
        this.contactInfoService = contactInfoService;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void insert(@Valid @RequestBody ContactInfo contactInfo) {
        contactInfoService.insert(contactInfo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, @RequestBody ContactInfo contactInfo) {
        contactInfoService.update(id, contactInfo);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ContactInfo> getAll() {
        return contactInfoService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ContactInfo getById(@PathVariable Long id) {
        return contactInfoService.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable Long id) {
        contactInfoService.deleteById(id);
    }
}
