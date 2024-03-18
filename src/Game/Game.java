package Game;

import Locations.*;

import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in);

    public void startGame() {
        System.out.println("Welcome to the Adventure Game!");
        System.out.print("Please enter your character's name: ");
        String playerName = sc.nextLine();

        Player player = new Player(playerName);
        System.out.println("Welcome " + player.getName() + "!");

        System.out.println("Please select a character to start...");
        player.selectChar();

        while (true) {
            System.out.println("\n---------- Menu ----------");
            System.out.println("1 - Safe House\t\tNo enemies here, just safe.");
            System.out.println("2 - Shop\t\tYou can buy weapons and armors.");
            System.out.println("3 - Cave\t\tReward <Food> - Be ware of Zombies!");
            System.out.println("4 - Forest\t\tReward <Firewood> - Be ware of Vampires!");
            System.out.println("5 - River\t\tReward <Water> - Be ware of Bears!");
            System.out.println("6 - Mine\t\tReward <Random> - Be ware of Snakes!");
            System.out.println("0 - Exit \t\tQuit the game.");
            System.out.println("---------- **** ----------");
            player.printInfo();
            System.out.println("---------- **** ----------");
            System.out.print("Please select the destination: ");

            int selectLocation = sc.nextInt();

            Location location = null;
            switch (selectLocation) {
                case 0:
                    System.out.println("Game terminated...");
                    return;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                case 6:
                    location = new Mine(player);
                    break;
                default:
                    System.out.println("Please select a valid destination!");
                    continue;
            }

            if (location != null) {
                if (!location.onLocation()) {
                    if (player.hasWonGame() && location instanceof SafeHouse) {
                        return;
                    } else if (player.getHealth() <= 0) {
                        System.out.println("You are dead... Game Over!");
                        return;
                    } else if (player.hasWonGame()) {
                        System.out.println("Carry those items to Safe House to finish the game!");
                    }
                }
            }

        }
    }
}
