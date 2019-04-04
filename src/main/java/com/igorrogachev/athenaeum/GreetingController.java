package com.igorrogachev.athenaeum;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    // @GetMapping("/greeting")
    @GetMapping
    public String greeting(
        @RequestParam(name="name", required=false, defaultValue="World # Земля ")
        String name,
        Model model
    )
    {
        model.addAttribute("name", name);
        return "greeting";
    }

    /*
    @GetMapping
    public String main(
            @RequestParam(name="someMessage", required=false, defaultValue="Bad boy +++ # Редиска +++")
            String someMessage,
            Model model
    )
    {
        model.addAttribute("someMessage", someMessage);
        return "main";
    }
    */
}
