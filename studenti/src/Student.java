public class Student {
    private String ime;
    private String prezime;
    private double ocjena1;
    private double ocjena2;
    private double ocjena3;
    private double ocjena4;
    private double ocjena5;

    public double prosjek(){
        return (ocjena1+ocjena2+ocjena3+ocjena4+ocjena5)/5;
    }


    public Student (String ime, String prezime){
         this.ime = ime;
         this.prezime= prezime;
         this.ocjena1=0;
         this.ocjena2=0;
         this.ocjena3=0;
         this.ocjena4=0;
         this.ocjena5=0;
    }


    public String toString() {
        return "Ime " + this.ime + " prezime " +this.prezime;
    }



    public double getOcjena1() {
        return ocjena1;
    }

    public void setOcjena1(double ocjena1) {
        this.ocjena1 = ocjena1;
    }

    public double getOcjena2() {
        return ocjena2;
    }

    public void setOcjena2(double ocjena2) {
        this.ocjena2 = ocjena2;
    }

    public double getOcjena3() {
        return ocjena3;
    }

    public void setOcjena3(double ocjena3) {
        this.ocjena3 = ocjena3;
    }

    public double getOcjena4() {
        return ocjena4;
    }

    public void setOcjena4(double ocjena4) {
        this.ocjena4 = ocjena4;
    }

    public double getOcjena5() {
        return ocjena5;
    }

    public void setOcjena5(double ocjena5) {
        this.ocjena5 = ocjena5;
    }
}
