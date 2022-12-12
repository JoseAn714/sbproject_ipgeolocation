package com.springbootproject.ipgeolocation.controller;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbootproject.ipgeolocation.service.LocationService;

@Controller
public class WebController {

	
    @RequestMapping("/")
	public String showMap(Model model) throws JSONException, IOException {
		
		// esta es la vista de retorno que necesitamos
        model.addAttribute("ip",LocationService.GetIp().getString("ip"));
        model.addAttribute("loc", LocationService.GetIpInfo().getString("loc"));
        model.addAttribute("lat", LocationService.GetIpInfo().getString("loc").split(",")[0]);
        model.addAttribute("lon", LocationService.GetIpInfo().getString("loc").split(",")[1]);
        model.addAttribute("url", LocationService.GenerateUrl().getString("url"));
        model.addAttribute("url_embed", LocationService.GenerateUrlEmbed().getString("url_embed"));
		return "map";
		
	}
    

    // @GetMapping("/greeting") //Esto solo indica es para acceder a la siguiente función solo con operación tipo get
    // public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) { 
    //     Persona p = new Persona();
    //     p.setIdPersona(1);
    //     p.setNombre("Jose");
    //     repo.save(p);
        
    //     model.addAttribute("name", name);
    //     return "greeting"; 
    // }

}
