package com.github.somethingaw.dynconfigspringbootstarter.controller;

import com.github.somethingaw.dynconfigspringbootstarter.property.IProperty;
import com.github.somethingaw.dynconfigspringbootstarter.service.IConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * PropController
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/8 15:12
 **/
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private IConfig iConfig;

    @GetMapping("/getAll")
    @ResponseBody
    public Map<String, IProperty> getAllProp() {
        return iConfig.getAllProp();
    }

    @GetMapping("/getOne")
    @ResponseBody
    public IProperty getProp(@RequestParam("propName") String propName) {
        return iConfig.getOneProp(propName);
    }

    @GetMapping("/persist")
    @ResponseBody
    public Boolean persist(@RequestParam("propName") String propName) {
        return iConfig.persist(propName);
    }

    @GetMapping("/update")
    @ResponseBody
    public Boolean update(@RequestParam("propName") String propName,
                          @RequestParam("key") String key,
                          @RequestParam("value") Object value) {
        return iConfig.updateProp(propName, key, value);
    }

}
