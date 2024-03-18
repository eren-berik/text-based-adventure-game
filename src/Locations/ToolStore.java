package Locations;

import Game.Player;
import Weapons.Armor;
import Weapons.Weapon;

public class ToolStore extends NormalLocation{
    public ToolStore(Player player) {
        super(player, "Shop");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------ Welcome to the Shop! ------");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1 - Weapons");
            System.out.println("2 - Armors");
            System.out.println("3 - Exit");
            System.out.print("Your choice: ");
            int selectCase = Location.sc.nextInt();

            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Invalid selection, please try again: ");
                selectCase = sc.nextInt();
            }

            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Come again!");
                    showMenu = false;
                    return true;
            }
        }

        return true;
    }

    public void printWeapon() {
        System.out.println("------ Weapons ------");
        System.out.println();

        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() + "\t\tPrice: " + w.getPrice() + "\t\tDamage: " + w.getDamage());
        }
        System.out.println("0 - Exit");
    }

    public void buyWeapon() {
        System.out.print("Select a weapon to buy: ");
        int selectWeaponId = sc.nextInt();

        while (selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
            System.out.println("Invalid selection, please try again: ");
            selectWeaponId = sc.nextInt();
        }

        if (selectWeaponId != 0) {
            Weapon selectedWeapon = Weapon.getWeaponById(selectWeaponId);

            if (Weapon.getWeaponById(selectWeaponId) != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money!");
                } else {
                    System.out.println("You successfully bought " + selectedWeapon.getName() + "!");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining money: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }


    }

    public void printArmor() {
        System.out.println("------ Armors ------");
        System.out.println();

        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() + "\t\tPrice: " + a.getPrice() + "\t\tArmor: " + a.getBlock());
        }
        System.out.println("0 - Exit");
    }

    public void buyArmor() {
        System.out.print("Select an armor to buy: ");
        int selectArmorId = sc.nextInt();

        while (selectArmorId < 0 || selectArmorId > Armor.armors().length) {
            System.out.println("Invalid selection, please try again: ");
            selectArmorId = sc.nextInt();
        }

        if (selectArmorId != 0) {
            Armor selectedArmor = Armor.getArmorById(selectArmorId);

            if (Armor.getArmorById(selectArmorId) != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("You don't have enough money!");
                } else {
                    System.out.println("You successfully bought " + selectedArmor.getName() + " Armor!");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining money: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                }
            }
        }
    }
}
