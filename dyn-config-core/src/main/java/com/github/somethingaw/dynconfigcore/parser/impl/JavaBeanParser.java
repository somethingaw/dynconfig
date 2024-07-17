package com.github.somethingaw.dynconfigcore.parser.impl;

import com.github.somethingaw.dynconfigcore.constant.SymbolConst;
import com.github.somethingaw.dynconfigcore.dto.ParserContext;
import com.github.somethingaw.dynconfigcore.enums.FileTypeEnum;

import java.beans.PropertyDescriptor;

/**
 * JavaBeanParser
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/11 18:26
 **/
public class JavaBeanParser extends BaseParser {
    @Override
    public String parseYaml(PropertyDescriptor pd, Object obj, int level, StringBuffer buffer) {
        Object value = getVal(pd, obj);
        if (value != null) {
            ParserContext context = new ParserContext(value, pd.getName(), FileTypeEnum.YAML, level, buffer);
            return parse(context);
        }
        return buffer.toString();
    }

    @Override
    public String parseProp(PropertyDescriptor pd, Object obj, String prefix, StringBuffer buffer) {
        Object value = getVal(pd, obj);
        if (value != null) {
            ParserContext context = new ParserContext(value, prefix + SymbolConst.DOT + pd.getName(), FileTypeEnum.PROP, 0, buffer);
            return parse(context);
        }
        return buffer.toString();
    }

}
