package Locations;

import Game.Player;
import Monsters.Obstacle;
import Monsters.Snake;
import Weapons.Armor;
import Weapons.Weapon;

import java.util.Random;

public class Mine extends BattleLocation{
    public Mine(Player player) {
        super(player, "Mine", new Snake(), "Random", 6);
    }


}
