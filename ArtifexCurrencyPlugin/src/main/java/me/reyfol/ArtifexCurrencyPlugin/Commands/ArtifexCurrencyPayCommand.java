package me.reyfol.ArtifexCurrencyPlugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Method;


public class ArtifexCurrencyPayCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String alias, String[] args) {

        // Dependencies
        Plugin artifexCredentialPlugin = null;
        Method getUuidByUsername = null;
        try {
            artifexCredentialPlugin = Bukkit.getPluginManager().getPlugin("ArtifexCredentialPlugin");
            getUuidByUsername = artifexCredentialPlugin.getClass().getMethod("getUuidByUsername");
        }
        catch (Exception e){
            return false;
        }

        if (!(commandSender instanceof Player)){
            return false;
        }

        // get currency name
//        if ()

        // display command help
        if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
            showHelp((Player) commandSender);
            return false;
        }

        // if args.length >= 1
        String targetUuid = null;
        try{
            String uuid = (String) getUuidByUsername.invoke(artifexCredentialPlugin);
            if (uuid == null){
                return false;
            }
            targetUuid = uuid;
        }


        catch (Exception e){
            return false;
        }







        return true;
    }

    private void showHelp(Player player){
        player.sendMessage("HELP!");
    }
}
