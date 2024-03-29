package Locations;

import Game.Player;
import Monsters.Obstacle;
import Weapons.Armor;
import Weapons.Weapon;

import java.util.Random;

public class BattleLocation extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLocation(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        if (this.getPlayer().hasWonAward(this.getAward())) {
            System.out.println("You have already won the award for this location!");
            return false;
        }

        int obstacleNumber = randomObstacleNumber();

        System.out.println("You are here: " + this.getName());
        System.out.println("Be careful. There are " + obstacleNumber + " " + this.getObstacle().getName() + " here!");
        System.out.println("<F>ight or <R>un");

        String selectAction = sc.nextLine().toUpperCase();

        if (selectAction.equals("F")) {
            if (combat(obstacleNumber)) {
                System.out.println("All enemies are dead in " + this.getName());
                return true;
            }
        }

        if (this.getPlayer().getHealth() <= 0 ) {
            return false;
        }

        return true;
    }

    public boolean combat(int obstacleNumber) {
        Random random = new Random();

        for (int i = 1; i <= obstacleNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getDefaultHealth());
            playerStats();
            obstacleStats(i);

            boolean playerFirst = random.nextBoolean();

            while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {
                if (playerFirst) {
                    System.out.println("<H>it or <R>un");
                    String selectCombat = sc.nextLine().toUpperCase();

                    if (selectCombat.equals("H")) {
                        System.out.println("You hit!");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println(this.getObstacle().getName() + " hit you!");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    } else {
                        return false;
                    }
                } else {
                    System.out.println(this.getObstacle().getName() + " hit you!");
                    int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                    if (obstacleDamage < 0) {
                        obstacleDamage = 0;
                    }
                    this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                    afterHit();

                    if (this.getPlayer().getHealth() > 0) {
                        System.out.println("<H>it or <R>un");
                        String selectCombat = sc.nextLine().toUpperCase();

                        if (selectCombat.equals("H")) {
                            System.out.println("You hit!");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        } else {
                            return false;
                        }
                    }
                }
            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {
                System.out.println("You defeated the enemy!");
                System.out.println("Award: " + this.getObstacle().getMoneyAward());
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getMoneyAward());
                System.out.println("Your money: " + this.getPlayer().getMoney());
            }
        }

        if (allEnemiesDefeated(obstacleNumber)) {
            if (this.getAward() != null || this.getAward() != "Random") {
                this.getPlayer().getInventory().addSpecialItem(this.getAward());
                System.out.println("You found a special item!");
            }

            if (this.getObstacle().getItemAward() != null) {
                this.getPlayer().getInventory().printSpecialItems();
                equipItemReward(this.getObstacle().getItemAward());
                this.getPlayer().getInventory().addSpecialItem(this.getObstacle().getItemAward());
            }
        }
        return false;
    }


    private boolean allEnemiesDefeated(int obstacleNumber) {
        for (int i = 1; i <= obstacleNumber; i++) {
            if (this.getObstacle().getHealth() > 0) {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Your health: " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " health: " + this.getObstacle().getHealth());
        System.out.println();
    }

    public void playerStats() {
        System.out.println("Player Info");
        System.out.println("---------------------");
        System.out.println("Health: " + this.getPlayer().getHealth());
        System.out.println("Damage: " + this.getPlayer().getTotalDamage());
        System.out.println("Weapon: " + this.getPlayer().getWeapon().getName());
        System.out.println("Armor: " + this.getPlayer().getArmor().getName());
        System.out.println("Defense: " + this.getPlayer().getArmor().getBlock());
        System.out.println("Money: " + this.getPlayer().getMoney());
        System.out.println();
    }

    public void obstacleStats(int i) {
        System.out.println(i + ". " + this.getObstacle().getName() + " Info");
        System.out.println("---------------------");
        System.out.println("Health: " + this.getObstacle().getHealth());
        System.out.println("Damage: " + this.getObstacle().getDamage());
        System.out.println("Award: " + this.getObstacle().getMoneyAward() + " and " + this.getObstacle().getItemAward());
        System.out.println();
    }

    public int randomObstacleNumber() {
        Random r = new Random();

        return r.nextInt(this.getMaxObstacle()) + 1;
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

    public void equipItemReward(String itemReward) {
        if (itemReward.equals("Heavy")) {
            this.getPlayer().getInventory().setArmor(Armor.getArmorById(3));
        }
        if (itemReward.equals("Medium")) {
            this.getPlayer().getInventory().setArmor(Armor.getArmorById(2));
        }
        if (itemReward.equals("Light")) {
            this.getPlayer().getInventory().setArmor(Armor.getArmorById(1));
        }

        if (itemReward.equals("Rifle")) {
            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(3));
        }
        if (itemReward.equals("Sword")) {
            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(2));
        }
        if (itemReward.equals("Pistol")) {
            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(1));
        }

        if (itemReward.equals("Pistol")) {
            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(1));
        }

        if (itemReward.equals("Pistol")) {
            this.getPlayer().getInventory().setWeapon(Weapon.getWeaponById(1));
        }

        if (itemReward.equals("1 Money")) {
            this.getPlayer().setMoney(1 + this.getPlayer().getMoney());
        }

        if (itemReward.equals("5 Money")) {
            this.getPlayer().setMoney(5 + this.getPlayer().getMoney());
        }

        if (itemReward.equals("10 Money")) {
            this.getPlayer().setMoney(10 + this.getPlayer().getMoney());
        }

    }
}
