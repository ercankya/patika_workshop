package model.locs.battleLocs;

import model.Player;
import model.locs.Location;
import model.obstacles.Obstacle;

import java.util.Random;

public abstract class BattleLocation extends Location {

    private Obstacle obstacle;
    private String award;
    private int maxObstacle;


    public BattleLocation(Player player, String locName, Obstacle obstacle, String award, int maxObstacle) {
        super(player, locName);
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
            System.out.println(this.getLocName() + " daki tüm düşmanları yendiniz.");
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

            while (this.getPlayer().getGameChar().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.println("<S>AVAŞ VEYA <K>AÇ");
                String selectCase = input.nextLine().toUpperCase();
                if (selectCase.equals("S")) {
                    System.out.println("Vurdunuz");
                    this.getObstacle().setHealth(getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                    afterHit();
                    if (this.getObstacle().getHealth() > 0) {
                        System.out.println((i + 1) + ". " + this.getObstacle().getName() + "  Vurdu");
                        if (this.getPlayer().getInventory().getArmour().getBlock() > this.getObstacle().getDamage()) {
                            this.getPlayer().getInventory().getArmour().setBlock(this.getPlayer().getInventory().getArmour().getBlock() - this.getObstacle().getDamage());
                            afterHit();
                        } else {
                            this.getPlayer().getGameChar().setHealth(this.getPlayer().getGameChar().getHealth() + this.getPlayer().getInventory().getArmour().getBlock() - this.getObstacle().getDamage());
                            this.getPlayer().getInventory().getArmour().setBlock(0);
                            afterHit();
                        }
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

    public int randomObstacle() {
        Random r = new Random();
        return r.nextInt(this.maxObstacle) + 1;
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
