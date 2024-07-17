package com.example.dynconfigcore;

import com.example.dynconfigcore.dto.User;
import com.github.somethingaw.dynconfigcore.enums.FileTypeEnum;
import com.github.somethingaw.dynconfigcore.parser.ParserFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * YamlTest
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/16 10:59
 **/
public class YamlTest {


    public static void main(String[] args) {
        User user = new User();
        user.setAge(10);
        user.setName("www");
        HashMap<String, String> map = new HashMap<>();
        map.put("key1", "val1");
        map.put("key2", "val2");
        user.setMap(map);
        User.Child child = new User.Child();
        child.setChildName("com");
        child.setChildAge(8);
        user.setChild(child);
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        user.setList(list);

        String yaml = ParserFactory.parse(user, "test", FileTypeEnum.YAML);
        System.out.println(yaml);
        String prop = ParserFactory.parse(user, "test", FileTypeEnum.PROP);
        System.out.println(prop);
    }

}
