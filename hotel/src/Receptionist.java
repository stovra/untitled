public class Receptionist extends Person{
    public Receptionist(String name, String surname, int years) {
        super(name, surname, years);
    }
    public void atTheReception(){
        System.out.println(getName() + " is at the reception");
    }
    public void helping(){
        System.out.println(getName() + " is helping customers with baggage");
    }
}
