package com.iKeirNez.Minecraftly;

import com.iKeirNez.Minecraftly.config.SimpleConfig;
import com.iKeirNez.Minecraftly.config.SimpleConfigManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by iKeirNez on 30/01/14.
 */
public class Minecraftly extends JavaPlugin {

    @Getter private static Minecraftly instance;

    @Getter SimpleConfigManager configManager;
    @Getter SimpleConfig mainConfig;
    @Getter private Language language;

    public void onEnable(){
        instance = this;
        configManager = new SimpleConfigManager(this);
        mainConfig = configManager.getNewConfig("config.yml");
        mainConfig.saveConfig();
        language = new Language("en");
    }

    public void onDisable(){
        instance = null;
    }

}
