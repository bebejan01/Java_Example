

public class AracKiralama {
    public static void main(String[] args) {
        // Araç nesneleri oluşturuluyor (constructor kullanımı)
        Arac arac1 = new Arac("BMW", "X5", 2023, 1200);
        Arac arac2 = new Arac("Tesla", "Model 3", 2024, 1500);
        Arac arac3 = new Arac("Volkswagen", "Passat", 2022, 800);

        // Durum göster
        arac1.durum();

        // Kiralama işlemleri
        arac1.kirala();
        arac1.kirala(); // Zaten kiralanmış aracı tekrar kiralama denemesi

        // Kiralanmış aracın durumu
        arac1.durum();
    }

    // Tek dosyada derlenebilmesi için basit Arac sınıfı
    static class Arac {
        String marka;
        String model;
        int yil;
        int gunlukUcret;
        boolean kirada;

        Arac(String marka, String model, int yil, int gunlukUcret) {
            this.marka = marka;
            this.model = model;
            this.yil = yil;
            this.gunlukUcret = gunlukUcret;
            this.kirada = false;
        }

        void kirala() {
            if (kirada) {
                System.out.println(marka + " " + model + " zaten kirada.");
            } else {
                kirada = true;
                System.out.println(marka + " " + model + " başarıyla kiralandı.");
            }
        }

        void durum() {
            String durumStr = kirada ? "Kirada" : "Müsait";
            System.out.println(marka + " " + model + " (" + yil + ") - " + durumStr + ", Günlük: " + gunlukUcret + "₺");
        }
    }
}

