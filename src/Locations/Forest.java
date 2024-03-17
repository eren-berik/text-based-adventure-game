package Locations;

import Game.Player;
import Monsters.Obstacle;
import Monsters.Vampire;

public class Forest extends BattleLocation{
    public Forest(Player player) {
        super(player, "Forest", new Vampire(), "Firewood", 3);
    }
}
