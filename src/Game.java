import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in);

    public void startGame() {
        System.out.println("Welcome to the Adventure Game!");
        System.out.print("Please enter your character's name: ");
        String playerName = sc.nextLine();
    }
}
