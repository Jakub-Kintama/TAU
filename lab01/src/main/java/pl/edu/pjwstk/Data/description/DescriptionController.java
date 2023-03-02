package pl.edu.pjwstk.Data.description;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DescriptionController {
    @Autowired
    private DescriptionService service;

    @GetMapping("/get/{id}")
    public String showDescription(@PathVariable int id, Model model){
        Description description = service.findById(id);
        model.addAttribute("description", description);

        return "description";
    }
}
