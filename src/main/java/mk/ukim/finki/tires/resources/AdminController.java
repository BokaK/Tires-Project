package mk.ukim.finki.tires.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by user on 03.7.2017.
 */
@Controller
public class AdminController {
    @RequestMapping(value="/admin",method = RequestMethod.GET)
    public String home() {
        return "admin";
    }
}
