package geometri.Benda3D;

import geometri.Benda2D.BelahKetupat; // Menggunakan BelahKetupat yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Limas dengan alas Belah Ketupat.
 * Diasumsikan limas tegak.
 */
public class LimasBelahKetupat extends BelahKetupat {

    private double tinggiLimas;

    /**
     * Konstruktor untuk LimasBelahKetupat.
     * @param diagonal1Alas panjang diagonal 1 alas belah ketupat.
     * @param diagonal2Alas panjang diagonal 2 alas belah ketupat.
     * @param sisiAlas panjang sisi alas belah ketupat.
     * @param tinggiLimas tinggi limas.
     */
    public LimasBelahKetupat(double diagonal1Alas, double diagonal2Alas, double sisiAlas, double tinggiLimas) {
        super(diagonal1Alas, diagonal2Alas, sisiAlas);
        if (tinggiLimas <= 0) {
            throw new IllegalArgumentException("Tinggi limas harus bernilai positif.");
        }
        this.tinggiLimas = tinggiLimas;
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggiLimas;
    }

    /**
     * Menghitung tinggi sisi tegak (slant height) untuk limas belah ketupat tegak.
     * Alas belah ketupat memiliki 4 sisi sama panjang. Jika limas tegak (puncak di atas
     * perpotongan diagonal), maka keempat sisi tegak adalah segitiga sama kaki yang kongruen.
     * Jarak dari pusat ke sisi (apotema alas) perlu dihitung.
     * Apotema alas (r_alas) = LuasAlas / (0.5 * KelilingAlas) = (d1*d2/2) / (2*sisi) = d1*d2 / (4*sisi)
     * Tinggi sisi tegak (ts) = sqrt(tinggiLimas^2 + r_alas^2)
     * @return tinggi segitiga sisi tegak.
     */
    public double hitungTinggiSisiTegak() {
        double d1 = super.getDiagonal1();
        double d2 = super.getDiagonal2();
        double sisi = super.getSisi();
        double apotemaAlas = (d1 * d2) / (4 * sisi);
        return Math.sqrt(Math.pow(this.tinggiLimas, 2) + Math.pow(apotemaAlas, 2));
    }

    /**
     * Menghitung luas selubung limas belah ketupat tegak.
     * Terdiri dari 4 segitiga sama kaki yang kongruen.
     * Luas satu segitiga = 0.5 * sisiAlas * tinggiSisiTegak.
     * @return luas selubung limas.
     */
    public double hitungLuasSelubung() {
        double tinggiSisiTegak = hitungTinggiSisiTegak();
        double luasSatuSisiTegak = 0.5 * super.getSisi() * tinggiSisiTegak;
        return 4 * luasSatuSisiTegak;
    }

    public double hitungLuasPermukaan() {
        return super.hitungLuas() + hitungLuasSelubung();
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }
}