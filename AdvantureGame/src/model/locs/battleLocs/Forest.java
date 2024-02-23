package model.locs.battleLocs;

import model.Player;
import model.obstacles.Obstacle;
import model.obstacles.Vampire;

public class Forest extends BattleLocation{
    public Forest(Player player) {
        super(player, "Orman", new Vampire(), "Odun",3);
    }
}
