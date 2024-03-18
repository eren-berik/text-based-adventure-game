package Monsters;

import Game.Player;
import Weapons.Armor;
import Weapons.Weapon;

import java.util.Random;

public class Snake extends Obstacle {
    private static final Random random = new Random();

    public Snake() {
        super(4, "Snake", decideDamage(), 12, decideAward());
    }

    private static int decideDamage() {
        return random.nextInt(4) + 3;
    }

    private static String decideAward() {
        int randomNumber = random.nextInt(100);
        if (randomNumber < 15) {
            randomNumber = random.nextInt(100);
            if (randomNumber < 20) {
                return Weapon.getWeaponById(1).getName();
            } else if (randomNumber < 50) {
                return Weapon.getWeaponById(2).getName();
            } else if (randomNumber < 100) {
                return Weapon.getWeaponById(3).getName();
            }
        } else if (randomNumber < 30) {
            randomNumber = random.nextInt(100);
            if (randomNumber < 20) {
                return Armor.getArmorById(1).getName();
            } else if (randomNumber < 50) {
                return Armor.getArmorById(2).getName();
            } else if (randomNumber < 100) {
                return Armor.getArmorById(3).getName();
            }
        } else if (randomNumber < 55) {
            randomNumber = random.nextInt(100);
            if (randomNumber < 20) {
                return "10 Money";
            } else if (randomNumber < 50) {
                return "5 Money";
            } else if (randomNumber < 100) {
                return "1 Money";
            }
        }

        return "No reward";
    }

}
