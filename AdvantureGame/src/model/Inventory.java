package model;

import model.store.Armour;
import model.store.Weapon;

public class Inventory {
    Weapon weapon;
    Armour armour;

    public Inventory() {
        this.weapon = new Weapon(0, "Yumruk", 0, 0);
        this.armour = new Armour(0, "Miğfer", 0, 0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }
}
