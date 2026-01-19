package hafta_07;

class Musteri {

    protected String ad;

    public Musteri(String ad) {
        this.ad = ad;
    }

    public double indirimHesapla(double tutar) {
        return tutar;
    }

    public double indirimHesapla(double tutar, int kupon) {
        return tutar - kupon;
    }
}

class PremiumMusteri extends Musteri {

    public PremiumMusteri(String ad) {
        super(ad);
    }

    @Override
    public double indirimHesapla(double tutar) {
        return tutar * 0.8;
    }
}

public class Alisveris {
    public static void main(String[] args) {

        Musteri m1 = new Musteri("Ali");
        Musteri m2 = new PremiumMusteri("Ayse");

        System.out.println("Musteri: " + m1.ad + "\nAlisveris tutari: " + m1.indirimHesapla(1000));
        System.out.println("Musteri: " + m2.ad + "\nAlisveris tutari: " + m2.indirimHesapla(1000));
        System.out.println("Musteri: " + m2.ad + "\nAlisveris tutari: " + m2.indirimHesapla(1000, 100));
    }
}
