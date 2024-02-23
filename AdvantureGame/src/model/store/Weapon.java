package model.store;

import model.chars.Archer;
import model.chars.GameChar;

import java.util.ArrayList;
import java.util.List;

public class Weapon {
    private int id;
    private String name;
    private int damage;
    private int price;

    public Weapon(int id, String name, int damage, int price) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.price = price;
    }

    public static List<Weapon> weapons() {
        List<Weapon> weaponList = new ArrayList<>();
        weaponList.add(new Weapon(1, "Tabanca", 2, 5));
        weaponList.add(new Weapon(2, "Kılıç", 3, 35));
        weaponList.add(new Weapon(3, "Tüfek", 7, 45));
        weaponList.add(new Weapon(4, "Bazuka", 12, 75));

        return weaponList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
