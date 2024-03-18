package Locations;

import Game.Player;

public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in the Safe House.");
        this.getPlayer().setHealth(this.getPlayer().getCharHealth());
        System.out.println("Your health has been regenerated!");

        if (this.getPlayer().hasWonGame()) {
            System.out.println("\nYOU WON!! You successfully carried all of the special items to the Safe House");
            return false;
        }


        return true;
    }
}
