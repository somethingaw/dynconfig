package com.github.somethingaw.dynconfigspringbootstarter.property;

/**
 * IProperties
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/8 9:15
 **/
public interface IProperty {

    void preDestroy();

    void update(String key, Object value);
}
