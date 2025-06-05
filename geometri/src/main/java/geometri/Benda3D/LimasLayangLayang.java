package geometri.Benda3D;

import geometri.Benda2D.LayangLayang; // Menggunakan LayangLayang yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Limas dengan alas Layang-Layang.
 * Perhitungan luas selubung bergantung pada posisi puncak.
 */
public class LimasLayangLayang extends LayangLayang {

    private double tinggiLimas;

    /**
     * Konstruktor untuk LimasLayangLayang.
     * @param d1Alas diagonal 1 alas layang-layang.
     * @param d2Alas diagonal 2 alas layang-layang.
     * @param sisiPendekAlas sisi pendek alas layang-layang.
     * @param sisiPanjangAlas sisi panjang alas layang-layang.
     * @param tinggiLimas tinggi limas.
     */
    public LimasLayangLayang(double d1Alas, double d2Alas, double sisiPendekAlas,
                             double sisiPanjangAlas, double tinggiLimas) {
        super(d1Alas, d2Alas, sisiPendekAlas, sisiPanjangAlas);
        if (tinggiLimas <= 0) {
            throw new IllegalArgumentException("Tinggi limas harus bernilai positif.");
        }
        this.tinggiLimas = tinggiLimas;
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggiLimas;
    }

    /**
     * Menghitung luas selubung limas layang-layang.
     * Terdiri dari 2 pasang segitiga sisi tegak yang sama:
     * - 2 segitiga dengan alas = sisiPendekAlas
     * - 2 segitiga dengan alas = sisiPanjangAlas
     * Memerlukan tinggi masing-masing pasang sisi tegak tersebut.
     *
     * @param tsSisiPendek Tinggi sisi tegak yang bersandar pada sisi pendek alas.
     * @param tsSisiPanjang Tinggi sisi tegak yang bersandar pada sisi panjang alas.
     * @return luas selubung.
     */
    public double hitungLuasSelubung(double tsSisiPendek, double tsSisiPanjang) {
        if (tsSisiPendek <=0 || tsSisiPanjang <=0) {
            throw new IllegalArgumentException("Tinggi sisi tegak harus positif.");
        }
        double luasTegakPendek = 2 * (0.5 * super.getSisiPendek() * tsSisiPendek);
        double luasTegakPanjang = 2 * (0.5 * super.getSisiPanjang() * tsSisiPanjang);
        return luasTegakPendek + luasTegakPanjang;
    }

    /**
     * Menghitung luas permukaan limas layang-layang.
     * @param tsSisiPendek Tinggi sisi tegak yang bersandar pada sisi pendek alas.
     * @param tsSisiPanjang Tinggi sisi tegak yang bersandar pada sisi panjang alas.
     * @return luas permukaan.
     */
    public double hitungLuasPermukaan(double tsSisiPendek, double tsSisiPanjang) {
        return super.hitungLuas() + hitungLuasSelubung(tsSisiPendek, tsSisiPanjang);
    }

    /**
     * Versi hitungLuasPermukaan tanpa parameter tinggi sisi tegak.
     * Akan memberikan hasil tidak lengkap (hanya luas alas) atau memerlukan override.
     */
    public double hitungLuasPermukaan() {
        System.err.println("PERINGATAN: hitungLuasPermukaan() untuk LimasLayangLayang umum dipanggil tanpa parameter tinggi sisi tegak. " +
                "Hasil mungkin tidak akurat atau metode ini harus di-override dengan logika spesifik.");
        return super.hitungLuas(); // Tidak menghitung selubung.
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }
}