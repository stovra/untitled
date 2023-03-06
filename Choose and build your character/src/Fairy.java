import java.util.Scanner;

public class Fairy extends Character{
    private String blowgun;
    private double hpMultiplier=1.0;
    private double fairyHp;
    private double staminaMultiplier=1.1;
    private double fairyStamina;
    private double magicMultiplier=1.9;
    private double fairyMagic;
    private final int minHeight=10;
    private final int maxHeight=30;

    public Fairy(Scanner sc) {
        super(sc);
    }
    public Fairy(String username, int height, String color, String hair) {
        super(username, height, color, hair);
        this.fairyHp=getHp()*this.hpMultiplier;
        this.fairyStamina=getStamina()*this.staminaMultiplier;
        this.fairyMagic=getMagicPower()*this.magicMultiplier;
    }
    public void makeFairy(){
        Fairy fairy;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        String username1 = sc.nextLine();
        System.out.println("Enter hight for you character, min is "+this.minHeight +
                " and max is "+this.maxHeight);
        int height1 = sc.nextInt();
        if (!isAllowedHight(height1)){
            System.out.println("You have to enter hight that is between min and max hight");
        }
        System.out.println("Enter color of the body for your fairy");
        String color1= sc.nextLine();  // skipping this line of code for some reason
        String color2= sc.nextLine();
        System.out.println("Enter color of hair for your fairy");
        String hair1= sc.nextLine();
        System.out.println("Describe the blowgun you want to have");
        String blowgun1 = sc.nextLine();
        fairy=new Fairy(username1,height1,color2,hair1);
        fairy.setBlowgun(blowgun1);
        System.out.println("You successfully created your fairy");
        System.out.println(fairy);
        System.out.println("Would you like to try your character, press 1 to fly, press 2 to train and 3 to quit");
        int choice=Integer.valueOf(sc.nextLine());
        switch (choice){
            case 1: fairy.flying();
                break;
            case 2: fairy.training();
                break;
            case 3: System.out.println("Goodbye " + fairy.getUsername());
                break;
            default:
                System.out.println("Wrong input");
        }
    }
    public boolean isAllowedHight (int number) {
        if (number < this.minHeight && number > this.maxHeight) {
            return false;
        } else return true;
    }
    public void flying() {
        while (hasStamina()) {
            System.out.println("You are flying");
            this.fairyStamina -= 10;
            System.out.println("You lost 10 stamina, enter rest to restore stamina");
            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            if (option.equalsIgnoreCase("rest")) {
                rest();
            } else {
                flying();
            }
        }
    }
    public void training(){
        while(hasStamina()){
            System.out.println("You are training");
            System.out.println("You gained 38 magic and lost 10 stamina");
            this.fairyMagic+=20*this.magicMultiplier;
            this.fairyStamina-=10;
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
    public void rest(){
        System.out.println("You are currently resting ");
        this.fairyStamina+=10;
        System.out.println("You gained 10 stamina");
        System.out.println("What would you like to do next\n1 to train\n2 to fly\n3 to quit");
        Scanner sc = new Scanner(System.in);
        int option = Integer.valueOf(sc.nextLine());
        switch (option){
            case 1 : training();
            break;
            case 2 : flying();
                break;
            case 3:
                System.out.println("Goodbye " + getUsername());
                System.exit(0);
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }
    public boolean hasStamina(){
        if (this.fairyStamina<10){
            return false;
        } else return true;
    }
    @Override
    public String toString(){
        return "Your fairy has " + getBlowgun() + " blowgun, her hp is " +
                this.fairyHp + ", her stamina is " + this.fairyStamina + " and her magic is "
                + this.fairyMagic;
    }

    public String getBlowgun() {
        return blowgun;
    }

    public void setBlowgun(String blowgun) {
        this.blowgun = blowgun;
    }
}
