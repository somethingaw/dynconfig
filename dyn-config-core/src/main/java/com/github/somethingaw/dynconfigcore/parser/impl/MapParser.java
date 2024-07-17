package com.github.somethingaw.dynconfigcore.parser.impl;

import com.github.somethingaw.dynconfigcore.constant.SymbolConst;

import java.beans.PropertyDescriptor;
import java.util.Map;

/**
 * MapParser
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/11 15:49
 **/
public class MapParser extends BaseParser {

    @Override
    public String parseYaml(PropertyDescriptor pd, Object obj, int level, StringBuffer buffer) {
        Object value = getVal(pd, obj);
        if (value != null) {
            Map valueMap = (Map) value;
            valueMap.forEach((k, v) -> {
                buildSpace(level, buffer);
                buffer.append(k)
                        .append(SymbolConst.COLON)
                        .append(SymbolConst.SPACE)
                        .append(v)
                        .append(SymbolConst.LF);
            });
        }
        return buffer.toString();
    }

    @Override
    public String parseProp(PropertyDescriptor pd, Object obj, String prefix, StringBuffer buffer) {
        Object value = getVal(pd, obj);
        if (value != null) {
            Map valueMap = (Map) value;
            valueMap.forEach((k, v) -> {
                buffer.append(prefix)
                        .append(SymbolConst.DOT)
                        .append(k)
                        .append(SymbolConst.EQUAL)
                        .append(v)
                        .append(SymbolConst.LF);
            });
        }
        return buffer.toString();
    }
}
