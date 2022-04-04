package com.resume.resumemakerapi.helper;

import java.io.File;
import java.io.IOException;
// import java.io.InputStream;
import java.nio.file.Files;

// import com.resume.resumemakerapi.ResumeMakerApiApplication;

import org.springframework.core.io.ClassPathResource;

public class Template {

    static {
        try {
            // InputStream resourceAsStream = ResumeMakerApiApplication.class.getClassLoader().getResourceAsStream("static/head-data.html");
            // byte[] ba = new byte[resourceAsStream.available()];
            // resourceAsStream.read(ba);
            // HEAD = new String(ba);
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
