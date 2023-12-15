package org.example.rzdscanseats.controller;

import org.example.rzdscanseats.model.Carriage;
import org.example.rzdscanseats.model.Route;
import org.example.rzdscanseats.model.Train;
import org.example.rzdscanseats.model.CarriageType;
import org.example.rzdscanseats.service.RouteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping("/add/{userId}")
    public String add(@PathVariable String userId,
                      Model model) {
        model.addAttribute("routeModel", new Route());
        model.addAttribute("trainModel", new Train());
        model.addAttribute("carriageModel", new Carriage());
        model.addAttribute("typeCarriage", CarriageType.values());
        return "routes/add";
    }

    @PostMapping("/add/{userId}")
    public String add(@PathVariable String userId,
                      @ModelAttribute("routeModel") Route tmpRoute,
                      @ModelAttribute("trainModel") Train tmpTrain,
                      @ModelAttribute("carriageModel") Carriage tmpCarriage) {
        tmpTrain.getCarriages().add(tmpCarriage);
        tmpRoute.setTrain(tmpTrain);
        System.out.println(tmpRoute);
        routeService.create(tmpRoute);
        return "redirect:/routes/all/" + userId;
    }

    @GetMapping("/all/{userId}")
    public String all(@PathVariable String userId) {
        return "routes/all";
    }
}
