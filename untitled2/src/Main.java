import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

// Ako je djeljivo sa 3 print Fizz, ako je djeljivo sa 5 print Buzz, ako je djeljivo s oba print FizzBuzz
     Scanner scan = new Scanner(System.in);
    int a = Integer.valueOf(scan.nextLine());
    if (a % 5 == 0 && a % 3 == 0){
        System.out.println("FizzBuzz");
    } else if (a % 3 == 0){
        System.out.println("Fizz");
    } else if (a % 5 == 0){
        System.out.println("Buzz");
    } else {
        System.out.println(a);
    }
}}