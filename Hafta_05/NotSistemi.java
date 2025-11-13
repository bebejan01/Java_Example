/*
Bir üniversitede her öğrencinin adı, numarası ve ders notları tutulur.
Sistem:
  - Öğrenci oluşturulurken adı ve numarası kurucu ile atanır.
  - Notlar (vize, final) metot ile girilir.
  - Ortalama otomatik hesaplanır (vize %40, final %60).
  - Harf notu (AA, BB, CC, DD, FF) otomatik belirlenir.
*/

public class NotSistemi {
    public static void main(String[] args) {
        // Öğrenci nesneleri
        Ogrenci o1 = new Ogrenci("Ali", 101);
        Ogrenci o2 = new Ogrenci("Ayşe", 102);
        Ogrenci o3 = new Ogrenci("Mehmet", 103);

        // Not girişleri
        o1.notGir(85, 90);
        o2.notGir(70, 65);
        o3.notGir(50, 45);

        // Bilgileri yazdır
        o1.bilgiGoster();
        o2.bilgiGoster();
        o3.bilgiGoster();
    }

    // İç sınıf: Öğrenci
    static class Ogrenci {
        String ad;
        int numara;
        int vize;
        int fin;
        double ortalama;
        String harfNotu;

        Ogrenci(String ad, int numara) {
            this.ad = ad;
            this.numara = numara;
        }

        void notGir(int vize, int fin) {
            this.vize = vize;
            this.fin = fin;
            hesapla();
        }

        private void hesapla() {
            // Vize %40, Final %60
            this.ortalama = this.vize * 0.4 + this.fin * 0.6;
            if (ortalama >= 90) harfNotu = "AA";
            else if (ortalama >= 80) harfNotu = "BB";
            else if (ortalama >= 70) harfNotu = "CC";
            else if (ortalama >= 60) harfNotu = "DD";
            else harfNotu = "FF";
        }

        void bilgiGoster() {
            System.out.println("Öğrenci: " + ad + " (" + numara + ")");
            System.out.println("  Vize: " + vize + ", Final: " + fin);
            System.out.printf("  Ortalama: %.2f, Harf: %s%n", ortalama, harfNotu);
        }
    }
}

