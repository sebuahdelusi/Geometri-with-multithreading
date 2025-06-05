package geometri.Benda3D;

import geometri.Benda2D.Persegi; // Menggunakan Persegi yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Limas dengan alas Persegi.
 * Diasumsikan limas tegak (puncak berada di atas pusat alas persegi).
 */
public class LimasPersegi extends Persegi {

    private double tinggiLimas;

    /**
     * Konstruktor untuk membuat objek LimasPersegi.
     * @param sisiAlas panjang sisi alas persegi.
     * @param tinggiLimas tinggi limas (jarak tegak lurus dari puncak ke alas).
     */
    public LimasPersegi(double sisiAlas, double tinggiLimas) {
        super(sisiAlas); // Memanggil konstruktor Persegi
        if (tinggiLimas <= 0) {
            throw new IllegalArgumentException("Tinggi limas harus bernilai positif.");
        }
        this.tinggiLimas = tinggiLimas;
    }

    /**
     * Menghitung volume limas persegi.
     * Rumus: (1/3) * LuasAlas * tinggiLimas
     * @return volume limas persegi.
     */
    public double hitungVolume() {
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggiLimas;
    }

    /**
     * Menghitung tinggi segitiga sisi tegak (slant height).
     * Untuk limas persegi tegak, semua sisi tegak adalah segitiga sama kaki yang kongruen.
     * Jarak dari pusat alas ke tengah sisi alas adalah (sisiAlas / 2).
     * Tinggi segitiga sisi tegak (ts) = sqrt(tinggiLimas^2 + (sisiAlas/2)^2)
     * @return tinggi segitiga sisi tegak.
     */
    public double hitungTinggiSisiTegak() {
        double setengahSisiAlas = super.getSisi() / 2.0;
        return Math.sqrt(Math.pow(this.tinggiLimas, 2) + Math.pow(setengahSisiAlas, 2));
    }

    /**
     * Menghitung luas satu sisi tegak (segitiga).
     * @return luas satu sisi tegak.
     */
    public double hitungLuasSatuSisiTegak() {
        double tinggiSisiTegak = hitungTinggiSisiTegak();
        // Alas segitiga sisi tegak adalah sisi alas limas
        return 0.5 * super.getSisi() * tinggiSisiTegak;
    }

    /**
     * Menghitung luas selubung limas (jumlah luas semua sisi tegak).
     * Untuk limas persegi, ada 4 sisi tegak yang identik.
     * @return luas selubung limas.
     */
    public double hitungLuasSelubung() {
        return 4 * hitungLuasSatuSisiTegak();
    }

    /**
     * Menghitung luas permukaan limas persegi.
     * Rumus: LuasAlas + LuasSelubung
     * @return luas permukaan limas persegi.
     */
    public double hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas();
        double luasSelubung = hitungLuasSelubung();
        return luasAlas + luasSelubung;
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    // Metode getSisi() (untuk sisi alas) diwarisi dari Persegi
}