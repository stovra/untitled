import java.util.Scanner;

public class Dwarf extends Character{
    private String axe;
    private double hpMultiplier=1.1;
    private double dwarfHp;
    private double staminaMultiplier=0.9;
    private double dwarfStamina;
    private double magicMultiplier=0.3;
    private double dwarfMagic;
    private final int minHeight=90;
    private final int maxHeight=120;

    public Dwarf(Scanner sc) {
        super(sc);
    }

    public void makeDwarf(){
        Dwarf dwarf;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        String username1 = sc.nextLine();
        System.out.println("Enter hight for you character, min is "+this.minHeight +
                " and max is "+this.maxHeight);
        int height1 = sc.nextInt();
        if (!isAllowedHight(height1)){
            System.out.println("You have to enter hight that is between min and max hight");
        }
        System.out.println("Enter color of the body for your dwarf");
        String color1= sc.nextLine();  // skipping this line of code for some reason
        String color2= sc.nextLine();
        System.out.println("Enter color of hair for your dwarf");
        String hair1= sc.nextLine();
        System.out.println("Describe the axe you want to have");
        String axe1 = sc.nextLine();
        dwarf=new Dwarf(username1,height1,color2,hair1);
        dwarf.setAxe(axe1);
        System.out.println("You successfully created your dwarf");
        System.out.println(dwarf);
        System.out.println("Would you like to try your character, press 1 cut trees, press 2 to train and 3 to quit");
        int choice=Integer.valueOf(sc.nextLine());
        switch (choice){
            case 1: dwarf.axingTrees();
                break;
            case 2: dwarf.training();
                break;
            case 3: System.out.println("Goodbye " + dwarf.getUsername());
                break;
            default:
                System.out.println("Wrong input");
        }
    }
    public Dwarf(String username, int height, String color, String hair) {
        super(username, height, color, hair);
        this.dwarfHp=getHp()*this.hpMultiplier;
        this.dwarfStamina=getStamina()*this.staminaMultiplier;
        this.dwarfMagic=getMagicPower()*this.magicMultiplier;
    }
    public boolean isAllowedHight (int number) {
        if (number < this.minHeight && number > this.maxHeight) {
            return false;
        } else return true;
    }
    public void axingTrees() {
        while (hasStamina()) {
            System.out.println("You are using your axe to cut trees");
            this.dwarfStamina -= 10;
            System.out.println("You lost 10 stamina, enter rest to restore stamina");
            Scanner sc = new Scanner(System.in);
            String option = sc.nextLine();
            if (option.equalsIgnoreCase("rest")) {
                rest();
            } else {
                axingTrees();
            }
        }
    }
    public void training(){
        while(hasStamina()){
            System.out.println("You are training");
            System.out.println("You gained 22 hp and lost 10 stamina");
            this.dwarfHp+=20*this.hpMultiplier;
            this.dwarfStamina-=10;
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
        this.dwarfStamina+=10;
        System.out.println("You gained 10 stamina");
        System.out.println("What would you like to do next\n1 to train\n2 to cut trees\n3 to quit");
        Scanner sc = new Scanner(System.in);
        int option = Integer.valueOf(sc.nextLine());
        switch (option){
            case 1 : training();
            break;
            case 2 : axingTrees();
                break;
            case 3:
                System.out.println("Goodbye " + getUsername());
                System.exit(0);
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }
    public boolean hasStamina(){
        if (this.dwarfStamina<10){
            return false;
        } else return true;
    }
    @Override
    public String toString(){
        return "Your dwarf has " + getAxe() + " axe, his hp is " +
                this.dwarfHp + ", his stamina is " + this.dwarfStamina + " and his magic is "
                + this.dwarfMagic;
                }

    public String getAxe() {
        return axe;
    }

    public void setAxe(String axe) {
        this.axe = axe;
    }
}
