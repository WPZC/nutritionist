package com.hlx.nutritionist.test;

import com.hlx.nutritionist.entity.TbProductEntity;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @Author WQY
 * @Date 2020/3/31 14:46
 * @Version 1.0
 */
public class t1 {

    public static void main(String[] args){

        Field[] fields = TbProductEntity.class.getDeclaredFields();

        try {

            TbProductEntity t = new TbProductEntity();

            Field field = t.getClass().getDeclaredField("sproductr");

            field.setAccessible(true);

            field.set(t,"123");

            System.out.println(t.getSproduct());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
