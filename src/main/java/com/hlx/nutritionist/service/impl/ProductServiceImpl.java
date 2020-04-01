package com.hlx.nutritionist.service.impl;

import com.hlx.nutritionist.dao.TbProductDao;
import com.hlx.nutritionist.dao.TbProductPicDao;
import com.hlx.nutritionist.entity.TbProductEntity;
import com.hlx.nutritionist.entity.TbProductPicEntity;
import com.hlx.nutritionist.entity.view.ProductMallView;
import com.hlx.nutritionist.entity.view.ProductView;
import com.hlx.nutritionist.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.*;

/**
 * @Author WQY
 * @Date 2020/3/30 17:16
 * @Version 1.0
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private TbProductDao tbProductDao;
    @Autowired
    private TbProductPicDao tbProductPicDao;

    @Override
    public List<TbProductEntity> findAllProduct() {
        return tbProductDao.findAll();
    }

    @Override
    public List<ProductMallView> findAllProductLimit3() {

        List<TbProductEntity> dbRs = tbProductDao.findAllLimit3();

        List<ProductMallView> views = new ArrayList<>();

        for (int i = 0,num=dbRs.size();i<num;i++){

            ProductMallView view = new ProductMallView();

            BeanUtils.copyProperties(dbRs.get(i),view);

            TbProductPicEntity r = tbProductPicDao.findByPIdLimit1(view.getId());

            if(r!=null){
                view.setPicUrl("http://localhost:7501/"+r.getPPicName());
            }else{
                view.setPicUrl("http://localhost:7501/");
            }


            views.add(view);
        }

        return views;
    }

    @Value("${pic.url}")
    private String picurl;

    @Override
    public String addProduct(MultipartHttpServletRequest multipartRequest) {


        //所有参数
        Map<String, String[]> stringMap = multipartRequest.getParameterMap();

        TbProductEntity tb = new TbProductEntity();

        tb.setOntheshelfTime(new Date());
        try {
            tb = setParameter(stringMap,tb);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "添加失败，请检查填入数据是否符合要求";
        }

        TbProductEntity rs = tbProductDao.save(tb);

        if(rs==null){
            return "添加失败，请检查填入数据是否符合要求";
        }
        //所有文件
        MultiValueMap<String, MultipartFile> fileMap = multipartRequest.getMultiFileMap();

        List<TbProductPicEntity> pics = new ArrayList<>();
        // 循环遍历，取出单个文件
        for (String key : fileMap.keySet()) {

            // 获取单个文件
            List<MultipartFile> muls = fileMap.get(key);

            for (int i = 0,num = muls.size();i<num;i++){

                MultipartFile mf = muls.get(i);

                // 文件名
                String fileName = mf.getOriginalFilename();
                // 后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                // 上传后的路径
                String filePath = picurl;
                // 新文件名
                fileName = UUID.randomUUID() + suffixName;
                File dest = new File(filePath + fileName);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    mf.transferTo(dest);
                } catch (IOException e) {
                    e.printStackTrace();
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return "上传图片失败";
                }

                TbProductPicEntity e = new TbProductPicEntity();
                e.setPId(rs.getId());
                e.setPPicName(fileName);

                pics.add(e);
            }
            tbProductPicDao.saveAll(pics);
        }

        return "添加成功";
    }

    @Override
    public String deleteProduct(Long id) {

        int rs = tbProductDao.deleteById(id);

        if(rs>0){

            rs = tbProductPicDao.deleteByPId(id);

            return "删除成功";
        }else {
            throw new RuntimeException("删除失败");
        }


    }

    @Override
    public ProductView getProductInfo(Long id) {

        TbProductEntity tb = tbProductDao.findById(id);

        if(tb!=null){
            List<TbProductPicEntity> tbps = tbProductPicDao.findByPId(tb.getId());

            ProductView view = new ProductView();
            view.setTbProductEntity(tb);
            view.setTbProductPicEntities(tbps);

            return view;
        }

        return null;
    }

    @Override
    public String editProduct(MultipartHttpServletRequest multipartRequest) {

        //所有参数
        Map<String, String[]> stringMap = multipartRequest.getParameterMap();

        TbProductEntity tb = new TbProductEntity();

        tb.setOntheshelfTime(new Date());
        try {
            //修改的时候回传入ID
            tb = setParameter(stringMap,tb);
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return "修改失败，请检查填入数据是否符合要求";
        }

        TbProductEntity rs = tbProductDao.save(tb);

        if(rs==null){
            return "修改失败，请检查填入数据是否符合要求";
        }
        //所有文件
        MultiValueMap<String, MultipartFile> fileMap = multipartRequest.getMultiFileMap();

        List<TbProductPicEntity> pics = new ArrayList<>();
        // 循环遍历，取出单个文件
        for (String key : fileMap.keySet()) {

            // 获取单个文件
            List<MultipartFile> muls = fileMap.get(key);

            for (int i = 0,num = muls.size();i<num;i++){

                MultipartFile mf = muls.get(i);

                // 文件名
                String fileName = mf.getOriginalFilename();
                // 后缀名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));
                // 上传后的路径
                String filePath = picurl;
                // 新文件名
                fileName = UUID.randomUUID() + suffixName;
                File dest = new File(filePath + fileName);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    mf.transferTo(dest);
                } catch (IOException e) {
                    e.printStackTrace();
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return "修改上传图片失败";
                }

                TbProductPicEntity e = new TbProductPicEntity();
                e.setPId(rs.getId());
                e.setPPicName(fileName);

                pics.add(e);
            }
            tbProductPicDao.saveAll(pics);
        }

        return "修改成功";
    }

    /**
     * 设置参数
     * @param map 参数集
     * @param t 对象泛型
     * @param <T>
     * @return
     * @throws Exception
     */
    public <T> T setParameter(Map<String, String[]> map,T t) throws Exception{

        for (String key:map.keySet()){

            Field field = t.getClass().getDeclaredField(key);

            field.setAccessible(true);

            System.out.println(field.getGenericType());

            Type type = field.getGenericType();

            switch (type.toString()){
                case "class java.lang.String":
                    field.set(t,map.get(key)[0]);
                    break;
                case "class java.lang.Double":
                    field.set(t,Double.valueOf(map.get(key)[0]));
                    break;
                case "class java.lang.Long":
                    field.set(t,Long.valueOf(map.get(key)[0]));
                    break;
                case "class java.lang.Integer":
                    field.set(t,Integer.valueOf(map.get(key)[0]));
                    break;

            }

        }

        return t;

    }

}
