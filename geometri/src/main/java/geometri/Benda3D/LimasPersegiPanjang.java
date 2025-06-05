package geometri.Benda3D;

import geometri.Benda2D.PersegiPanjang; // Menggunakan PersegiPanjang yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Limas dengan alas Persegi Panjang.
 * Diasumsikan limas tegak (puncak berada di atas pusat alas persegi panjang).
 */
public class LimasPersegiPanjang extends PersegiPanjang {

    private double tinggiLimas;

    /**
     * Konstruktor untuk membuat objek LimasPersegiPanjang.
     * @param panjangAlas panjang alas persegi panjang.
     * @param lebarAlas lebar alas persegi panjang.
     * @param tinggiLimas tinggi limas.
     */
    public LimasPersegiPanjang(double panjangAlas, double lebarAlas, double tinggiLimas) {
        super(panjangAlas, lebarAlas); // Memanggil konstruktor PersegiPanjang
        if (tinggiLimas <= 0) {
            throw new IllegalArgumentException("Tinggi limas harus bernilai positif.");
        }
        this.tinggiLimas = tinggiLimas;
    }

    /**
     * Menghitung volume limas persegi panjang.
     * Rumus: (1/3) * LuasAlas * tinggiLimas
     * @return volume limas persegi panjang.
     */
    public double hitungVolume() {
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggiLimas;
    }

    /**
     * Menghitung luas selubung limas persegi panjang.
     * Terdiri dari 2 pasang segitiga sisi tegak yang berbeda.
     * - Sepasang segitiga dengan alas = panjangAlas, tingginya (ts1) = sqrt(tinggiLimas^2 + (lebarAlas/2)^2)
     * - Sepasang segitiga dengan alas = lebarAlas, tingginya (ts2) = sqrt(tinggiLimas^2 + (panjangAlas/2)^2)
     * @return luas selubung limas.
     */
    public double hitungLuasSelubung() {
        double panjang = super.getPanjang(); // Panjang alas
        double lebar = super.getLebar();   // Lebar alas

        // Tinggi segitiga sisi tegak pada sisi 'panjang'
        double ts1 = Math.sqrt(Math.pow(this.tinggiLimas, 2) + Math.pow(lebar / 2.0, 2));
        // Luas 2 segitiga pada sisi 'panjang'
        double luasSisiTegak1 = 2 * (0.5 * panjang * ts1);

        // Tinggi segitiga sisi tegak pada sisi 'lebar'
        double ts2 = Math.sqrt(Math.pow(this.tinggiLimas, 2) + Math.pow(panjang / 2.0, 2));
        // Luas 2 segitiga pada sisi 'lebar'
        double luasSisiTegak2 = 2 * (0.5 * lebar * ts2);

        return luasSisiTegak1 + luasSisiTegak2;
    }

    /**
     * Menghitung luas permukaan limas persegi panjang.
     * Rumus: LuasAlas + LuasSelubung
     * @return luas permukaan limas persegi panjang.
     */
    public double hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas();
        double luasSelubung = hitungLuasSelubung();
        return luasAlas + luasSelubung;
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }

    // Metode getPanjang() dan getLebar() (untuk alas) diwarisi dari PersegiPanjang
}