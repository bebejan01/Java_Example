public class kurucu {
    public String isim;
    protected int sinif;
    private int tc;
    int akts;

    public kurucu(String i, int s, int t, int ects) {
        isim = i;
        sinif = s;
        tc = t;
        akts = ects;
    }
    public int get_tc() {
        return tc;
    }
    private void yaz() {
        System.out.println("Ogrencinin adi = " + isim + " sinif : " + sinif + " tc = " + tc + " akts = " + akts);
    }
    protected int get_sinif() {
        return sinif;
    }
    String get_isim() {
        return isim;
    }
}
