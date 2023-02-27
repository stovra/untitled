public class Person{
  private String name;
  private String surname;
  private int years;
 public Person(String name, String surname, int years){
this.name=name;
this.surname=surname;
this.years=years;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
     //   @Override
    public  String toString(){
        return (getName() + " " + getSurname() +", " + getYears() + " years old");
    }
}
