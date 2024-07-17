package com.github.somethingaw.dynconfigspringbootstarter.service;

import com.github.somethingaw.dynconfigspringbootstarter.property.IProperty;

import java.util.Map;

/**
 * IConfig
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/8 15:18
 **/
public interface IConfig {

    /**
     * 获取所有配置属性
     *
     * @return
     */
    Map<String, IProperty> getAllProp();

    /**
     * 获取某类配置属性
     *
     * @param propName
     * @return
     */
    IProperty getOneProp(String propName);

    /**
     * 设置某个配置的某个属性
     *
     * @param propName
     * @param key
     * @param value
     * @return
     */
    boolean updateProp(String propName, String key, Object value);

    boolean persist(String propName);

}
