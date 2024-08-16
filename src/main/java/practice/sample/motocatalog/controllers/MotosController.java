package practice.sample.motocatalog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import practice.sample.motocatalog.beans.Brand;
import practice.sample.motocatalog.beans.Motorcycle;
import practice.sample.motocatalog.services.MotosService;

@Controller
@Slf4j
public class MotosController {

    @Autowired
    MotosService service;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name, Model model){
        model.addAttribute("name", name);
        return "test";
    }

    @GetMapping("/motos")
    public String motos(Model model) {

        //ブランド
        List<Brand> brands = new ArrayList<>();
        brands = service.getBrands();

        //バイク
        List<Motorcycle> motos = new ArrayList<>();
        motos = service.getMotos();
        
        model.addAttribute("brands", brands);
        model.addAttribute("motos", motos);

        //ログ出力
        log.debug("motos: {}", motos);

        return "moto_list";
    }
}
