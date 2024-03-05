package model.locs.battleLocs;

import model.Player;
import model.obstacles.Bear;
import model.obstacles.Snake;

public class River extends BattleLocation {
    private static boolean isCompleted = false;


    public River(Player player) {
        super(3, player, "Nehir", new Bear(), "Yemek", 3);
    }

    @Override
    public boolean onLocation() {
        if (isCompleted) {
            System.out.println("Nehir artık tehlikesiz, başka bir yere gitmelisiniz.");
            System.out.println();
            return true;
        }
        return super.onLocation();
    }

    @Override
    public void winLocShow() {
        super.winLocShow(); // Override edilen metodu çağırarak önceki işlemlerin yapılmasını sağlıyoruz
        isCompleted = true; // Nehir temizlendiğinde değişkeni true yaparak işaretliyoruz
    }
}
