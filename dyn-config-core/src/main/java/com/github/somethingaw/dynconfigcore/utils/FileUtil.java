package com.github.somethingaw.dynconfigcore.utils;


import com.github.somethingaw.dynconfigcore.constant.SymbolConst;
import com.github.somethingaw.dynconfigcore.enums.FileTypeEnum;
import com.github.somethingaw.dynconfigcore.parser.ParserFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * FileUtil
 *
 * @author ArthurWang
 * @version 1.0
 * @date 2024/7/8 16:44
 **/
public class FileUtil {

    public static boolean writeYmlFile(Object obj, String prefix, String filePath) {
        String yaml = ParserFactory.parse(obj, prefix, FileTypeEnum.YAML);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(SymbolConst.HASH + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            bw.newLine();
            bw.write(yaml);
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                }
            }
        }
        return true;
    }

    public static boolean writePropFile(Object obj, String prefix, String filePath) {
        String prop = ParserFactory.parse(obj, prefix, FileTypeEnum.PROP);
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            bw.write(SymbolConst.HASH + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            bw.newLine();
            bw.write(prop);
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                }
            }
        }
        return true;
    }


}
