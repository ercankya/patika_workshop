package model.store;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private int id;
    private String name;
    private int health;
    private int block;
    private int money;

    public Item(int id, String name, int health, int block, int money) {
        this.id = id;
        this.name = name;
        this.health = health;
        this.block = block;
        this.money = money;
    }

    public static List<Item> items() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item(1, "Su", 10, 5, 0));
        itemList.add(new Item(2, "Odun", 15, 10, 0));
        itemList.add(new Item(3, "Yemek", 25, 10, 0));
        itemList.add(new Item(4, "Para", 0, 0, 50));

        return itemList;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
