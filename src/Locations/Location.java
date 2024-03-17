package Locations;
import Game.Player;

import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;
    public static Scanner sc = new Scanner(System.in);

    public Location(Player player, String name) {
        this.player = player;
        this.name = name;
    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
