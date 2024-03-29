package model;

import model.chars.GameChar;
import model.locs.Location;
import model.store.Item;

import java.util.List;

public class Player {
    private GameChar gameChar;
    private Inventory inventory;
    private Location location;
    private String name;

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();
    }

    public int getTotalDamage() {
        return this.gameChar.getDamage() + this.getInventory().getWeapon().getDamage();
    }

    public void showPlayerInfo() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                this.getGameChar().getCharName() +
                        "\tSilah : " + this.getInventory().getWeapon().getName() +
                        "\t Hasar : " + this.getTotalDamage() +
                        "\t Zırh : " + this.getInventory().getArmour().getName() +
                        "\t Bloklama : " + this.getInventory().getArmour().getBlock() +

                        "\t Sağlık : " + this.getGameChar().getHealth() +
                        "\t Para : " + this.getGameChar().getMoney() +
                        "\t Envanter : " + listItems()
        );
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
    }

    public String listItems() {
        String str = "";
        List<Item> items = this.getInventory().getItems();
        for (Item item : items) {
            str += item.getName() + ", ";
        }
        return str;
    }

    public GameChar getGameChar() {
        return gameChar;
    }

    public void setGameChar(GameChar gameChar) {
        this.gameChar = gameChar;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
