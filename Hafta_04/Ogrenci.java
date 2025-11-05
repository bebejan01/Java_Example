public class Ogrenci {
    String ad;
    int yas;

    void bilgiYazdir() {
        System.out.println("Ad: " + ad + ", Yaş: " + yas);
    }

    public static void main(String[] args) {
        Ogrenci ogr1 = new Ogrenci();
        ogr1.ad = "Ali";
        ogr1.yas = 18;

        Ogrenci ogr2 = new Ogrenci();
        ogr2.ad = "Ayşe";
        ogr2.yas = 20;

        ogr1.bilgiYazdir();
        ogr2.bilgiYazdir();
    }
}
