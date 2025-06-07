package biscoito.smp.biscoitosmptips;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitTask;

import java.util.List;
import java.util.Random;

public class SendTips implements Listener {

    public boolean verifyState(Player player) {
        for (PlayerTipsState ps : ChatTips.getPts()) {
            if (ps.getPlayer().getName().equals(player.getName())) {
                return ps.getState();
            }
        }

        // Se não encontrou o jogador, adiciona ele com estado padrão true
        ChatTips.getPts().add(new PlayerTipsState(player, true));
        return true;
    }

    public static int TipTimer(Player player) {
        Random rdm = new Random();
        FileConfiguration config = ChatTips.getInstance().getConfig();
        List<String> messageList = (List<String>) config.getList("messages");

        BukkitTask tiptimer = Bukkit.getScheduler().runTaskTimer(
                ChatTips.getInstance(),
                () -> {
                    String msg = messageList.get(rdm.nextInt(messageList.size()));
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                },
                0L,
                20 * 60 * config.getLong("msgtimer")
        );
        return tiptimer.getTaskId();
    }

    private static int taskid;

    public static void setTipTaskId(int id) {
        taskid = id;
    }

    public static int getTipTaskId() {
        return taskid;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();

        boolean state = verifyState(player);

        if (state) {
            int id = TipTimer(player);
            setTipTaskId(id);
        }
    }
}
