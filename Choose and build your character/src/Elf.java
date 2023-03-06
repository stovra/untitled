import java.util.Scanner;

public class Elf extends Character {
    String bow;
    double hpMultiplier = 0.9;
    double elfHp;
    double staminaMultiplier = 1.6;
    double elfStamina;
    double magicMultiplier = 1.7;
    double elfMagic;
    int minHeight = 152;
    int maxHeight = 190;

    public Elf(Scanner sc) {
        super(sc);
    }
    public Elf(String username, int height, String color, String hair) {
        super(username, height, color, hair);
        this.elfHp = getHp() * this.hpMultiplier;
        this.elfStamina = getStamina() * this.staminaMultiplier;
        this.elfMagic = getMagicPower() * this.magicMultiplier;
    }

    public void makeElf(){
        Elf elf;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        String username1 = sc.nextLine();
        System.out.println("Enter hight for you character, min is "+this.minHeight +
                " and max is "+this.maxHeight);
        int height1 = sc.nextInt();
        if (!isAllowedHight(height1)){
            System.out.println("You have to enter hight that is between min and max hight");
        }
        System.out.println("Enter color of the body for your elf");
        String color1= sc.nextLine();  // skipping this line of code for some reason
        String color2= sc.nextLine();
        System.out.println("Enter color of hair for your elf");
        String hair1= sc.nextLine();
        System.out.println("Describe the bow you want to have");
        String bow1 = sc.nextLine();
        elf=new Elf(username1,height1,color2,hair1);
        elf.setBow(bow1);
        System.out.println("You successfully created your elf");
        System.out.println(elf);
        System.out.println("Would you like to try your character, press 1 to shoot bow, press 2 to train and 3 to quit");
        int choice=Integer.valueOf(sc.nextLine());
        switch (choice){
            case 1: elf.shootingBow();
                break;
            case 2: elf.training();
                break;
            case 3: System.out.println("Goodbye " +elf.getUsername());
                break;
            default:
                System.out.println("Wrong input");
        }
    }
    public boolean isAllowedHight(int number) {
        if (number < this.minHeight && number > this.maxHeight) {
            return false;
        } else return true;
    }

    public void shootingBow() {
        while (hasStamina()) {
            System.out.println("You are shooting bow");
            this.elfStamina -= 10;
            System.out.println("You lost 10 stamina, enter rest to restore stamina");
            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            if (option.equalsIgnoreCase("rest")) {
                rest();
            } else {
                shootingBow();
            }
        }
    }

    public void training() {
        while (hasStamina()) {
            System.out.println("You are training");
            System.out.println("You gained 34 magic and lost 10 stamina");
            this.elfMagic += 20 * this.magicMultiplier;
            this.elfStamina -= 10;
            System.out.println("Train more or go to rest");
            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            if (option.equalsIgnoreCase("rest")) {
                rest();
            } else {
                training();
            }

        }
    }

    public void rest() {
        System.out.println("You are currently resting ");
        this.elfStamina += 10;
        System.out.println("You gained 10 stamina");
        System.out.println("What would you like to do next\n1 to train\n2 to shoot bow\n3 to quit");
        Scanner sc = new Scanner(System.in);
        int option = Integer.valueOf(sc.nextLine());
        switch (option) {
            case 1:
                training();
                break;
            case 2:
                shootingBow();
                break;
            case 3:
                System.out.println("Goodbye " + getUsername());
                System.exit(0);
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    public boolean hasStamina() {
        if (this.elfStamina < 10) {
            return false;
        } else return true;
    }

    @Override
    public String toString() {
        return "Your elf has " + getBow() + " bow, his hp is " +
                this.elfHp + ", his stamina is " + this.elfStamina + " and his magic is "
                + this.elfMagic;
    }

    public String getBow() {
        return bow;
    }

    public void setBow(String bow) {
        this.bow = bow;
    }
}