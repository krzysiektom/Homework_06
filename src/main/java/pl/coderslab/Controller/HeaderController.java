package pl.coderslab.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeaderController {

    @GetMapping("/showUserAgent")
    public String userAgent(@RequestHeader("user-agent") String userAgent, Model model) {
        System.out.println(userAgent);
        model.addAttribute("userAgent",userAgent);
        return "userAgent.jsp"; //zwracany jsp
    }
}
