
package basit_ornekler.hafta_1_2;


public class Hafta_1_2 {

    public static void main(String[] args) {
        String text = "JavaProgramingLanguage";
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                count++;
            }
        }
        System.out.println("Büyük harf Sayısı: " + count);
    }
}    