
package basit_ornekler.hafta_1_2;
import java.util.Scanner;

public class Hafta_1_2 {

    public static void main(String[] args) {
        String text = "JavaProgramingLanguage";
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                count++;
            }
        }
        System.out.println("Buyuk harf Sayisi: " + count);
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Adinizi girin: ");
        String name = input.nextLine();
        
        System.out.print("Yasinizi girin: ");
        int age = input.nextInt();
        
        System.out.println("Merhaba " + name + ", yasiniz: " + age );
        
        input.close();
    }
}    