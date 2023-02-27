public class Waiter extends Person{
    public Waiter (String name, String surname, int years){
        super(name, surname, years);
    }
    public void atTheBar(){
        System.out.println(getName() + " is currently at the bar");
    }
    public void serving(){
        System.out.println(getName() + " is currently serving the guests");
    }
    public void atBreak(){
        System.out.println(getName() + " is at the break");
    }
}
