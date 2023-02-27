public class Cleaner extends Person{

    public Cleaner(String name, String surname, int years) {
        super(name, surname, years);
    }
    public void cleaning(){

        System.out.println(getName() + " is cleaning bedrooms right now");
    }
    public void resting(){
        System.out.println(getName() + " is currently resting");
    }
    public void dayOff(){
        System.out.println(getName() + " has day off");
    }
}
