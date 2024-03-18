package Game;

import Weapons.*;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private String[] specialItems;
    private int numOfSpecialItems;

    public Inventory() {
        this.weapon = new Weapon(-1, "Fist", 0, 0);
        this.armor = new Armor(-1, "Rag", 0, 0);
        this.specialItems = new String[3];
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

    public String[] getSpecialItems() {
        return specialItems;
    }

    public void addSpecialItem(String itemName) {
        if (numOfSpecialItems < 4) {
            specialItems[numOfSpecialItems++] = itemName;
        } else {
            System.out.println("Inventory is full! Cannot add more special items.");
        }
    }

    public void printSpecialItems() {
        if (numOfSpecialItems == 0) {
            System.out.println("No special items in inventory.");
        } else {
            System.out.println("Special items in inventory:");
            for (int i = 0; i < numOfSpecialItems; i++) {
                System.out.println((i + 1) + ". " + specialItems[i]);
            }
        }
    }
}
