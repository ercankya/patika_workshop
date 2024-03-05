package model.locs.battleLocs;

import model.Player;
import model.locs.Location;
import model.obstacles.Obstacle;
import model.store.Armour;
import model.store.Item;
import model.store.Weapon;

import java.util.Random;

public abstract class BattleLocation extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    Random r = new Random();

    public BattleLocation(int id, Player player, String locName, Obstacle obstacle, String award, int maxObstacle) {
        super(id, player, locName);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int numObs = randomObstacle();

        System.out.println("Savaş alanındasınız");
        System.out.println("Dikkatli olun!!! " + this.getLocName() + " bölgesindesiniz.  " + numObs + " tane " + this.getObstacle().getName() + " var!");

        System.out.println("<S>AVAŞ VEYA <K>AÇ");
        String selectCase = input.nextLine().toUpperCase();
        System.out.println("--------------------------------------------------------------------------------------------");

        if (selectCase.equals("S") && combat(numObs)) {
            winLocShow();

        } else if (selectCase.equals("K")) {
            return false;
        } else {
            System.out.println("Yanlış Kullanım");
        }

        if (this.getPlayer().getGameChar().getHealth() <= 0) {
            System.out.println("Öldünüz");
            System.out.println("---------------------------------GAME OVER--------------------------------------------------");
            return false;
        }
        return true;
    }

    public boolean combat(int numObstacle) {

        for (int i = 0; i < numObstacle; i++) {
            this.getObstacle().setHealth(this.getObstacle().getDefHealth());
            this.getPlayer().showPlayerInfo();
            this.getObstacle().showObstacleInfo();

            boolean playerFirst = Math.random() > 0.5;
            while (this.getPlayer().getGameChar().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("<V>VUR VEYA <K>KAÇ");
                String selectCase = input.nextLine().toUpperCase();
                if (selectCase.equals("V")) {
                    if (playerFirst) {
                        charHit();
                        obstacleHit();
                    } else {
                        obstacleHit();
                        charHit();
                    }
                } else if (selectCase.equals("K")) {
                    return false;
                } else {
                    System.out.println("Yanlış Kullanım");
                }
            }
            if (this.getObstacle().getHealth() <= 0) {
                System.out.println((i + 1) + ". " + this.getObstacle().getName() + "  Öldü.");
                this.getPlayer().getGameChar().setMoney(this.getPlayer().getGameChar().getMoney() + this.getObstacle().getAward());
            }
            if (this.getPlayer().getGameChar().getHealth() <= 0) {
                System.out.println((i + 1) + ". " + this.getObstacle().getName() + " Sizi Öldürdü.");
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Canınız : " + this.getPlayer().getGameChar().getHealth());
        System.out.println(this.getObstacle().getName() + " Canı : " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void obstacleHit() {
        if (this.getObstacle().getHealth() > 0) {
            System.out.println(this.getObstacle().getName() + "  Vurdu");
            if (this.getPlayer().getInventory().getArmour().getBlock() > this.getObstacle().getDamage()) {
                this.getPlayer().getInventory().getArmour().setBlock(this.getPlayer().getInventory().getArmour().getBlock() - this.getObstacle().getDamage());
                afterHit();
            } else {
                this.getPlayer().getGameChar().setHealth(this.getPlayer().getGameChar().getHealth() + this.getPlayer().getInventory().getArmour().getBlock() - this.getObstacle().getDamage());
                this.getPlayer().getInventory().getArmour().setBlock(0);
                afterHit();
            }
        }
    }

    public void charHit() {
        System.out.println("Vurdunuz");
        this.getObstacle().setHealth(getObstacle().getHealth() - this.getPlayer().getTotalDamage());
        afterHit();
    }

    public int randomObstacle() {
        return r.nextInt(this.maxObstacle) + 1;
    }

    public void winLocShow() {
        System.out.println(this.getLocName() + " daki tüm düşmanları yendiniz.");
        System.out.println(this.getLocName() + " bölgesinde  " + this.getAward() + " Kazandınız.");
        this.getPlayer().getInventory().getItems().add(Item.items().get(this.getId() - 1));
        if (this.getObstacle().getId() == 4) {
            getSnake();
        }
    }

    public void getSnake() {
        int randomNumber = r.nextInt(100);
        if (randomNumber <= 15) {
            //Silah kazanma durumu
            weaponRate();
        } else if (randomNumber <= 30) {
            //Zırh kazanma durumu
            armorRate();
        } else if (randomNumber <= 55) {
            //Para kazanma durumu
            moneyRate();
        } else {
            System.out.println("Hiç eşya düşmedi.");
        }
    }

    public void weaponRate() {
        int randomNum = r.nextInt(1, 101);
        if (randomNum <= 50) {
            System.out.println(Weapon.weapons().get(0).getName() + " kazandınız.");
            this.getPlayer().getInventory().setWeapon(Weapon.weapons().get(0));
        } else if (randomNum <= 80) {
            System.out.println(Weapon.weapons().get(1).getName() + " kazandınız.");
            this.getPlayer().getInventory().setWeapon(Weapon.weapons().get(1));
        } else if (randomNum <= 100) {
            System.out.println(Weapon.weapons().get(2).getName() + " kazandınız.");
            this.getPlayer().getInventory().setWeapon(Weapon.weapons().get(2));
        }
    }

    public void armorRate() {
        int randomNum = r.nextInt(1, 101);
        if (randomNum <= 50) {
            System.out.println(Armour.armours().get(0).getName() + " kazandınız.");
            this.getPlayer().getInventory().setArmour(Armour.armours().get(0));
        } else if (randomNum <= 80) {
            System.out.println(Armour.armours().get(1).getName() + " kazandınız.");
            this.getPlayer().getInventory().setArmour(Armour.armours().get(1));
        } else if (randomNum <= 100) {
            System.out.println(Armour.armours().get(2).getName() + " kazandınız.");
            this.getPlayer().getInventory().setArmour(Armour.armours().get(2));
        }
    }

    public void moneyRate() {
        int randomNum = r.nextInt(1, 101);
        int money = 0;
        if (randomNum <= 50) {
            money = 1;
            System.out.println("1 para kazandınız.");
            this.getPlayer().getGameChar().setMoney(getPlayer().getGameChar().getMoney() + money);

        } else if (randomNum <= 80) {
            money = 5;
            System.out.println("5 para kazandınız.");
            this.getPlayer().getGameChar().setMoney(getPlayer().getGameChar().getMoney() + money);

        } else if (randomNum <= 100) {
            money = 10;
            System.out.println("10 para kazandınız.");
            this.getPlayer().getGameChar().setMoney(getPlayer().getGameChar().getMoney() + money);

        }
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}
