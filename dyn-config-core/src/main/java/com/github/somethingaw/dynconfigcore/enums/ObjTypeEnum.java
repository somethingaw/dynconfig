package com.github.somethingaw.dynconfigcore.enums;

import java.util.Collection;
import java.util.Map;

/**
 * ObjTypeEnum
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/15 11:22
 **/
public enum ObjTypeEnum {

    SIMPLE,
    MAP,
    COLLECTION,
    JAVA_BEAN;

    public static ObjTypeEnum getObjType(Object obj) {
        return getObjType(obj.getClass());
    }

    public static ObjTypeEnum getObjType(Class<?> clazz) {
        if (Collection.class.isAssignableFrom(clazz)) {
            return ObjTypeEnum.COLLECTION;
        } else if (Map.class.isAssignableFrom(clazz)) {
            return ObjTypeEnum.MAP;
        } else if (isSimpleType(clazz)) {
            return ObjTypeEnum.SIMPLE;
        } else {
            return ObjTypeEnum.JAVA_BEAN;
        }
    }

    public static boolean isSimpleType(Class<?> clazz) {
        return clazz.isPrimitive() ||
                clazz.equals(String.class) ||
                Number.class.isAssignableFrom(clazz) ||
                clazz.equals(Boolean.class) ||
                clazz.equals(Character.class);
    }
}
