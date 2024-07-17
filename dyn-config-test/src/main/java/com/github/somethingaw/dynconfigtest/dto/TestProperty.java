package com.github.somethingaw.dynconfigtest.dto;

import com.github.somethingaw.dynconfigspringbootstarter.property.BaseProperty;
import com.github.somethingaw.dynconfigspringbootstarter.property.IProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TestProperty
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/8 16:11
 **/
@Getter
@Setter
public class TestProperty extends BaseProperty {

    public static final String NAME = "test";

    private String user;

    private Integer age;

    private Map<String, String> map = new HashMap<String, String>() {
        {
            put("key1", "value1");
            put("key2", "value2");
        }
    };

    private Child child;


    private List<String> list = new ArrayList<String>() {
        {
            add("value1");
            add("value2");
        }
    };

    @Getter
    @Setter
    public static class Child {

        private String name = "child";

        private int age = 1;
    }

    @Override
    public String fetchPropPrefix() {
        return NAME;
    }

    @Override
    public String fetchFileName() {
        return "application-test.yml";
    }

    @Override
    public IProperty fetchProp() {
        return this;
    }
}
