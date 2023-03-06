import java.util.Scanner;

public class Human extends Character {
    private String sword;
    private String shoes;
    private double hpMultiplier=1.3;
    private double humanHp;
    private double staminaMultiplier=1.5;
    private double humanStamina;
    private double magicMultiplier=0.1;
    private double humanMagic;
    final private int minHeight=150;
    final private int maxHeight=200;


    public Human(String username, int height, String color, String hair) {
        super(username, height, color,hair);
        this.humanHp=getHp()*this.hpMultiplier;
        this.humanStamina=getStamina()*this.staminaMultiplier;
        this.humanMagic=getMagicPower()*this.magicMultiplier;
    }

    public Human(Scanner sc) {
        super(sc);
    }

    public void makeHuman(){
        Human human;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        String username1 = sc.nextLine();
        System.out.println("Enter hight for you character, min is "+this.minHeight +
                           " and max is "+this.maxHeight);
        int height1 = sc.nextInt();
        if (!isAllowedHight(height1)){
            System.out.println("You have to enter hight that is between min and max hight");
        }
        System.out.println("Enter color of the body for your human");
        String color1= sc.nextLine();  // skipping this line of code for some reason
        String color2= sc.nextLine();
        System.out.println("Enter color of hair for your human");
        String hair1= sc.nextLine();
        System.out.println("Describe the sword you want to have");
        String sword1 = sc.nextLine();
        System.out.println("Desribe the shoes you want to have");
        String shoes1= sc.nextLine();
        human=new Human(username1,height1,color2,hair1);
        human.setSword(sword1);
        human.setShoes(shoes1);
        System.out.println("You successfully created your human");
        System.out.println(human);
        System.out.println("Would you like to try your character, press 1 to walk, press 2 to train and 3 to quit");
        int choice=Integer.valueOf(sc.nextLine());
        switch (choice){
            case 1: human.walking();
            break;
            case 2: human.training();
            break;
            case 3: System.out.println("Goodbye "+human.getUsername());
            break;
            default:
                System.out.println("Wrong input");
        }
    }

                          // Check if height is allowed
      public boolean isAllowedHight (int number){
        if (number<this.minHeight || number >this.maxHeight){
            return false;
        } else return true;
                                                }
       public void walking() {
           while (hasStamina()) {
               System.out.println("You are walking");
               this.humanStamina -= 10;
               System.out.println("You lost 10 stamina, enter rest to restore stamina");
               Scanner sc = new Scanner(System.in);
               String option = sc.nextLine();
               if (option.equalsIgnoreCase("rest")) {
                   rest();
               } else {
                   walking();
               }
                                }
                              }
            public void training(){
              while(hasStamina()){
                 System.out.println("You are training\n");
                 System.out.println("You gained 26 hp and lost 10 stamina");
                 this.humanHp+=20*this.hpMultiplier;
                 this.humanStamina-=10;
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
           this.humanStamina+=10;
           System.out.println("You gained 10 stamina\n");
           System.out.println("What would you like to do next\n1 to train\n2 to walk\n3 to quit");
           Scanner sc = new Scanner(System.in);
           int option = Integer.valueOf(sc.nextLine());
           switch (option){
               case 1 : training();
               break;
               case 2 : walking();
               break;
               case 3:
                   System.out.println("Goodbye " + getUsername());
                   System.exit(0);
               default:
                   throw new IllegalStateException("Unexpected value: " + option);
                           }
       }
                           // Check if character has stamin
       public boolean hasStamina(){
        if (this.humanStamina<10){
            return false;
        } else return true;
       }

       public String getSword() {
        return sword;
    }

    public void setSword(String sword) {
        this.sword = sword;
    }

    public String getShoes() {
        return shoes;
    }

    public void setShoes(String shoes) {
        this.shoes = shoes;
    }
    @Override
    public String toString(){
        return "Your human has " + getSword() + " sword, his shoes are " + getShoes() + ", his hp is " +
                this.humanHp + ", his stamina is " + this.humanStamina + " and his magic is "
                + this.humanMagic;
    }
}
