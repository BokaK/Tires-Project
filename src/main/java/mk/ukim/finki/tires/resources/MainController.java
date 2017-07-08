package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.Tire;
import mk.ukim.finki.tires.service.TireService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by user on 08.7.2017.
 */

@RestController
@RequestMapping(value = "/", produces = "application/json")
public class MainController  implements ApplicationContextAware {

    private TireService service;

    @Autowired
    public MainController(TireService service)
    {
        this.service = service;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        TireService bean = applicationContext.getBean(TireService.class);
        System.out.println(bean);
    }

    @RequestMapping(value = "/tires", method = RequestMethod.GET)
    public List<Tire> getAll() {
        return service.findAll();
    }
}
