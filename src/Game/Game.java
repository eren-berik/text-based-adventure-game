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

        Location location = null;
        while (true) {
            player.printInfo();
            System.out.println("\nLocations:");
            System.out.println("1 - Safe House\t\tNo enemies here, just safe.");
            System.out.println("2 - Shop\t\tYou can buy weapons and armors.");
            System.out.println("3 - Cave\t\tReward <Food> - Be ware of Zombies!");
            System.out.println("4 - Forest\t\tReward <Firewood> - Be ware of Vampires!");
            System.out.println("5 - Cave\t\tReward <Water> - Be ware of Bears!");
            System.out.println("0 - Exit \t\tQuit the game.");
            System.out.print("Please select the destination: ");

            int selectLocation = sc.nextInt();

            switch (selectLocation) {
                case 0:
                    location = null;
                    break;
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
                default:
                    System.out.println("Please select a valid destination!");
                    continue;
            }

            if (location == null) {
                System.out.println("Game terminated...");
                break;
            }

            if (!location.onLocation()) {
                System.out.println("You are dead... Game Over!");
                break;
            }
        }


    }
}