package model.locs.normLocs;

import model.Player;
import model.locs.Location;
import model.store.Armour;
import model.store.Weapon;

public class ToolStore extends NormLocation {

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        showToolStore();
        return true;
    }

    public boolean showToolStore() {
        while (true) {
            System.out.println("+----------------------------+");
            System.out.println("+ ToolStore Hoşgeldiniz      +");
            System.out.println("+----------------------------+");
            System.out.println("1- Silahlar \t +");
            System.out.println("2- Zırhlar  \t +");
            System.out.println("0- Çıkış    \t +");
            System.out.println();
            int selectCase = input.nextInt();
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println();
            while (selectCase < 0 || selectCase > 2) {
                System.out.print("Geçersiz değer girişi, Tekrar giriniz : ");
                selectCase = input.nextInt();
            }
            switch (selectCase) {
                case 1:
                    selectWeapon();
                    break;
                case 2:
                    selectArmor();
                    break;
                case 0:
                    System.out.println("ToolStore'dan çıktınız.");
                    return true;
            }
        }
    }

    public boolean selectWeapon() {
        while (true) {
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println("Silahlar                                                                                    ");
            System.out.println("--------------------------------------------------------------------------------------------");
            for (Weapon w : Weapon.weapons()) {
                System.out.println(w.getId() + ". " + w.getName() + "\t Güç : " + w.getDamage() + "\t Para : " + w.getPrice());
            }
            System.out.println("0-> Çıkış                                                                                  -");
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println();
            return buyWeapon();
        }
    }

    public boolean buyWeapon() {
        System.out.print("Bir Silah Seçin : ");
        int selectWeapon = input.nextInt();
        int indxWeapon = selectWeapon - 1;
        if (selectWeapon == 0) {
            return true;
        }
        while (indxWeapon < 0 || Weapon.weapons().size() < indxWeapon + 1) {
            System.out.print("Geçersiz değer girişi, Tekrar giriniz : ");
            selectWeapon = input.nextInt();
            indxWeapon = selectWeapon - 1;
            if (selectWeapon == 0) {
                return true;
            }
        }
        if (Weapon.weapons().get(indxWeapon).getPrice() > this.getPlayer().getGameChar().getMoney()) {
            System.out.println("Paranız yeterli değil.");
            return false;
        } else {
            if (this.getPlayer().getInventory().getWeapon().getId() == Weapon.weapons().get(indxWeapon).getId()) {
                System.out.println(Weapon.weapons().get(indxWeapon).getName() + " Bu Silahı zaten satın aldınız.");
                System.out.println("Kalan Para : " + this.getPlayer().getGameChar().getMoney());
                return false;
            }
            System.out.println(Weapon.weapons().get(indxWeapon).getName() + " Silahını satın aldınız.");
            this.getPlayer().getGameChar().setMoney(this.getPlayer().getGameChar().getMoney() - Weapon.weapons().get(indxWeapon).getPrice());
            System.out.println("Kalan Para : " + this.getPlayer().getGameChar().getMoney());
            this.getPlayer().getInventory().setWeapon(Weapon.weapons().get(indxWeapon));
            System.out.println();
        }
        return false;
    }

    public boolean selectArmor() {
        while (true) {
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println("Zırhlar                                                                                     ");
            System.out.println("--------------------------------------------------------------------------------------------");
            for (Armour w : Armour.armours()) {
                System.out.println(w.getId() + ". " + w.getName() + "\t Zırh : " + w.getBlock() + "\t Para : " + w.getPrice());
            }
            System.out.println("0-> Çıkış                                                                                  -");
            System.out.println("--------------------------------------------------------------------------------------------");
            System.out.println();
            return buyArmour();
        }
    }

    public boolean buyArmour() {
        System.out.print("Bir Zırh Seçin : ");
        int selectArmour = input.nextInt();
        int indxArmour = selectArmour - 1;
        if (selectArmour == 0) {
            return true;
        }
        while (indxArmour < 0 || indxArmour + 1 > Armour.armours().size()) {
            System.out.print("Geçersiz değer girişi, Tekrar giriniz : ");
            selectArmour = input.nextInt();
            indxArmour = selectArmour - 1;
            if (selectArmour == 0) {
                return true;
            }
        }
        if (Armour.armours().get(indxArmour).getPrice() > this.getPlayer().getGameChar().getMoney()) {
            System.out.println("Paranız yeterli değil.");
            return false;
        } else {
            if (this.getPlayer().getInventory().getArmour() == Armour.armours().get(indxArmour)) {
                System.out.println(Armour.armours().get(indxArmour).getName() + " Bu Zırhı zaten satın aldınız.");
                System.out.println("Kalan Para : " + this.getPlayer().getGameChar().getMoney());
                
                return false;
            }
            System.out.println(Armour.armours().get(indxArmour).getName() + " Zırhı satın aldınız.");
            this.getPlayer().getGameChar().setMoney(this.getPlayer().getGameChar().getMoney() - Armour.armours().get(indxArmour).getPrice());
            System.out.println("Kalan Para : " + this.getPlayer().getGameChar().getMoney());
            this.getPlayer().getInventory().setArmour(Armour.armours().get(indxArmour));
            System.out.println();
        }
        return false;
    }
}
