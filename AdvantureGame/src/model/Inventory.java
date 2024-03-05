package model;

import model.store.Armour;
import model.store.Item;
import model.store.Weapon;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    Weapon weapon;
    Armour armour;
    List<Item> items;

    public Inventory() {
        this.weapon = new Weapon(0, "Yumruk", 0, 0);
        this.armour = new Armour(0, "Miğfer", 0, 0);
        this.items = new ArrayList<>();
        this.items.add(new Item(0, "Şans Yüzüğü", 0, 0, 0));
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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
