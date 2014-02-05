package com.iKeirNez.Minecraftly;

import com.iKeirNez.Minecraftly.configuration.Setting;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by iKeirNez on 30/01/14.
 */
public class Minecraftly extends JavaPlugin {

    @Getter private static Minecraftly instance;

    @Getter private Language language;

    public void onEnable(){
        instance = this;

        if (!new File(getDataFolder(), "config.yml").exists()){
            saveDefaultConfig();
        }

        for (Setting setting : Setting.values()){
            setting.setValue(getConfig().get(setting.toConfigPath()));
        }

        language = new Language("en");
    }

    public void onDisable(){
        instance = null;
    }

}
