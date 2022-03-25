package com.resume.resumemakerapi.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.core.io.ClassPathResource;

public class Template {

    static {
        try {
            HEAD = new String(Files.readAllBytes(java.nio.file.Paths.get(new ClassPathResource("static").getFile().getAbsolutePath()+File.separator+"head-data.html")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String TOP = "<!DOCTYPE html><html>";

    public static String HEAD;

    public static String BODY = "<body>";

    public static String FOOTER = "</body></html>";

}
