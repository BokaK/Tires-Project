package mk.ukim.finki.tires.resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class FrontendController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String home() {
        return "index";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login(Model model, HttpSession session, @RequestParam(required = false) String error) {
//        if (session.getAttribute("user") != null) {
//            return "redirect:/";
//        }

        return "/views/login";
    }
}
