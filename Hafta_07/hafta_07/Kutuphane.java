

class Kaynak {
    protected String ad;
    protected final int MAKS_GUN = 15;

    public Kaynak(String ad) {
        this.ad = ad;
    }

    public final void bilgi() {
        System.out.println("Kaynak: "+ ad);
    }

    public int oduncSuresi() {
        return MAKS_GUN;
    }
}

class Kitap extends Kaynak {
    public Kitap(String ad) {
        super(ad);
    }

    @Override
    public int oduncSuresi() {
        return MAKS_GUN;
    }
}

class Ekitap extends Kaynak {
    public Ekitap(String ad) {
        super(ad);
    }

    @Override
    public int oduncSuresi() {
        return 7; // e-kitaplar icin daha kisa sure
    }
}

public class Kutuphane {
    public static void main(String[] args) {
        Kaynak k1 = new Kitap("Veri Yapilari");
        Kaynak k2 = new Ekitap("Yapay Zeka");

        System.out.println(k1.ad + ": " + k1.oduncSuresi() + " gun");
        System.out.println(k2.ad + ": " + k2.oduncSuresi() + " gun");
    }
}
