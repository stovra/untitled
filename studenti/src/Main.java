import java.util.*;
public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Student student1 = new Student("Adis", "Stovrag");
        Student student2 = new Student("Adnan", "Fazlic");
        Student student3 = new Student("Amar", "Catic");
        ArrayList<Student> lista = new ArrayList<>();
        lista.add(student2);
        lista.add(student1);
        lista.add(student3);
        System.out.println("Odaberite opciju");
        System.out.println("1 da dodate studenta, 2 da izracunate prosjek predmeta, 3 za ispis studenata");
        int odabranaOpcija= Integer.parseInt(scan.nextLine());
        switch (odabranaOpcija){
            case 1:
                  System.out.println("Unesite ime studenta kojeg zelite dodati");
                  String ime1 = scan.nextLine();
                  ime1 = ime1.substring(0,1).toUpperCase() + ime1.substring(1).toLowerCase();
                  System.out.println("Unesite prezime studenta kojeg zelite dodati");
                  String prezime1 = scan.nextLine();
                  prezime1 = prezime1.substring(0,1).toUpperCase() + prezime1.substring(1).toLowerCase();
                  lista.add(new Student(ime1, prezime1));
                  System.out.println("Uspjesno ste dodali " + ime1 + " " + prezime1);
                  System.out.println("Broj studenata " + lista.size());
                  System.out.println("Lista svih studenata: " +lista);


                      break;
            case 2:
                System.out.println("Unesite ocjenu iz prvog predmeta");
                double prvi= scan.nextInt();
                student1.setOcjena1(prvi);
                System.out.println("Unesite ocjenu iz drugog predmeta");
                double drugi= scan.nextInt();
                student1.setOcjena2(drugi);
                System.out.println("Unesite ocjenu iz treceg predmeta");
                double treci= scan.nextInt();
                student1.setOcjena3(treci);
                System.out.println("Unesite ocjenu iz cetvrtog predmeta");
                double cetvrti= scan.nextInt();
                student1.setOcjena4(cetvrti);
                System.out.println("Unesite ocjenu iz petog predmeta");
                double peti= scan.nextInt();
                student1.setOcjena5(peti);
                System.out.println("Prosjek predmeta je " + (student1.prosjek()));
                break;
            case 3:
                System.out.println("Ispis studenata : " + lista );
                break;
            default:
                System.out.println("Unijeli ste pogresan broj");
        }

      }
}