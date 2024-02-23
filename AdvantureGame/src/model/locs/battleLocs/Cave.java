package model.locs.battleLocs;

import model.Player;
import model.obstacles.Obstacle;
import model.obstacles.Zombie;

public class Cave extends BattleLocation {

    public Cave(Player player) {
        super(player, "Mağara", new Zombie(), "Yemek",3);
    }
}
