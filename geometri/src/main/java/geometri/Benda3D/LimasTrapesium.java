package geometri.Benda3D;

import geometri.Benda2D.Trapesium; // Menggunakan Trapesium yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Limas dengan alas Trapesium.
 * Luas selubung sangat kompleks untuk kasus umum.
 */
public class LimasTrapesium extends Trapesium {

    private double tinggiLimas;

    /**
     * Konstruktor untuk LimasTrapesium.
     * @param sisiAtasAlas sisi atas alas trapesium.
     * @param sisiBawahAlas sisi bawah alas trapesium.
     * @param tinggiAlasTrapesium tinggi alas trapesium.
     * @param sisiKiriAlas sisi kiri alas trapesium.
     * @param sisiKananAlas sisi kanan alas trapesium.
     * @param tinggiLimas tinggi limas.
     */
    public LimasTrapesium(double sisiAtasAlas, double sisiBawahAlas, double tinggiAlasTrapesium,
                          double sisiKiriAlas, double sisiKananAlas, double tinggiLimas) {
        super(sisiAtasAlas, sisiBawahAlas, tinggiAlasTrapesium, sisiKiriAlas, sisiKananAlas);
        if (tinggiLimas <= 0) {
            throw new IllegalArgumentException("Tinggi limas harus bernilai positif.");
        }
        this.tinggiLimas = tinggiLimas;
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggiLimas;
    }

    /**
     * Menghitung luas selubung limas trapesium.
     * Terdiri dari 4 segitiga sisi tegak, masing-masing bisa berbeda.
     * Memerlukan tinggi masing-masing sisi tegak tersebut.
     *
     * @param tsSisiAtas Tinggi sisi tegak yang bersandar pada sisi atas alas.
     * @param tsSisiBawah Tinggi sisi tegak yang bersandar pada sisi bawah alas.
     * @param tsSisiKiri Tinggi sisi tegak yang bersandar pada sisi kiri alas.
     * @param tsSisiKanan Tinggi sisi tegak yang bersandar pada sisi kanan alas.
     * @return luas selubung.
     */
    public double hitungLuasSelubung(double tsSisiAtas, double tsSisiBawah, double tsSisiKiri, double tsSisiKanan) {
        if (tsSisiAtas <=0 || tsSisiBawah <=0 || tsSisiKiri <=0 || tsSisiKanan <=0) {
            throw new IllegalArgumentException("Tinggi sisi tegak harus positif.");
        }
        double luasTegakAtas = 0.5 * super.getSisiAtas() * tsSisiAtas;
        double luasTegakBawah = 0.5 * super.getSisiBawah() * tsSisiBawah;
        double luasTegakKiri = 0.5 * super.getSisiKiri() * tsSisiKiri;
        double luasTegakKanan = 0.5 * super.getSisiKanan() * tsSisiKanan;
        return luasTegakAtas + luasTegakBawah + luasTegakKiri + luasTegakKanan;
    }

    /**
     * Menghitung luas permukaan limas trapesium.
     * @param tsSisiAtas Tinggi sisi tegak yang bersandar pada sisi atas alas.
     * @param tsSisiBawah Tinggi sisi tegak yang bersandar pada sisi bawah alas.
     * @param tsSisiKiri Tinggi sisi tegak yang bersandar pada sisi kiri alas.
     * @param tsSisiKanan Tinggi sisi tegak yang bersandar pada sisi kanan alas.
     * @return luas permukaan.
     */
    public double hitungLuasPermukaan(double tsSisiAtas, double tsSisiBawah, double tsSisiKiri, double tsSisiKanan) {
        return super.hitungLuas() + hitungLuasSelubung(tsSisiAtas, tsSisiBawah, tsSisiKiri, tsSisiKanan);
    }

    /**
     * Versi hitungLuasPermukaan tanpa parameter tinggi sisi tegak.
     * Akan memberikan hasil tidak lengkap (hanya luas alas) atau memerlukan override.
     */
    public double hitungLuasPermukaan() {
        System.err.println("PERINGATAN: hitungLuasPermukaan() untuk LimasTrapesium umum dipanggil tanpa parameter tinggi sisi tegak. " +
                "Hasil mungkin tidak akurat atau metode ini harus di-override dengan logika spesifik.");
        return super.hitungLuas(); // Tidak menghitung selubung.
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }
}