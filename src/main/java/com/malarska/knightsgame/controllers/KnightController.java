package com.malarska.knightsgame.controllers;

import com.malarska.knightsgame.domain.Knight;
import com.malarska.knightsgame.domain.repository.KnightRepository;
import com.malarska.knightsgame.service.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService knightService;

    @RequestMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> allKnights = knightService.getAllKnights();
        model.addAttribute("knights", allKnights);
        return "knights";
    }

}
