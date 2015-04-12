package com.yfann.web.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Simon on 2015/4/6.
 */
public class ReadProperties {
    public static String getValue(String key,String fileName) throws Exception{
        InputStream inputStream = ReadProperties.class.getResourceAsStream("/" + fileName + ".properties");
        Properties properties = new Properties();
        properties.load(inputStream);
        return properties.getProperty(key);
    }
}
