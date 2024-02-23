package model.store;

import java.util.ArrayList;
import java.util.List;

public class Armour {
    private int id;
    private String name;
    private int block;
    private int price;

    public Armour(int id, String name, int block, int price) {
        this.id = id;
        this.name = name;
        this.block = block;
        this.price = price;
    }

    public static List<Armour> armours() {
        List<Armour> armourList = new ArrayList<>();
        armourList.add(new Armour(1, "Meşe Kalkan", 2, 10));
        armourList.add(new Armour(2, "Demir Zırh", 5, 15));
        armourList.add(new Armour(3, "Deri Zırh", 20, 45));
        armourList.add(new Armour(4, "Titanium Zırh", 30, 60));

        return armourList;
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

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
