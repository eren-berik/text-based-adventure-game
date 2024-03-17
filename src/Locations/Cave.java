package Locations;

import Game.Player;
import Monsters.Obstacle;
import Monsters.Zombie;

public class Cave extends BattleLocation{

    public Cave(Player player) {
        super(player, "Cave", new Zombie(), "Food", 3);
    }
}
