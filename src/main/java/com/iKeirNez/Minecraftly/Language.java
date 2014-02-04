package com.iKeirNez.Minecraftly;

import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by iKeirNez on 30/01/14.
 */
public class Language {

    private static Map<String, Language> languages = new HashMap<>();

    public Language getLanguage(String language){
        return languages.get(language);
    }

    @Getter private String language;
    @Getter private String languageFileName;
    @Getter private Properties properties;

    public Language(String language){
        this.language = language;
        this.languageFileName = "language_" + language + ".properties";

        this.properties = new Properties();

        try {
            try (InputStream inputStream = getClass().getResourceAsStream("/" + languageFileName)){
                properties.load(inputStream);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        languages.put(language, this);
    }

    public String get(String key, Object... args){
        return String.format(getProperties().getProperty(key), args);
    }

}
