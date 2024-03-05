package model.locs.normLocs;

import model.Player;
import model.chars.GameChar;
import model.locs.Location;
import model.locs.battleLocs.Cave;
import model.locs.battleLocs.Forest;
import model.locs.battleLocs.Mine;
import model.locs.battleLocs.River;
import model.store.Item;

import java.util.List;

public class SafeHouse extends NormLocation {
    public SafeHouse(Player player) {
        super(5, player, "SafeHose");
    }

    @Override
    public boolean onLocation() {
        showSafeHouse();
        return true;
    }

    public boolean showSafeHouse() {
        while (true) {
            System.out.println("+-----\t         \t        \t-----+");
            System.out.println("+# Güvenli Evdesiniz Hoşgeldiniz #+");
            System.out.println("+-----\t         \t        \t-----+");
            this.getPlayer().getGameChar().setHealth(this.getPlayer().getGameChar().getDefHealth());
            System.out.println("Canınız Fullendi.");
            System.out.println();

            System.out.println("1- Envanterini kullan.");
            System.out.println("0- Çıkış Yap--> ");
            System.out.println();

            System.out.print("Şimdi bir seçim yap : ");
            int selectLoc = input.nextInt();
            System.out.println("--------------------------------------------------------------------------------------------");

            switch (selectLoc) {
                case 0:
                    System.out.println("Güvenli Bölgeden Çıktınız.");
                    System.out.println();
                    return true;
                case 1:
                    listItems();
                    break;
                default:
                    System.out.println("Geçerli bir değer seçin");
            }
        }
    }

    public void listItems() {

        System.out.println("--------------------------------------------------------------------------------------------");
        List<Item> items = this.getPlayer().getInventory().getItems();
        for (Item item : items) {
            System.out.println("id : " + (item.getId() + 1) + ". " + item.getName());
            System.out.println("Sağlık :" + item.getHealth() + "\t" + "Zırh :" + item.getBlock() + "\t" + "Para :" + item.getMoney());
        }

        int ch = input.nextInt();
        while (ch > items.size() || ch < 0) {
            System.out.println("Geçersiz değer girişi, Tekrar giriniz : ");
            ch = input.nextInt();
        }
        this.getPlayer().getGameChar().setHealth(this.getPlayer().getGameChar().getHealth() + items.get(ch - 1).getHealth());
        this.getPlayer().getGameChar().setMoney(this.getPlayer().getGameChar().getMoney() + items.get(ch - 1).getMoney());
        this.getPlayer().getInventory().getArmour().setBlock(this.getPlayer().getInventory().getArmour().getBlock() + items.get(ch - 1).getBlock());
        this.getPlayer().getInventory().getItems().remove(ch - 1);

        System.out.println("--------------------------------------------------------------------------------------------");
    }
}
