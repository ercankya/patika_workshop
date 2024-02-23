package model.locs.battleLocs;

import model.Player;
import model.obstacles.Bear;
import model.obstacles.Obstacle;

public class River extends BattleLocation {
    public River(Player player) {
        super(player, "Nehir", new Bear(), "Su",3);
    }
}
