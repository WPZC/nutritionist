package com.hlx.nutritionist.controller.mall;

import com.hlx.nutritionist.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author WQY
 * @Date 2020/4/1 11:13
 * @Version 1.0
 */
@Controller
@RequestMapping("/mac")
public class MallController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/tomallindex")
    @ResponseBody
    public ModelAndView toMallIndex(){

        ModelAndView view = new ModelAndView("/mall/index");

        view.addObject("products",productService.findAllProductLimit3());

        return view;

    }

}
