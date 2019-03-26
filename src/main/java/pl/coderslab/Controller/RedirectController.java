package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectController {

    @GetMapping("/first")
    public String first() {
        return "first.jsp";
    }
    @GetMapping("/third")
    public String third() {
        return "third.jsp";
    }
    @GetMapping("/second")
    public String second() {
        return "redirect:http://localhost:8080/third";
    }

}
