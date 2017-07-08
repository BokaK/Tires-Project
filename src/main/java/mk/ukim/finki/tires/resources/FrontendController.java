package mk.ukim.finki.tires.resources;

import mk.ukim.finki.tires.models.jpa.Tire;
import mk.ukim.finki.tires.service.TireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class FrontendController {


    @RequestMapping(value="/",method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(@RequestParam(required = false) String error) {

        return "/views/login";
    }
}
