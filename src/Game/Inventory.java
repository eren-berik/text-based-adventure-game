package Game;

import Weapons.*;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private String[] battleLocationAwards;
    private int numOfSpecialItems;

    public Inventory() {
        this.weapon = new Weapon(-1, "Fist", 0, 0);
        this.armor = new Armor(-1, "Rag", 0, 0);
        this.battleLocationAwards = new String[5];
        this.numOfSpecialItems = 0;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public String[] getBattleLocationAwards() {
        return battleLocationAwards;
    }

    public void addSpecialItem(String itemName) {
        if (numOfSpecialItems < 6) {
            battleLocationAwards[numOfSpecialItems++] = itemName;
        } else {
            System.out.println("Inventory is full! Cannot add more special items.");
        }
    }

    public void printSpecialItems() {
        if (numOfSpecialItems == 0) {
            System.out.println("No special items in inventory.");
        } else {
            System.out.println("Items won from the battle(s):");
            for (int i = 0; i < numOfSpecialItems; i++) {
                System.out.println((i + 1) + ". " + battleLocationAwards[i]);
            }
        }
    }
}
