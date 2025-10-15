
package basit_ornekler.hafta_1;


public class Hafta_1 {

    public static void main(String[] args) {
        System.out.println("Merhaba Dunya");
        
        int sayi = 5; 
        int faktoriyel = 1;

        for (int i = 1; i <= sayi; i++) {
            faktoriyel *= i;
        }

        System.out.println(sayi + "! = " + faktoriyel);
        
        
        int number = 8;
        if(number % 2 == 0) {
            System.out.println(number + " cift sayidir");
        } else {
            System.out.println(number + " tek sayidir");
            
            
            
        }
    }
}