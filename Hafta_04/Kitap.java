public class Kitap {
    String isim;
    String yazar;
    String sayfa;

    // this kullanmadan kurucu: farklı parametre isimleri
    public Kitap(String kIsim, String kYazar, String kSayfa) {
        isim = kIsim;
        yazar = kYazar;
        sayfa = kSayfa;
    }

    // Bilgileri yazdırmak için bir metod
    public void bilgileriGoster() {
        System.out.println("Kitap Adı: " + isim);
        System.out.println("Yazar: " + yazar);
        System.out.println("Sayfa Sayısı: " + sayfa);
    }

    // Main metodu
    public static void main(String[] args) {
        // Yeni bir kitap nesnesi oluşturalım
        Kitap kitap1 = new Kitap("Suç ve Ceza", "Dostoyevski", "705");

        // Kitap bilgilerini gösterelim
        kitap1.bilgileriGoster();
    }
}
