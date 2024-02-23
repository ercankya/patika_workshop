package model.chars;

public abstract class GameChar {
    private int id;
    private int damage;
    private int health;

    private int defHealth;
    private int money;

    private String charName;

    public GameChar(int id, int damage, int health, int money, String charName) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.charName = charName;
        this.defHealth = health;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }
}
