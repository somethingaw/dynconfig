package com.example.dynconfigcore.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * User
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/16 11:02
 **/
@Getter
@Setter
public class User {

    private String name;

    private Integer age;

    private List<String> list;

    private Map<String, String> map;

    private Child child;


    @Getter
    @Setter
    public static class Child {

        private String childName;

        private int childAge = 1;
    }
}
