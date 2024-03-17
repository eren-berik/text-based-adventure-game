package Locations;

import Game.Player;
import Monsters.Bear;
import Monsters.Obstacle;

public class River extends BattleLocation{
    public River(Player player) {
        super(player, "River", new Bear(), "Water", 2);
    }
}
