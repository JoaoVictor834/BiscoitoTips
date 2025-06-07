package biscoito.smp.biscoitosmptips;

import org.bukkit.entity.Player;

public class PlayerTipsState {
    private final Player player;
    private boolean state;

    public PlayerTipsState(Player player, boolean state) {
        this.player = player;
        this.state = state;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
