import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Person person;
        ArrayList <Person> workersList = new ArrayList<>();
                                 // Cleaners
        Cleaner cleaner1 = new Cleaner("Anna", "Smith", 32);
        Cleaner cleaner2 = new Cleaner("Elisa", "Clark", 28);
        Cleaner cleaner3 = new Cleaner("Erica", "Walker", 25);
        workersList.add(cleaner1);
        workersList.add(cleaner2);
        workersList.add(cleaner3);
                                 // Waiters
        Waiter waiter1=new Waiter("Jonathan", "Murray", 35);
        Waiter waiter2=new Waiter("Paul", "Fox", 33);
        Waiter waiter3=new Waiter("Ryan", "Brown", 22);
        workersList.add(waiter1);
        workersList.add(waiter2);
        workersList.add(waiter3);
                                // Receptionists
        Receptionist receptionist1=new Receptionist("Jake", "Green", 40);
        Receptionist receptionist2=new Receptionist("Robert", "Robinson", 23);
        Receptionist receptionist3=new Receptionist("Martin", "White", 26);
        workersList.add(receptionist1);
        workersList.add(receptionist2);
        workersList.add(receptionist3);

        System.out.println("Hello BOSS, what would you like to do");
        System.out.println("""
                Choose 1 option
                1. Get report on all of your workers
                2. Hire new workers
                3. Check how many workers you have and their personal informations
                4. Fire all""");
        int option = scan.nextInt();
                                    // Report on workers
        if (option==1){
            cleaner1.dayOff();
            cleaner2.cleaning();
            cleaner3.resting();
            waiter1.atBreak();
            waiter2.atTheBar();
            waiter3.serving();
            receptionist1.atTheReception();
            receptionist2.helping();
            receptionist3.helping();
        } else if (option==2){            //Hiring new workers
            System.out.println("""
                    Choose
                    1 to hire new receptionist
                    2 to hire new waiter
                    3 to hire new cleaner""");
                    int choice = scan.nextInt();
                    if (choice==1){
                        System.out.println("Give me the name of new receptionist");
                        String name = scan.nextLine();
                        System.out.println("Now the surname");
                        String surname = scan.nextLine();
                        System.out.println("And finally years");
                        int years = Integer.parseInt(scan.nextLine());
                        person=new Person(name, surname, years);
                        System.out.println("You successfully hired " + person);
                    } else if (choice==2){
                        System.out.println("Name of the waiter?");
                        String name = scan.nextLine();
                        System.out.println("Surname?");
                        String surname = scan.nextLine();
                        System.out.println("Years of the waiter?");
                        int years = Integer.parseInt(scan.nextLine());
                        person=new Person(name, surname, years);
                        System.out.println("You successfully hired " + person);
                    } else if (choice == 3) {
                System.out.println("Name of the cleaner?");
                String name = scan.nextLine();
                System.out.println("Surname?");
                String surname = scan.nextLine();
                System.out.println("Years of the cleaner?");
                int years = Integer.parseInt(scan.nextLine());
                person=new Person(name, surname, years);
                System.out.println("You successfully hired " + person);
                    } else  {
                System.out.println("Wrong input");
            }
              } else if (option == 3) {     // Info about workers
            System.out.println("Currently you have " + workersList.size() + " workers in your hotel");
            System.out.println(workersList);
        } else if (option == 4){              //Firing all of workers
            System.out.println("Little bit harsh boss, but okay");
            workersList.clear();
            System.out.println("You fired all of your workers");
            System.out.println("Now number of your workers is "+workersList.size());
        } else  {
            System.out.println("Your input was wrong, you have to enter number from 1 to 4");
        }

    }
}