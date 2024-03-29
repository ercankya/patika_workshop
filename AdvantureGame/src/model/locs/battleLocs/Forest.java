package model.locs.battleLocs;

import model.Player;
import model.obstacles.Obstacle;
import model.obstacles.Vampire;
import model.obstacles.Zombie;

public class Forest extends BattleLocation {
    private static boolean isCompleted = false;


    public Forest(Player player) {
        super(2, player, "Orman", new Vampire(), "Odun", 3);
    }

    @Override
    public boolean onLocation() {
        if (isCompleted) {
            System.out.println("Orman artık tehlikesiz, başka bir yere gitmelisiniz.");
            System.out.println();
            return true;
        }
        return super.onLocation();
    }

    @Override
    public void winLocShow() {
        super.winLocShow(); // Override edilen metodu çağırarak önceki işlemlerin yapılmasını sağlıyoruz
        isCompleted = true; // Orman temizlendiğinde değişkeni true yaparak işaretliyoruz
    }
}
