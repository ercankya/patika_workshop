package model.obstacles;

public abstract class Obstacle {
    private int id;
    private String name;
    private int damage;
    private int health;
    private int defHealth;
    private int award;

    public Obstacle(int id, String name, int damage, int health, int award) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.defHealth = health;
        this.award = award;

    }

    public void showObstacleInfo() {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println(
                this.getName() +
                        "\t Hasar : " + this.getDamage() +
                        "\t Sağlık : " + this.getHealth() +
                        "\t Ödül : " + this.getAward()
        );
        System.out.println("--------------------------------------------------------------------------------------------");
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health < 0 ? 0 : health;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }
}
