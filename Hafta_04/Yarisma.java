public class Yarisma {
    String ad;
    int puan;

    // Constructor
    public Yarisma(String ad) {
        this.ad = ad;
        this.puan = 0;
    }

    
    public void puanEkle(int ekPuan) {
        this.puan += ekPuan;
    }

    

    
    public void bilgileriGoster() {
        System.out.println("Yarışmacı Adı: " + ad);
        System.out.println("Toplam Puan: " + puan);
    }

    public static void main(String[] args) {
        
        Yarisma yarismaci1 = new Yarisma("Ali");
        Yarisma yarismaci2 = new Yarisma("Ayşe");
        Yarisma yarismaci3 = new Yarisma("Mehmet");

        
        yarismaci1.puanEkle(85);
        yarismaci2.puanEkle(90);
        yarismaci3.puanEkle(75);

        yarismaci1.puanEkle(0);
        yarismaci2.puanEkle(5);
        yarismaci3.puanEkle(10);

        
        System.out.println("\nYarışmacı Bilgileri:");
        yarismaci1.bilgileriGoster();
        yarismaci2.bilgileriGoster();
        yarismaci3.bilgileriGoster();

        
        System.out.println("\nKazanan Yarışmacı:");
        if (yarismaci1.puan > yarismaci2.puan && yarismaci1.puan > yarismaci3.puan) {
            System.out.println(yarismaci1.ad + " kazandı! Toplam puanı: " + yarismaci1.puan);
        } else if (yarismaci2.puan > yarismaci1.puan && yarismaci2.puan > yarismaci3.puan) {
            System.out.println(yarismaci2.ad + " kazandı! Toplam puanı: " + yarismaci2.puan);
        } else if (yarismaci3.puan > yarismaci1.puan && yarismaci3.puan > yarismaci2.puan) {
            System.out.println(yarismaci3.ad + " kazandı! Toplam puanı: " + yarismaci3.puan);
        } else {
            System.out.println("Beraberlik var!");
        }
    }
}