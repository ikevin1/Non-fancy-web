package springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/about")
public class PageController {
    public String showAboutPage() {
        return "about";
    }
}
