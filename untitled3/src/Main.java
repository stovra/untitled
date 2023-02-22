public class Main {
    String name;
    String surname;
    int years;
    void instruction() {
        System.out.println("My name is " + name + ", my surname is " + surname + " and I am " + years + " years old");
    }
    public Main (String name, String  surname , int years){
        this.name=name;
        this.surname=surname;
        this.years=years;
    }
    public static void main(String[] args) {
        Main cleaner1 = new Main("Jessica", "Jessica", 36);
        Main cleaner2 = new Main("Anna", "Anna", 26);
        Main cleaner3 = new Main("Karen", "Karen", 33);
     cleaner1.instruction();
     cleaner2.instruction();
     cleaner3.instruction();

    }
}