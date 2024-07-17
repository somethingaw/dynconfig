package com.github.somethingaw.dynconfigcore.parser;

import com.github.somethingaw.dynconfigcore.dto.ParserContext;
import com.github.somethingaw.dynconfigcore.enums.FileTypeEnum;
import com.github.somethingaw.dynconfigcore.enums.ObjTypeEnum;
import com.github.somethingaw.dynconfigcore.parser.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * ParserFactory
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/11 16:37
 **/
public class ParserFactory {

    private static Map<ObjTypeEnum, BaseParser> parserMap;

    private static ParserFactory instance;

    private ParserFactory() {
        parserMap = new HashMap<>();
        registerParser(ObjTypeEnum.SIMPLE, new SimpleParser());
        registerParser(ObjTypeEnum.MAP, new MapParser());
        registerParser(ObjTypeEnum.COLLECTION, new CollectionParser());
        registerParser(ObjTypeEnum.JAVA_BEAN, new JavaBeanParser());
    }

    public static ParserFactory getInstance() {
        if (instance == null) {
            synchronized (ParserFactory.class) {
                if (instance == null) {
                    instance = new ParserFactory();
                }
            }
        }
        return instance;
    }

    public static String parse(Object obj, String prefix, FileTypeEnum fileTypeEnum) {
        ParserContext context = new ParserContext(obj, prefix, fileTypeEnum, new StringBuffer());
        return parse(context);
    }

    public static String parse(ParserContext context) {
        ParserFactory parserFactory = getInstance();
        String result = parserFactory.getParserOrDefault(null).parse(context);
        return result;
    }

    public void registerParser(ObjTypeEnum objType, BaseParser parser) {
        parserMap.put(objType, parser);
    }

    public BaseParser getParser(ObjTypeEnum objType) {
        return parserMap.get(objType);
    }

    public BaseParser getParserOrDefault(ObjTypeEnum objType) {
        if (parserMap.containsKey(objType)) {
            return parserMap.get(objType);
        }
        return parserMap.get(ObjTypeEnum.SIMPLE);
    }
}
