package com.github.somethingaw.dynconfigcore.parser.impl;


import com.github.somethingaw.dynconfigcore.constant.SymbolConst;
import com.github.somethingaw.dynconfigcore.dto.ParserContext;
import com.github.somethingaw.dynconfigcore.enums.FileTypeEnum;
import com.github.somethingaw.dynconfigcore.enums.ObjTypeEnum;
import com.github.somethingaw.dynconfigcore.parser.IParser;
import com.github.somethingaw.dynconfigcore.parser.ParserFactory;
import org.apache.commons.beanutils.PropertyUtils;

import java.beans.PropertyDescriptor;

/**
 * BeseParser
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/11 16:25
 **/
public abstract class BaseParser implements IParser {

    @Override
    public final String parse(ParserContext context) {
        Object obj = context.getObj();
        if (obj == null) {
            return null;
        }
        FileTypeEnum fileType = context.getFileType();
        if (fileType == null) {
            return null;
        }
        String prefix = context.getPrefix();
        if (fileType == FileTypeEnum.YAML) {
            return doParseYaml(obj, prefix, context.getLevel(), context.getBuffer());
        } else {
            return doParseProp(obj, prefix, context.getBuffer());

        }
    }

    protected Object getVal(PropertyDescriptor pd, Object obj) {
        Object value = null;
        try {
            value = pd.getReadMethod().invoke(obj);
        } catch (Exception e) {

        }
        return value;
    }

    protected void buildSpace(int level, StringBuffer buffer) {
        for (int i = 0; i < level; i++) {
            buffer.append(SymbolConst.SPACE);
        }
    }

    private String doParseProp(Object obj, String prefix, StringBuffer buffer) {
        PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(obj);
        if (pds == null || pds.length == 0) {
            return "";
        }

        for (PropertyDescriptor pd : pds) {
            BaseParser parser = getByPd(pd);
            parser.parseProp(pd, obj, prefix, buffer);
        }
        return buffer.toString();
    }


    private String doParseYaml(Object obj, String prefix, int level, StringBuffer buffer) {
        PropertyDescriptor[] pds = PropertyUtils.getPropertyDescriptors(obj);
        if (pds == null || pds.length == 0) {
            return "";
        }
        if (prefix != null && prefix.length() != 0) {
            buildSpace(level, buffer);
            buffer.append(prefix).append(SymbolConst.COLON).append(SymbolConst.LF);
            level++;
        }
        for (PropertyDescriptor pd : pds) {
            BaseParser parser = getByPd(pd);
            parser.parseYaml(pd, obj, level, buffer);
        }
        return buffer.toString();
    }

    private BaseParser getByPd(PropertyDescriptor pd) {
        ObjTypeEnum objType = ObjTypeEnum.getObjType(pd.getPropertyType());
        ParserFactory parserFactory = ParserFactory.getInstance();
        return parserFactory.getParserOrDefault(objType);
    }


    public abstract String parseYaml(PropertyDescriptor pd, Object obj, int level, StringBuffer buffer);

    public abstract String parseProp(PropertyDescriptor pd, Object obj, String prefix, StringBuffer buffer);

}
