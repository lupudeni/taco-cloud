package sia.tacocloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private static final String HOME = "home";

    @GetMapping("/")
    public String home() {
        return HOME;
    }
}
