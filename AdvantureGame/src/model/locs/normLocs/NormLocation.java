package model.locs.normLocs;

import model.Player;
import model.locs.Location;

public abstract class NormLocation extends Location {

    public NormLocation(int id, Player player, String locName) {
        super(id, player, locName);
    }

    @Override
    public boolean onLocation() {
        return true;
    }
}
