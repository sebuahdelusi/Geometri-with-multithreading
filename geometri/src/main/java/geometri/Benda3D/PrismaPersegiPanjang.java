package geometri.Benda3D;

import geometri.Benda2D.PersegiPanjang; // Menggunakan PersegiPanjang yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Prisma dengan alas Persegi Panjang (Balok).
 */
public class PrismaPersegiPanjang extends PersegiPanjang {

    private double tinggiPrisma;

    /**
     * Konstruktor untuk membuat objek PrismaPersegiPanjang (Balok).
     * @param panjangAlas panjang alas persegi panjang.
     * @param lebarAlas lebar alas persegi panjang.
     * @param tinggiPrisma tinggi prisma (atau balok).
     */
    public PrismaPersegiPanjang(double panjangAlas, double lebarAlas, double tinggiPrisma) {
        super(panjangAlas, lebarAlas); // Memanggil konstruktor PersegiPanjang
        if (tinggiPrisma <= 0) {
            throw new IllegalArgumentException("Tinggi prisma harus bernilai positif.");
        }
        this.tinggiPrisma = tinggiPrisma;
    }

    /**
     * Menghitung volume prisma persegi panjang (balok).
     * Rumus: LuasAlas * tinggiPrisma = (panjangAlas * lebarAlas) * tinggiPrisma
     * @return volume balok.
     */
    public double hitungVolume() {
        return super.hitungLuas() * this.tinggiPrisma;
    }

    /**
     * Menghitung luas permukaan prisma persegi panjang (balok).
     * Rumus: (2 * LuasAlas) + (KelilingAlas * tinggiPrisma)
     * Atau: 2 * (pl + pt + lt)
     * @return luas permukaan balok.
     */
    public double hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas(); // panjangAlas * lebarAlas
        double kelilingAlas = super.hitungKeliling(); // 2 * (panjangAlas + lebarAlas)
        double luasSelubung = kelilingAlas * this.tinggiPrisma;
        return (2 * luasAlas) + luasSelubung;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    // Metode getPanjang() dan getLebar() (untuk alas) diwarisi dari PersegiPanjang
}