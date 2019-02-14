package me.baoning.tourist.utils;

import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

/**
 * @author: zhangbaoning
 * @date: 2019/2/14
 * @since: JDK 1.8
 * @description: 文件工具类
 */
public class MyFileUtils {
    public static String getClassPath() {
        String classPath = null;
        try {
            classPath = ResourceUtils.getURL("classpath:").getPath();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return classPath;
    }
}
