package com.github.somethingaw.dynconfigspringbootstarter.service.impl;

import com.github.somethingaw.dynconfigspringbootstarter.property.IProperty;
import com.github.somethingaw.dynconfigspringbootstarter.service.IConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * PropertiesService
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/8 15:02
 **/
@Service
public class ConfigService implements IConfig {

    @Autowired
    private Map<String, IProperty> propertiesMap;

    @Value("${config.file.path:}")
    private String propFilePath;

    public static String CONFIG_FILE_PATH = null;

    @PostConstruct
    public void init() {
        if (propFilePath != null && propFilePath.length() != 0) {
            CONFIG_FILE_PATH = propFilePath;
        }

    }

    @Override
    public Map<String, IProperty> getAllProp() {
        if (CollectionUtils.isEmpty(propertiesMap)) {
            return null;
        }
        return propertiesMap;
    }

    @Override
    public IProperty getOneProp(String propName) {
        if (CollectionUtils.isEmpty(propertiesMap) || !propertiesMap.containsKey(propName)) {
            return null;
        }
        return propertiesMap.get(propName);
    }

    @Override
    public boolean updateProp(String propName, String key, Object value) {
        if (CollectionUtils.isEmpty(propertiesMap) || !propertiesMap.containsKey(propName)) {
            return false;
        }
        IProperty properties = propertiesMap.get(propName);
        if (properties == null) {
            return false;
        }
        // 反射进行 属性更新
        properties.update(key, value);
        return true;
    }

    @Override
    public boolean persist(String propName) {
        if (CollectionUtils.isEmpty(propertiesMap) || !propertiesMap.containsKey(propName)) {
            return false;
        }
        IProperty properties = propertiesMap.get(propName);
        if (properties == null) {
            return false;
        }
        properties.preDestroy();
        return true;
    }

}
