package model.locs.normLocs;

import model.Player;
import model.locs.Location;

public abstract class NormLocation extends Location {

    public NormLocation(Player player, String locName) {
        super(player, locName);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
