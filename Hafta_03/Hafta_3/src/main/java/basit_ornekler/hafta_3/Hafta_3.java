package basit_ornekler.hafta_3;

public class Hafta_3 {

    public static void main(String[] args) {
        System.out.println("Selamlama1");
        sayHi();
        System.out.println("Selamlama2");

        // 2 ve 3. kısımları buradan çağır:
        KareAlma.carpma(3);
        HesapMakinesi.makine(3, 5, 10.0, 2.0);
    }

    public static void sayHi() {
        System.out.println("Hi");
    }

    // İç sınıfları static yap ki sınıfAdı.metot() diye çağırabilelim
    public static class KareAlma {
        public static void carpma(int a) {
            System.out.println(a * a);
        }
    }

    public static class HesapMakinesi {
        public static void makine (int a, int b, double c, double d) {
            System.out.println("Toplama: " + (a + b));
            System.out.println("Carpma: " + (a * b));
            System.out.println("Bolme: " + (c / d));
            System.out.println("Cikarma: " + (a - b));
        }
    }
}

