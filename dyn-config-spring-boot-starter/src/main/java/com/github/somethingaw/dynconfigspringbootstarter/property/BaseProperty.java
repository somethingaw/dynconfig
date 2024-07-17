package com.github.somethingaw.dynconfigspringbootstarter.property;

import com.github.somethingaw.dynconfigcore.constant.SymbolConst;
import com.github.somethingaw.dynconfigcore.utils.FileUtil;
import com.github.somethingaw.dynconfigspringbootstarter.service.impl.ConfigService;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;


/**
 * BaseProperties
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/8 9:14
 **/
public abstract class BaseProperty implements IProperty, Serializable {

    public static final String USER_DIR = System.getProperty("user.dir") + SymbolConst.SLASH + "conf" + SymbolConst.SLASH;

    @Override
    public void update(String key, Object value) {
        try {
            // map ： key=map.key1&value=val1
            // list ： key=list%5B0%5D&value=val1
            BeanUtils.setProperty(fetchProp(), key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void preDestroy() {
        persist(ConfigService.CONFIG_FILE_PATH);
    }

    public boolean persist(String propFilePath) {
        String fileName = fetchFileName();
        if (propFilePath == null || propFilePath.length() == 0) {
            propFilePath = USER_DIR;
        }
        String filePath = propFilePath + fileName;
        IProperty properties = fetchProp();
        // 写文件 两种格式
        if (fileName.endsWith("yml")) {
            FileUtil.writeYmlFile(properties, fetchPropPrefix(), filePath);
        } else {
            FileUtil.writePropFile(properties, fetchPropPrefix(), filePath);
        }
        return true;
    }

    public abstract String fetchPropPrefix();

    public abstract String fetchFileName();

    public abstract IProperty fetchProp();
}
