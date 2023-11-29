package com.example.ghostvillageadmin.app.gacha.controller;

import com.example.ghostvillageadmin.app.utils.PagableDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class GachaController {

    @Operation(summary = "가차 목록 view", hidden = true)
    @GetMapping("/view/gacha")
    public ModelAndView viewGacha(ModelAndView modelAndView) {
        modelAndView.setViewName("gacha/gacha");
        return modelAndView;
    }

    @Operation(summary = "가차 등록 view", hidden = true)
    @GetMapping("/view/gacha/create")
    public ModelAndView viewCreateGacha(ModelAndView modelAndView) {
        modelAndView.setViewName("gacha/create");
        return modelAndView;
    }
}
