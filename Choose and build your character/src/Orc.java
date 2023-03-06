import java.util.Scanner;

public class Orc extends Character{
    String claw;
    String mace;
    double hpMultiplier=1.9;
    double orcHp;
    double staminaMultiplier=1.3;
    double orcStamina;
    double magicMultiplier=0.4;
    double orcMagic;
    int minHeight=178;
    int maxHeight=230;

    public Orc(Scanner sc) {
        super(sc);
    }
    public Orc(String username, int height, String color, String hair) {
        super(username, height, color, hair);
        this.orcHp=getHp()*this.hpMultiplier;
        this.orcStamina=getStamina()*this.staminaMultiplier;
        this.orcMagic=getMagicPower()*this.magicMultiplier;
    }

    public void makeOrc(){
        Orc orc;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        String username1 = sc.nextLine();
        System.out.println("Enter hight for you character, min is "+this.minHeight +
                " and max is "+this.maxHeight);
        int height1 = sc.nextInt();
        if (!isAllowedHight(height1)){
            System.out.println("You have to enter hight that is between min and max hight");
        }
        System.out.println("Enter color of the body for your orc");
        String color1= sc.nextLine();  // skipping this line of code for some reason
        String color2= sc.nextLine();
        System.out.println("Enter color of hair for your orc");
        String hair1= sc.nextLine();
        System.out.println("Describe the claw you want to have");
        String claw1 = sc.nextLine();
        System.out.println("Desribe the mace you want to have");
        String mace1= sc.nextLine();
        orc=new Orc(username1,height1,color2,hair1);
        orc.setClaw(claw1);
        orc.setMace(mace1);
        System.out.println("You successfully created your orc");
        System.out.println(orc);
        System.out.println("Would you like to try your character, press 1 to hunt, press 2 to train and 3 to quit");
        int choice=Integer.valueOf(sc.nextLine());
        switch (choice){
            case 1: orc.hunting();
                break;
            case 2: orc.training();
                break;
            case 3: System.out.println("Goodbye " + orc.getUsername());
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
    public void hunting() {
        while (hasStamina()) {
            System.out.println("You are hunting");
            this.orcStamina -= 10;
            System.out.println("You lost 10 stamina, enter rest to restore stamina");
            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            if (option.equalsIgnoreCase("rest")) {
                rest();
            } else {
                hunting();
            }
        }
    }
    public void training(){
        while(hasStamina()){
            System.out.println("You are training\n");
            System.out.println("You gained 38 hp and lost 10 stamina");
            this.orcHp+=20*this.hpMultiplier;
            this.orcStamina-=10;
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
        this.orcStamina+=10;
        System.out.println("You gained 10 stamina\n");
        System.out.println("What would you like to do next\n1 to train\n2 to hunt\n3 to quit");
        Scanner sc = new Scanner(System.in);
        int option = Integer.valueOf(sc.nextLine());
        switch (option){
            case 1 : training();
            break;
            case 2 : hunting();
            break;
            case 3:
                System.out.println("Goodbye " + getUsername());
                System.exit(0);
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }
    public boolean hasStamina(){
        if (this.orcStamina<10){
            return false;
        } else return true;
    }
    @Override
    public String toString() {
        return "Your 0rc has " + getClaw() + " claws, his mace is " + getMace() + ", his hp is " +
                this.orcHp + ", his stamina is " + this.orcStamina + " and his magic is "
                + this.orcMagic;
    }

    public String getClaw() {
        return claw;
    }

    public void setClaw(String claw) {
        this.claw = claw;
    }

    public String getMace() {
        return mace;
    }

    public void setMace(String mace) {
        this.mace = mace;
    }
}
