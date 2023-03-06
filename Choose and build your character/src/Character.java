import java.util.Scanner;

public class Character {
    private  String username;
    private  int height;
    private  String color;
    private  String hair;
    private  double hp=100;
    private  double stamina=100;
    private  double magicPower=100;
    private Scanner sc;

    public Character(Scanner sc){
        this.sc=sc;
    }

    public Character(String username, int height, String color, String hair) {
        this.username = username;
        this.height = height;
        this.color = color;
        this.hair = hair;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public double getMagicPower() {
        return magicPower;
    }

    public void setMagicPower(int magicPower) {
        this.magicPower = magicPower;
    }
}
