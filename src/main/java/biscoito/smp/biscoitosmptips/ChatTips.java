package biscoito.smp.biscoitosmptips;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;


public final class ChatTips extends JavaPlugin {

    private static ChatTips instance;

    public static ChatTips getInstance() {
        return instance;
    }

    private static List<PlayerTipsState> pts = new ArrayList<>();

    public static List<PlayerTipsState> getPts() {
        return pts;
    }



    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getLogger().info("BiscoitoSmp Tips Enabled");
        getServer().getPluginManager().registerEvents(new SendTips(),this);
        this.getCommand("dicas").setExecutor(new ToggleTips());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("'BiscoitoSmp Tips Disabled");
    }
}
