package me.reyfol.ArtifexCurrencyPlugin.Commands;

import me.reyfol.ArtifexCurrencyPlugin.DB.ArtifexCurrencyModel;
import me.reyfol.ArtifexCurrencyPlugin.DB.ArtifexCurrencyDAO;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.SQLException;
import java.util.UUID;

public class ArtifexCurrencyBalanceCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String alias, String[] args) {
        System.out.println("BALANCE!");
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        UUID uuid = player.getUniqueId();
        ArtifexCurrencyDAO artifexCurrencyDAO = new ArtifexCurrencyDAO();
//        try {
//            ArtifexCurrencyModel artifexCurrency = artifexCurrencyDAO.get(uuid.toString());
//            System.out.println(artifexCurrency);
//        } catch (SQLException e) {
//            System.out.println(e);
//        }

        return true;
    }
}
