package model.locs.normLocs;

import model.Player;
import model.locs.Location;

public class SafeHouse extends NormLocation {
    public SafeHouse(Player player) {
        super(player, "SafeHose");
    }

    @Override
    public boolean onLocation() {
        showSafeHouse();
        return true;
    }

    public boolean showSafeHouse() {
        System.out.println("+--------------------------------+");
        System.out.println("+ Güvenli Evdesiniz Hoşgeldiniz  +");
        System.out.println("+--------------------------------+");

        this.getPlayer().getGameChar().setHealth(this.getPlayer().getGameChar().getDefHealth());
        System.out.println("Canınız Fullendi..");
        System.out.println();
        return true;
    }

}
