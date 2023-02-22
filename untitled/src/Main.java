import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        int rand = random.nextInt(100);

        Scanner scan = new Scanner(System.in);

      System.out.println("Enter your name");
      String name = scan.nextLine();

      System.out.println("Hello, " + name + " would you like to play guessing game, if yes enter 1");
      int number = Integer.valueOf(scan.nextLine());
      if (number == 1) {

          System.out.println("Lets play, enter a number between 1 and 100");

      } else System.out.println("Maybe next time then, good bye");

    while (number ==1) {
        int number2 = Integer.valueOf(scan.nextLine());
        if (number2 == rand) {
            System.out.println("Well done, you have won");
        }else System.out.println("Sorry, better luck next time");
        System.out.println("The right number was " + rand);
    }

    }}