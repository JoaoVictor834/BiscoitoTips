package biscoito.smp.biscoitosmptips;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class PlayerTipsState {
    private Player player;
    private Boolean state;


    public PlayerTipsState(Player player, Boolean state) {
        this.player = player;
        this.state = state;
    }


    public Player getPlayer() {
        return player;
    }

    public Boolean getState() {
        return state;
    }
}
