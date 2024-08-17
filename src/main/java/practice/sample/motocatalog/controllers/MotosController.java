package practice.sample.motocatalog.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import lombok.extern.slf4j.Slf4j;
import practice.sample.motocatalog.beans.Brand;
import practice.sample.motocatalog.beans.Motorcycle;
import practice.sample.motocatalog.beans.SearchForm;
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

    /**
     * バイク一覧の検索
     * @param searchForm
     * @param model
     * @return
     */
    @GetMapping("/motos")
    public String motos(@Validated SearchForm searchForm, BindingResult result, Model model) {
        log.info("検索条件: {}", searchForm);
        if (result.hasErrors()) {
            //入力チェックエラーがある場合
            return "moto_list";
        }

        //ブランドリスト
        this.setBrands(model);

        //バイク
        List<Motorcycle> motos = new ArrayList<>();
        motos = service.getMotos(searchForm);

        model.addAttribute("motos", motos);
        model.addAttribute("datetime", LocalDateTime.now());

        //ログ出力
        log.debug("motos: {}", motos);

        return "moto_list";
    }

    /**
     * 検索条件のクリア
     * @param searchForm
     * @param model
     * @return
      */
    @GetMapping("/motos/reset")
    public String reset(SearchForm searchForm, Model model) {
        //ブランドリスト
        this.setBrands(model);
        //ブランドリセット
        searchForm = new SearchForm();
        return "moto_list";
    }

    @GetMapping("/motos/{motoNo}")
    public String initUpdate(Model model) {
        // ブランドリストの準備
        this.setBrands(model);

        return "moto";
    }

    /**
     * ブランドリストをmodelにえっと
     * @param model
     */
    public void setBrands(Model model) {
        //ブランド
        List<Brand> brands = new ArrayList<>();
        brands = service.getBrands();
        model.addAttribute("brands", brands);
    }
}
