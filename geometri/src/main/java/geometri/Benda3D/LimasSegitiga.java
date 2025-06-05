package geometri.Benda3D;

import geometri.Benda2D.Segitiga; // Menggunakan Segitiga yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Limas dengan alas Segitiga.
 * Perhitungan luas selubung bisa kompleks dan mungkin memerlukan informasi tambahan
 * mengenai tinggi masing-masing sisi tegak segitiga atau jenis limasnya.
 */
public class LimasSegitiga extends Segitiga {

    private double tinggiLimas;

    /**
     * Konstruktor untuk membuat objek LimasSegitiga.
     * @param alasSegitigaAlas panjang alas dari alas segitiga.
     * @param tinggiSegitigaAlas tinggi dari alas segitiga.
     * @param sisiA_alas panjang sisi A dari alas segitiga.
     * @param sisiB_alas panjang sisi B dari alas segitiga.
     * @param sisiC_alas panjang sisi C dari alas segitiga.
     * @param tinggiLimas tinggi limas (jarak dari puncak ke alas).
     */
    public LimasSegitiga(double alasSegitigaAlas, double tinggiSegitigaAlas,
                         double sisiA_alas, double sisiB_alas, double sisiC_alas,
                         double tinggiLimas) {
        super(alasSegitigaAlas, tinggiSegitigaAlas, sisiA_alas, sisiB_alas, sisiC_alas); // Konstruktor Segitiga
        if (tinggiLimas <= 0) {
            throw new IllegalArgumentException("Tinggi limas harus bernilai positif.");
        }
        this.tinggiLimas = tinggiLimas;
    }

    /**
     * Menghitung volume limas segitiga.
     * Rumus: (1/3) * LuasAlasSegitiga * tinggiLimas
     * @return volume limas segitiga.
     */
    public double hitungVolume() {
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggiLimas;
    }

    /**
     * Menghitung luas selubung limas segitiga.
     * Ini adalah jumlah luas dari tiga segitiga sisi tegak.
     * Perhitungan ini memerlukan tinggi masing-masing segitiga sisi tegak (slant height),
     * yang bisa berbeda-beda kecuali limasnya sangat reguler (misal, alas segitiga sama sisi
     * dan puncak tepat di atas pusat alas).
     *
     * Untuk implementasi umum yang sederhana, metode ini mungkin memerlukan
     * parameter tambahan atau mengembalikan nilai yang menandakan kompleksitas.
     *
     * @return Luas selubung. Untuk implementasi saat ini, ini adalah placeholder.
     * Pengguna mungkin perlu mengimplementasikan logika yang lebih detail
     * atau menyediakan data tinggi sisi tegak secara eksternal.
     * Sebagai contoh sederhana, jika kita tahu tinggi setiap sisi tegak:
     * Luas = 0.5 * sisiA_alas * tsA + 0.5 * sisiB_alas * tsB + 0.5 * sisiC_alas * tsC
     * Dimana tsA, tsB, tsC adalah tinggi sisi tegak yang bersandar pada sisiA, sisiB, sisiC.
     */
    public double hitungLuasSelubung(double tinggiSisiTegakA, double tinggiSisiTegakB, double tinggiSisiTegakC) {
        // Metode ini membutuhkan tinggi spesifik untuk setiap sisi tegak
        if (tinggiSisiTegakA <= 0 || tinggiSisiTegakB <= 0 || tinggiSisiTegakC <= 0) {
            throw new IllegalArgumentException("Tinggi sisi tegak harus positif.");
        }
        double luasTegakA = 0.5 * super.getSisiA() * tinggiSisiTegakA;
        double luasTegakB = 0.5 * super.getSisiB() * tinggiSisiTegakB;
        double luasTegakC = 0.5 * super.getSisiC() * tinggiSisiTegakC;
        return luasTegakA + luasTegakB + luasTegakC;
    }

    /**
     * Menghitung luas permukaan limas segitiga.
     * Rumus: LuasAlas + LuasSelubung.
     * PENTING: Metode ini memanggil hitungLuasSelubung() yang mungkin memerlukan
     * parameter spesifik (tinggi sisi tegak) yang tidak disediakan secara default.
     * Pertimbangkan untuk menyediakan parameter tersebut atau menggunakan implementasi
     * luas selubung yang lebih spesifik jika jenis limasnya diketahui (misal, limas beraturan).
     *
     * @param tinggiSisiTegakA Tinggi sisi tegak yang bersandar pada sisi A alas.
     * @param tinggiSisiTegakB Tinggi sisi tegak yang bersandar pada sisi B alas.
     * @param tinggiSisiTegakC Tinggi sisi tegak yang bersandar pada sisi C alas.
     * @return luas permukaan limas segitiga.
     */
    public double hitungLuasPermukaan(double tinggiSisiTegakA, double tinggiSisiTegakB, double tinggiSisiTegakC) {
        double luasAlas = super.hitungLuas();
        double luasSelubung = hitungLuasSelubung(tinggiSisiTegakA, tinggiSisiTegakB, tinggiSisiTegakC);
        return luasAlas + luasSelubung;
    }

    /**
     * Versi hitungLuasPermukaan yang tidak memerlukan parameter tinggi sisi tegak eksternal,
     * namun ini mengindikasikan bahwa perhitungan luas selubung mungkin tidak akurat
     * atau memerlukan asumsi tertentu tentang bentuk limas (misalnya, limas beraturan).
     * Metode ini bisa di-override di subclass yang lebih spesifik.
     * Untuk sekarang, ini akan melempar UnsupportedOperationException.
     */
    public double hitungLuasPermukaan() {
        // Atau, jika Anda ingin menyediakan implementasi default yang sangat kasar atau asumsi:
        // throw new UnsupportedOperationException("Luas selubung limas segitiga umum memerlukan tinggi sisi tegak spesifik.");
        // Sebagai contoh, jika kita asumsikan sebuah limas tetrahedron beraturan (semua sisi sama),
        // perhitungannya akan berbeda. Namun, kelas ini adalah LimasSegitiga umum.
        // Untuk tujuan demonstrasi, kita bisa membuat asumsi sederhana, tapi ini tidak ideal.
        // Misal, jika kita asumsikan semua tinggi sisi tegak sama (tidak selalu benar):
        // double rataRataSisiAlas = (super.getSisiA() + super.getSisiB() + super.getSisiC()) / 3.0;
        // double contohTinggiSisiTegak = Math.sqrt(Math.pow(this.tinggiLimas, 2) + Math.pow(rataRataSisiAlas / 2.0, 2)); // Ini sangat kasar!
        // double luasSelubungContoh = 0.5 * (super.getSisiA() + super.getSisiB() + super.getSisiC()) * contohTinggiSisiTegak; // Juga kasar!
        // return super.hitungLuas() + luasSelubungContoh;
        System.err.println("PERINGATAN: hitungLuasPermukaan() untuk LimasSegitiga umum dipanggil tanpa parameter tinggi sisi tegak. " +
                "Hasil mungkin tidak akurat atau metode ini harus di-override dengan logika spesifik.");
        // Mengembalikan luas alas saja sebagai fallback minimal, atau NaN.
        return super.hitungLuas(); // Ini tidak menghitung selubung.
    }


    public double getTinggiLimas() {
        return tinggiLimas;
    }
}