package com.github.somethingaw.dynconfigcore.parser;

import com.github.somethingaw.dynconfigcore.dto.ParserContext;

/**
 * IParser
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/11 15:36
 **/
public interface IParser {
    String parse(ParserContext context);
}
