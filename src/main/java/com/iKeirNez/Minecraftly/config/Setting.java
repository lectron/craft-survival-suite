package com.iKeirNez.Minecraftly.config;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.WordUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by iKeirNez on 04/02/14.
 */
public enum Setting {

    DEBUG(false, "Debug mode. You only need to enable this if you experience any issues/bugs with this plugin");

    @Getter Object def;
    @Getter @Setter Object value;
    @Getter String comment = null;

    private Setting(Object def){
        this.def = def;
        this.value = def;
    }

    private Setting(Object def, String comment){
        this(def);
        this.comment = comment;
    }

    public int intValue(){
        return (int) value;
    }

    public long longValue(){
        return (long) value;
    }

    public boolean booleanValue(){
        return (boolean) value;
    }

    public String stringValue(){
        return (String) value;
    }

    public List<String> stringListValue(){
        return (List<String>) value;
    }

    public List listValue(){
        return (List) value;
    }

    public Map<String, Object> mapValue(){
        return (Map<String, Object>) value;
    }

    public boolean hasComment(){
        return comment != null;
    }

    public String toConfigPath(){
        return WordUtils.capitalize(name().toLowerCase().replaceAll("__", ".").replaceAll("_", " ")).replaceAll(" ", "");
    }

    public static String[] HEADER = { "This plugin is created and maintained by Minecraftly server and iKeirNez.", "Server Address - m.ly", "Official Website - http://m.ly", "URL Shorterner for the Minecraft Community - http://mc.ly" };

}
