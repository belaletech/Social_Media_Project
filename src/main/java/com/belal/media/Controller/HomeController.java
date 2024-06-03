package com.belal.media.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping()
    public String homeControllerHandler()
    {
        return "this is home controller";
    }

    @GetMapping("/home2")
    public String sumoftwo()
    {
        return "sume of";
    }

}
