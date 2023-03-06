import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Human human=new Human (sc);
        Orc orc=new Orc(sc);
        Elf elf=new Elf(sc);
        Dwarf dwarf= new Dwarf(sc);
        Fairy fairy = new Fairy(sc);
        Wizard wizard = new Wizard(sc);
        System.out.println("Hello, what character would you like to make?\n1" +
                " to make human\n2 to make orc\n3 to make elf\n4 to make dwarf\n5" +
                " to make fairy\n6 to make wizard");
        int option = sc.nextInt();
        switch (option){
            case 1 : human.makeHuman();
            break;
            case 2 : orc.makeOrc();
            break;
            case 3 : elf.makeElf();
            break;
            case 4 : dwarf.makeDwarf();
            break;
            case 5 : fairy.makeFairy();
            break;
            case 6 : wizard.makeWizard();
            break;
            default:
                System.out.println("Wrong input");
        }

    }
}