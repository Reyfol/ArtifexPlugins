package me.reyfol.ArtifexCurrencyPlugin;

import me.reyfol.ArtifexCredentialIMPL.API.ArtifexCredentialIMPL;
import me.reyfol.ArtifexCurrencyPlugin.Commands.ArtifexCurrencyBalanceCommand;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class ArtifexCurrencyPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("onEnable is called!");

        ArtifexCurrencyConfig.setup(this);


        ArtifexCredentialIMPL artifexCredentialIMPL = new ArtifexCredentialIMPL();
        getLogger().info(artifexCredentialIMPL.toString());

        getCommand("balance").setExecutor(new ArtifexCurrencyBalanceCommand());
    }
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }
}
