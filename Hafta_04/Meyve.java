public class Meyve {
    String ad;
    int miktar;

    public Meyve(String ad) {
        this.ad = ad;
        this.miktar = 0;
    }

    public void meyveEkle(int ekMiktar) {
        this.miktar += ekMiktar;
    }

     public void miktarCikar(int eksikMiktar) {
        this.miktar -= eksikMiktar;
     } 

    public void bilgileriGoster() {
        System.out.println("Meyve Adı: " + ad);
        System.out.println("Toplam Miktar: " + miktar);
    }

    public static void main(String[] args) {
        Meyve meyve1 = new Meyve("Elma");
        Meyve meyve2 = new Meyve("Muz");
        Meyve meyve3 = new Meyve("Portakal");

        meyve1.meyveEkle(10);
        meyve2.meyveEkle(15);
        meyve3.meyveEkle(20);

        meyve1.miktarCikar(1);
        meyve2.miktarCikar(5);
        meyve3.miktarCikar(2);

    }
}