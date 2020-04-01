package com.hlx.nutritionist.controller;

import com.hlx.nutritionist.entity.TbProductEntity;
import com.hlx.nutritionist.entity.view.ProductView;
import com.hlx.nutritionist.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 商品管理
 * @Author WQY
 * @Date 2020/3/30 16:28
 * @Version 1.0
 */
@Controller
@RequestMapping("/pc")
public class ProductController {

    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    /**
     * 跳转至商品管理页面
     * @return
     */
    @RequestMapping("/toproduct")
    @ResponseBody
    public ModelAndView toProduct(){

        return new ModelAndView("/html/product");

    }

    /**
     * 获取商品列表数据
     * @return
     */
    @RequestMapping("/getAllProducts")
    @ResponseBody
    public List<TbProductEntity> getAllProducts(){

        return productService.findAllProduct();

    }

    /**
     * 添加商品
     * @return
     */
    @RequestMapping("/addProduct")
    @ResponseBody
    public String addProduct(HttpServletRequest request){

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;

        return productService.addProduct(multipartRequest);

    }

    /**
     * 编辑商品
     * @return
     */
    @RequestMapping("/editProduct")
    @ResponseBody
    public String editProduct(HttpServletRequest request){

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;

        return productService.editProduct(multipartRequest);

    }



    /**
     * 删除商品
     * @return
     */
    @RequestMapping("/deleteProduct")
    @ResponseBody
    public String deleteProduct(Long id){

        return productService.deleteProduct(id);

    }

    /**
     * 获取商品信息
     * @return
     */
    @RequestMapping("/getProductInfo")
    @ResponseBody
    public ProductView getProductInfo(Long id){

        return productService.getProductInfo(id);

    }

}
