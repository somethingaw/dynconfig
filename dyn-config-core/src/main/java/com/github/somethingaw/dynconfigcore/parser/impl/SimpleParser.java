package com.github.somethingaw.dynconfigcore.parser.impl;

import com.github.somethingaw.dynconfigcore.constant.SymbolConst;

import java.beans.PropertyDescriptor;

/**
 * DefParser
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/15 11:14
 **/
public class SimpleParser extends BaseParser {
    @Override
    public String parseYaml(PropertyDescriptor pd, Object obj, int level, StringBuffer buffer) {
        Object value = getVal(pd, obj);
        if (value != null) {
            buildSpace(level, buffer);
            buffer.append(pd.getName())
                    .append(SymbolConst.COLON)
                    .append(SymbolConst.SPACE)
                    .append(value)
                    .append(SymbolConst.LF);
        }
        return buffer.toString();
    }

    @Override
    public String parseProp(PropertyDescriptor pd, Object obj, String prefix, StringBuffer buffer) {
        Object value = getVal(pd, obj);
        if (value != null) {
            buffer.append(prefix)
                    .append(SymbolConst.DOT)
                    .append(pd.getName())
                    .append(SymbolConst.EQUAL)
                    .append(value)
                    .append(SymbolConst.LF);
        }
        return buffer.toString();
    }
}
