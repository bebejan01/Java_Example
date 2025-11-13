public class ogrenci {
    public String isim;
    protected int sinif;
    private int tc;
    int akts;

    public ogrenci(String i, int s, int t, int ects) {
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

    public static void main(String[] args) {
        ogrenci ogr = new ogrenci("Ali", 2, 123456789, 60);
        ogr.yaz(); // example output
        System.out.println("Sinif: " + ogr.get_sinif());
        System.out.println("Isim: " + ogr.get_isim());
        System.out.println("TC: " + ogr.get_tc());
    }
}
