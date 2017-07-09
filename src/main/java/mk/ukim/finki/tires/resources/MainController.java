package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.*;
import mk.ukim.finki.tires.service.*;
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

    private SeasonTypeService seasonTypeService;

    private BrandService brandService;

    private WidthService widthService;

    private HeightService heightService;

    private InchesService inchesService;

    @Autowired
    public MainController(TireService service, SeasonTypeService seasonTypeService, BrandService brandService,
                          WidthService widthService, HeightService heightService, InchesService inchesService)
    {
        this.brandService = brandService;
        this.service = service;
        this.seasonTypeService = seasonTypeService;
        this.widthService = widthService;
        this.heightService = heightService;
        this.inchesService = inchesService;
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        TireService bean = applicationContext.getBean(TireService.class);
        System.out.println(bean);
    }

    @RequestMapping(value = "/tires", method = RequestMethod.GET)
    public List<Tire> getAllTires() {
        return service.findAll();
    }

    @RequestMapping(value = "/seasonTypes", method = RequestMethod.GET)
    public List<SeasonType> getAllSeasonTypes() {
        return seasonTypeService.findAll();
    }

    @RequestMapping(value = "/brands", method = RequestMethod.GET)
    public List<Brand> getAllBrands() {
        return brandService.findAll();
    }

    @RequestMapping(value = "/widths", method = RequestMethod.GET)
    public List<Width> getAllWidths() {
        return widthService.findAll();
    }

    @RequestMapping(value = "/heights", method = RequestMethod.GET)
    public List<Height> getAllHeights() {
        return heightService.findAll();
    }

    @RequestMapping(value = "/inches", method = RequestMethod.GET)
    public List<Inches> getAllInches() {
        return inchesService.findAll();
    }
}
