import java.util.Scanner;

public class Wizard extends Character{
    String hat;
    double hpMultiplier=1.1;
    double wizardHp;
    double staminaMultiplier=0.8;
    double wizardStamina;
    double magicMultiplier=2.0;
    double wizardMagic;
    int minHeight=150;
    int maxHeight=200;

    public Wizard(Scanner sc) {
        super(sc);
    }

    public Wizard(String username, int height, String color, String hair) {
        super(username, height, color, hair);
        this.wizardHp=getHp()*this.hpMultiplier;
        this.wizardStamina=getStamina()*this.staminaMultiplier;
        this.wizardMagic=getMagicPower()*this.magicMultiplier;
    }
    public void makeWizard(){
        Wizard wizard;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        String username1 = sc.nextLine();
        System.out.println("Enter hight for you character, min is "+this.minHeight +
                " and max is "+this.maxHeight);
        int height1 = sc.nextInt();
        if (!isAllowedHight(height1)){
            System.out.println("You have to enter hight that is between min and max hight");
        }
        System.out.println("Enter color of the body for your wizard");
        String color1= sc.nextLine();  // skipping this line of code for some reason
        String color2= sc.nextLine();
        System.out.println("Enter color of hair for your wizard");
        String hair1= sc.nextLine();
        System.out.println("Describe the hat you want to have");
        String hat1 = sc.nextLine();
        wizard=new Wizard(username1,height1,color2,hair1);
        wizard.setHat(hat1);
        System.out.println("You successfully created your wizard");
        System.out.println(wizard);
        System.out.println("Would you like to try your character, press 1 to do some magic, press 2 to train and 3 to quit");
        int choice=Integer.valueOf(sc.nextLine());
        switch (choice){
            case 1: wizard.doingMagic();
                break;
            case 2: wizard.training();
                break;
            case 3: System.out.println("Goodbye " + wizard.getUsername());
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
    public void doingMagic() {
        while (hasStamina()) {
            System.out.println("You are doing some magic");
            this.wizardStamina -= 10;
            System.out.println("You lost 10 stamina, enter rest to restore stamina");
            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            if (option.equalsIgnoreCase("rest")) {
                rest();
            } else {
                doingMagic();
            }
        }
    }
    public void training (){
        while(hasStamina()){
            System.out.println("You are training");
            System.out.println("You gained 40 magic and lost 10 stamina");
            this.wizardMagic+=20*this.magicMultiplier;
            this.wizardStamina-=10;
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
        this.wizardStamina+=10;
        System.out.println("You gained 10 stamina");
        System.out.println("What would you like to do next\n1 to train\n2 to do some magic\n3 to quit");
        Scanner sc = new Scanner(System.in);
        int option = Integer.valueOf(sc.nextLine());
        switch (option){
            case 1 : training();
            break;
            case 2 : doingMagic();
                break;
            case 3:
                System.out.println("Goodbye " + getUsername());
                System.exit(0);
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }
    public boolean hasStamina(){
        if (this.wizardStamina<10){
            return false;
        } else return true;
    }
    @Override
    public String toString(){
        return "Your wizard has " + getHat() + " hat, his hp is " +
                this.wizardHp + ", his stamina is " + this.wizardStamina + " and his magic is "
                + this.wizardMagic;
                            }

    public String getHat() {
        return hat;
    }

    public void setHat(String hat) {
        this.hat = hat;
    }
}
