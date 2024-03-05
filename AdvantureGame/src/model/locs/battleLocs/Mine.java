package model.locs.battleLocs;

import model.Player;
import model.obstacles.Bear;
import model.obstacles.Obstacle;
import model.obstacles.Snake;
import model.obstacles.Vampire;

public class Mine extends BattleLocation {
    private static boolean isCompleted = false;

    public Mine(Player player) {
        super(4, player, "Maden", new Snake(), "Eşya", 5);
    }

    @Override
    public boolean onLocation() {
        if (isCompleted) {
            System.out.println("Maden artık tehlikesiz, başka bir yere gitmelisiniz.");
            System.out.println();
            return true;
        }
        return super.onLocation();
    }

    @Override
    public void winLocShow() {
        super.winLocShow(); // Override edilen metodu çağırarak önceki işlemlerin yapılmasını sağlıyoruz
        isCompleted = true; // Maden temizlendiğinde değişkeni true yaparak işaretliyoruz
    }
}
