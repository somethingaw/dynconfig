package com.github.somethingaw.dynconfigcore.dto;


import com.github.somethingaw.dynconfigcore.enums.FileTypeEnum;
import lombok.Getter;
import lombok.Setter;


/**
 * ParserContext
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/15 10:18
 **/
@Getter
@Setter
public class ParserContext {
    public ParserContext() {

    }

    public ParserContext(Object obj, String prefix, FileTypeEnum fileType, StringBuffer buffer) {
        this.obj = obj;
        this.prefix = prefix;
        this.fileType = fileType;
        this.level = 0;
        this.buffer = buffer;
    }

    public ParserContext(Object obj, String prefix, FileTypeEnum fileType, Integer level, StringBuffer buffer) {
        this.obj = obj;
        this.prefix = prefix;
        this.fileType = fileType;
        this.level = level;
        this.buffer = buffer;
    }

    private Object obj;

    private FileTypeEnum fileType;

    private String prefix;

    private Integer level;

    private volatile StringBuffer buffer;
}
