package model.obstacles;

import java.util.Random;

public class Snake extends Obstacle {
    public Snake() {
        super(4, "Yılan", 7, 12, 0);
    }

    public Snake(int id, String name, int damage, int health, int award) {
        super(id, name, damage, health, award);
    }

    public int randomDamage() {
        Random r = new Random();
        return r.nextInt(6) + 3;
    }
}
