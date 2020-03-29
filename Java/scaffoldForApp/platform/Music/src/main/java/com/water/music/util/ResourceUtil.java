package com.water.music.util;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.ServiceLoader;

public class ResourceUtil {

    public static InputStream getClasspathFile(String fileName){
        try {
            return (new ClassPathResource(fileName)).getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static InputStream getFile(String fileName){
        return ResourceUtil.class.getClassLoader().getResourceAsStream(fileName);
    }

    public static void loadService(Class<?> clazz){
        ServiceLoader<?> loadedDrivers = ServiceLoader.load(clazz);

    }
}
