import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    static void myFunction() {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> cars = new ArrayList<String>();

        System.out.println("What is your favourite car");
        String firstCar = scan.nextLine();
        cars.add(firstCar);

        System.out.println("What is your second favourite car");
        String secondCar = scan.nextLine();
        cars.add(secondCar);

        System.out.println("Any car that you hate, type no if no ");
        String thirdCar = scan.nextLine();

        if (thirdCar.equals("no")) {
            System.out.println("Favourite car " + cars.get(0) + ", second favourite " + cars.get(1));
        } else cars.add(thirdCar);
        System.out.println("Favourite car " + cars.get(0) + ", second favourite " + cars.get(1));
        System.out.println("And the car you hate is " + cars.get(2));


    }
     // Fol neka anketa za 10 ljudi..
    public static void main(String[] args) {
        for (int i = 0; i<10; i++){
        myFunction();
        }
    }

}