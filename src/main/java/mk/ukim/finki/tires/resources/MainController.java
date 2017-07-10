package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.*;
import mk.ukim.finki.tires.service.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.sql.SQLException;
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

    private TireImageService tireImageService;

    @Autowired
    public MainController(TireService service, SeasonTypeService seasonTypeService, BrandService brandService,
                          WidthService widthService, HeightService heightService, InchesService inchesService,
                          TireImageService tireImageService)
    {
        this.brandService = brandService;
        this.service = service;
        this.seasonTypeService = seasonTypeService;
        this.widthService = widthService;
        this.heightService = heightService;
        this.inchesService = inchesService;
        this.tireImageService = tireImageService;
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

    @RequestMapping(value = "/tireImage/tire/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void getTireImageByTireId(@PathVariable Long id, HttpServletResponse response) throws IOException, SQLException {
        TireImage tireImage = tireImageService.getByTireId(id);
        InputStream in = null;
        OutputStream out = null;

        File file = new File(tireImage.getImageUrl());
        String contentDisposition = String.format("inline;filename=\"%s\"",
                file.getName() + "?tireId=" + id);
        byte fileContent[] = new byte[(int)file.length()];

        try {

            in = new FileInputStream(file);
            out = response.getOutputStream();


            in.read(fileContent);
            ByteArrayInputStream bin = new ByteArrayInputStream(fileContent);

            response.setHeader("Content-Disposition", contentDisposition);
            response.setContentType(Files.probeContentType(file.toPath()));
            response.setContentLength((int) file.length());

            IOUtils.copy(bin, out);

        }
        catch (IOException e) {

        }
        finally {
            if(in!=null) {
                in.close();
            }
            if(out!=null)
            {
                out.flush();
                out.close();
            }
        }

    }
}
