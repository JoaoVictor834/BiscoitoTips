package biscoito.smp.biscoitosmptips;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.function.Supplier;

public class ToggleTips implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cSomente players podem utilizar este comando!"));
            return true;
        };
        Player player = (Player) sender;
        int i = 0;

        for (PlayerTipsState ps : ChatTips.getPts()) {
            i++;
            if (ps.getPlayer().getName().equals(player.getName())) {
                PlayerTipsState defaultPlayerState;
                if (!ps.getState()) {
                     defaultPlayerState = new PlayerTipsState(player, true);
                     int id = SendTips.TipTimer(player);
                     SendTips.setTipTaskId(id);
                     player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&cBiscoitoSMP&7] &bDicas ativadas"));
                } else {
                     defaultPlayerState = new PlayerTipsState(player, false);
                     Bukkit.getScheduler().cancelTask(SendTips.getTipTaskId());
                     player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7[&cBiscoitoSMP&7] &bDicas desativadas"));
                }
                ChatTips.getPts().remove(i -1);
                ChatTips.getPts().add(defaultPlayerState);
            }
        }


        return true;
    }


}
