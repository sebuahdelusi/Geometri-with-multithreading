package geometri.Benda3D;

import geometri.Benda2D.Trapesium; // Menggunakan Trapesium yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Prisma dengan alas Trapesium.
 */
public class PrismaTrapesium extends Trapesium {

    private double tinggiPrisma;

    /**
     * Konstruktor untuk membuat objek PrismaTrapesium.
     * @param sisiAtasAlas panjang sisi atas alas trapesium.
     * @param sisiBawahAlas panjang sisi bawah alas trapesium.
     * @param tinggiAlasTrapesium tinggi dari alas trapesium.
     * @param sisiKiriAlas panjang sisi miring kiri alas trapesium.
     * @param sisiKananAlas panjang sisi miring kanan alas trapesium.
     * @param tinggiPrisma tinggi prisma.
     */
    public PrismaTrapesium(double sisiAtasAlas, double sisiBawahAlas, double tinggiAlasTrapesium,
                           double sisiKiriAlas, double sisiKananAlas, double tinggiPrisma) {
        super(sisiAtasAlas, sisiBawahAlas, tinggiAlasTrapesium, sisiKiriAlas, sisiKananAlas); // Memanggil konstruktor Trapesium
        if (tinggiPrisma <= 0) {
            throw new IllegalArgumentException("Tinggi prisma harus bernilai positif.");
        }
        this.tinggiPrisma = tinggiPrisma;
    }

    /**
     * Menghitung volume prisma trapesium.
     * Rumus: LuasAlasTrapesium * tinggiPrisma
     * @return volume prisma trapesium.
     */
    public double hitungVolume() {
        return super.hitungLuas() * this.tinggiPrisma;
    }

    /**
     * Menghitung luas permukaan prisma trapesium.
     * Rumus: (2 * LuasAlasTrapesium) + (KelilingAlasTrapesium * tinggiPrisma)
     * @return luas permukaan prisma trapesium.
     */
    public double hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas();
        double kelilingAlas = super.hitungKeliling();
        double luasSelubung = kelilingAlas * this.tinggiPrisma;
        return (2 * luasAlas) + luasSelubung;
    }

    public double getTinggiPrisma() {
        return tinggiPrisma;
    }

    // Metode untuk mendapatkan dimensi alas diwarisi dari Trapesium.
}