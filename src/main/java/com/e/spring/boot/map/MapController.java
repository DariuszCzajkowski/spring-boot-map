package com.e.spring.boot.map;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MapController {

    private DataRepository dataRepository;

    public MapController(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getMap(Model model) {
        model.addAttribute("pointList", dataRepository.getPointList());
        return "map";
    }

}
