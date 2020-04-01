package com.hlx.nutritionist.service;

import com.hlx.nutritionist.entity.TbProductEntity;
import com.hlx.nutritionist.entity.view.ProductMallView;
import com.hlx.nutritionist.entity.view.ProductView;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

/**
 * @Author WQY
 * @Date 2020/3/30 17:16
 * @Version 1.0
 */
public interface ProductService {

    /**
     * 查询所有商品
     * @return
     */
    List<TbProductEntity> findAllProduct();

    /**
     * 查询前三个上架商品
     * @return
     */
    List<ProductMallView> findAllProductLimit3();

    /**
     * 添加商品
     * @param multipartRequest
     * @return
     */
    String addProduct(MultipartHttpServletRequest multipartRequest);

    /**
     * 删除商品
     * @param id
     * @return
     */
    String deleteProduct(Long id);

    /**
     * 根据商品ID查询商品
     * @return
     */
    ProductView getProductInfo(Long id);

    /**
     * 编辑商品
     * @param multipartRequest
     * @return
     */
    String editProduct(MultipartHttpServletRequest multipartRequest);
}
