package geometri.Benda3D;

import geometri.Benda2D.Persegi; // Menggunakan Persegi yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Prisma dengan alas Persegi.
 * Jika tinggi prisma sama dengan sisi alas, ini adalah Kubus.
 */
public class PrismaPersegi extends Persegi {

    private double tinggiPrisma;

    /**
     * Konstruktor untuk membuat objek PrismaPersegi.
     * @param sisiAlas panjang sisi alas persegi.
     * @param tinggiPrisma tinggi prisma.
     */
    public PrismaPersegi(double sisiAlas, double tinggiPrisma) {
        super(sisiAlas); // Memanggil konstruktor Persegi
        if (tinggiPrisma <= 0) {
            throw new IllegalArgumentException("Tinggi prisma harus bernilai positif.");
        }
        this.tinggiPrisma = tinggiPrisma;
    }

    /**
     * Menghitung volume prisma persegi.
     * Rumus: LuasAlas * tinggiPrisma
     * @return volume prisma persegi.
     */
    public double hitungVolume() {
        // super.hitungLuas() akan mengembalikan sisiAlas * sisiAlas
        return super.hitungLuas() * this.tinggiPrisma;
    }

    /**
     * Menghitung luas permukaan prisma persegi.
     * Rumus: (2 * LuasAlas) + (KelilingAlas * tinggiPrisma)
     * @return luas permukaan prisma persegi.
     */
    public double hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas(); // sisiAlas^2
        double kelilingAlas = super.hitungKeliling(); // 4 * sisiAlas
        double luasSelubung = kelilingAlas * this.tinggiPrisma;
        return (2 * luasAlas) + luasSelubung;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    // Metode getSisi() (untuk sisi alas) diwarisi dari Persegi
}