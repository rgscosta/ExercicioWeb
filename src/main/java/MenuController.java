import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("mensagem", "CRUD de Contatos com Spring MVC");
        return "index";
    }

    @GetMapping("/home2")
    public ModelAndView home2() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("mensagem", "ModelAndView: CRUD de Contatos com Spring MVC");
        return mv;
    }
}
