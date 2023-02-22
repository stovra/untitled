import java.util.Scanner;

public class Main {

    String quote1 = "\"It is better to fail in originality than to succeed in imitation.\" — Herman Melville";
    String quote2 = "\"Success is not final; failure is not fatal: It is the courage to continue that counts.\" — Winston S. Churchill";
    String quote3 = "\"I never dreamed about success. I worked for it.\" —Estée Lauder";
    String quote4 = "\"To know how much there is to know is the beginning of learning to live\" —Dorothy West";
    String quote5 = "\"Either you run the day or the day runs you\" — Jim Rohn";

    public static void main(String[] args) {
    Main quotes = new Main();
        Scanner scan = new Scanner(System.in);
    System.out.println("Enter a number between 1 and 6 to get  quote");
    int number = Integer.valueOf(scan.nextLine());
    switch (number) {
        case 1 : System.out.println(quotes.quote1);
            break;
        case 2: System.out.println(quotes.quote2);
            break;
        case 3 : System.out.println(quotes.quote3);
            break;
        case 4 : System.out.println(quotes.quote4);
            break;
        case 5 : System.out.println(quotes.quote5);
            break;

    }

}}