package model.locs.battleLocs;

import model.Player;
import model.obstacles.Obstacle;
import model.obstacles.Zombie;

public class Cave extends BattleLocation {
    private static boolean isCompleted = false;

    public Cave(Player player) {
        super(1, player, "Mağara", new Zombie(), "Su", 3);
    }

    @Override
    public boolean onLocation() {
        if (isCompleted) {
            System.out.println("Mağara artık tehlikesiz, başka bir yere gitmelisiniz.");
            System.out.println();
            return true;
        }
        return super.onLocation();
    }

    @Override
    public void winLocShow() {
        super.winLocShow(); // Override edilen metodu çağırarak önceki işlemlerin yapılmasını sağlıyoruz
        isCompleted = true; // Mağara temizlendiğinde değişkeni true yaparak işaretliyoruz
    }

}
