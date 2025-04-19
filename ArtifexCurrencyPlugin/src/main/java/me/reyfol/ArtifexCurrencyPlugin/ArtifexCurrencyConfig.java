package me.reyfol.ArtifexCurrencyPlugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

public class ArtifexCurrencyConfig {

    private static FileConfiguration configFile = null;

    public static void setup(Plugin plugin){
        plugin.saveConfig(); // Copies default values (does not overwrite)
        configFile = plugin.getConfig();
    }

    public static String getDefaultCurrency(){
        return configFile.getString("currencies.default.name");
    }

//    public static FileConfiguration get(){
//        return customFile;
//    }
//
//    public static void save(){
//        try{
//            customFile.save(file);
//        }catch (IOException e){
//            System.out.println("Saving file failed.");
//        }
//    }
//
//    public static void reload(){
//        customFile = YamlConfiguration.loadConfiguration(file);
//    }
}
