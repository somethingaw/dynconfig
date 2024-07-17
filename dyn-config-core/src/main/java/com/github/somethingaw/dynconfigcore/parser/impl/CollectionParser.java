package com.github.somethingaw.dynconfigcore.parser.impl;

import com.github.somethingaw.dynconfigcore.constant.SymbolConst;

import java.beans.PropertyDescriptor;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * CollectionParser
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/16 9:48
 **/
public class CollectionParser extends BaseParser {
    @Override
    public String parseYaml(PropertyDescriptor pd, Object obj, int level, StringBuffer buffer) {
        Object value = getVal(pd, obj);
        if (value != null) {
            buildSpace(level, buffer);
            Collection valueCollection = (Collection) value;
            buffer.append(pd.getName())
                    .append(SymbolConst.COLON)
                    .append(SymbolConst.SPACE)
                    .append(valueCollection.stream().collect(Collectors.joining(",")))
                    .append(SymbolConst.LF);
        }
        return buffer.toString();
    }

    @Override
    public String parseProp(PropertyDescriptor pd, Object obj, String prefix, StringBuffer buffer) {
        Object value = getVal(pd, obj);
        if (value != null) {
            Collection valueCollection = (Collection) value;
            buffer.append(prefix)
                    .append(SymbolConst.DOT)
                    .append(pd.getName())
                    .append(SymbolConst.EQUAL)
                    .append(valueCollection.stream().collect(Collectors.joining(",")))
                    .append(SymbolConst.LF);
        }
        return buffer.toString();
    }
}
