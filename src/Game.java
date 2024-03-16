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
    }
}
