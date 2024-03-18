package Game;

import GameChars.*;
import Weapons.Armor;
import Weapons.Weapon;

import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int charHealth;
    private int money;
    private String name;
    private String charName;
    private final Scanner sc = new Scanner(System.in);
    private Inventory inventory;

    public Player(String name) {

        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println("-----------------------");
        for (GameChar gameChar : charList) {
            System.out.println("ID: " + gameChar.getId() +
                    "\tCharacter: " + gameChar.getName() + "\t->" +
                    "\tDamage: " + gameChar.getDamage() +
                    "\tHealth:" + gameChar.getHealth() +
                    "\tMoney: " + gameChar.getMoney());
        }
        System.out.println("-----------------------");

        System.out.print("Please select a character: ");
        int selectChar = sc.nextInt();
        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }

        System.out.println("You are beginning your journey as a famous " + this.charName);
    }

    public void initPlayer(GameChar gameChar) {
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setCharHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo() {
        System.out.println("Weapon: " + this.getInventory().getWeapon().getName() +
                "\tArmor: " + this.getInventory().getArmor().getName() +
                "\tBlockage: " + this.getInventory().getArmor().getBlock() +
                "\tDamage: " + this.getTotalDamage() +
                "\tHealth:" + this.getHealth() +
                "\tMoney: " + this.getMoney() +
                "\nSpecial Items: ");
        this.getInventory().printSpecialItems();
    }

    public boolean hasWonAward(String award) {
        String[] specialItems = this.getInventory().getSpecialItems();
        for (String specialItem : specialItems) {
            if (specialItem != null && specialItem.equals(award)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasWonGame() {
        String[] specialItems = this.getInventory().getSpecialItems();
        int count = 0;
        for (int i = 0; i < specialItems.length; i++) {
            if (specialItems[i] != null && (specialItems[i].equals("Food") || specialItems[i].equals("Firewood") || specialItems[i].equals("Water"))) {
                count++;
                if (count == 3) {
                    return true;
                }
            }
        }
        return false;
    }


    public int getTotalDamage() {
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            health = 0;
        }
        this.health = health;
    }

    public int getCharHealth() {
        return charHealth;
    }

    public void setCharHealth(int charHealth) {
        this.charHealth = charHealth;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapon getWeapon() {
        return this.getInventory().getWeapon();
    }

    public Armor getArmor() {
        return this.getInventory().getArmor();
    }
}
