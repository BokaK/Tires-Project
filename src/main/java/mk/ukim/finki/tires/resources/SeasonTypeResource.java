package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.SeasonType;
import mk.ukim.finki.tires.models.jpa.Tire;
import mk.ukim.finki.tires.service.SeasonTypeService;
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
 * Created by user on 03.6.2017.
 */
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

@RestController
@RequestMapping(value = "/seasonType", produces = "application/json")
public class SeasonTypeResource implements ApplicationContextAware {

        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            SeasonTypeService bean = applicationContext.getBean(SeasonTypeService.class);
            System.out.println(bean);
        }

        private SeasonTypeService service;

        @Autowired
        public SeasonTypeResource(SeasonTypeService service)
        {
            this.service = service;
        }

        @RequestMapping(value = "/", method = RequestMethod.POST)
        @ResponseStatus(HttpStatus.CREATED)
        public void insert(@Valid @RequestBody SeasonType seasonType) {
            service.insert(seasonType);
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
        public void update(@PathVariable Long id, @RequestBody SeasonType seasonType) {
            service.update(id, seasonType);
        }

        @RequestMapping(value = "/", method = RequestMethod.GET)
        public List<SeasonType> getAll() {
            return service.findAll();
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.GET)
        public SeasonType getById(@PathVariable Long id) {
            return service.findById(id);
        }

        @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
        public void deleteById(@PathVariable Long id) {
            service.deleteById(id);
        }


}
