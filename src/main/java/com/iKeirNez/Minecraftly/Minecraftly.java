package com.iKeirNez.Minecraftly;

import com.iKeirNez.Minecraftly.config.Setting;
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
        mainConfig = configManager.getNewConfig("config.yml", Setting.HEADER);

        // Load config and copy any defaults that are not already included in the config
        for (Setting setting : Setting.values()){
            String configPath = setting.toConfigPath();

            if (mainConfig.contains(configPath)){
                setting.setValue(mainConfig.get(configPath));
            } else {
                if (setting.hasComment()){
                    mainConfig.set(configPath, setting.getDef(), setting.getComment());
                } else {
                    mainConfig.set(configPath, setting.getDef());
                }
            }
        }

        mainConfig.saveConfig();
        language = new Language("en");
    }

    public void onDisable(){
        for (Setting setting : Setting.values()){
            if (setting.hasComment()){
                mainConfig.set(setting.toConfigPath(), setting.getValue(), setting.getComment());
            } else {
                mainConfig.set(setting.toConfigPath(), setting.getValue());
            }
        }

        mainConfig.saveConfig();
        instance = null;
    }

}
