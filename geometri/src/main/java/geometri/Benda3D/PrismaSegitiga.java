package geometri.Benda3D;

import geometri.Benda2D.Segitiga; // Menggunakan Segitiga yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Prisma dengan alas Segitiga.
 */
public class PrismaSegitiga extends Segitiga {

    private double tinggiPrisma;

    /**
     * Konstruktor untuk membuat objek PrismaSegitiga.
     * @param alasSegitiga panjang alas dari alas segitiga.
     * @param tinggiSegitiga tinggi dari alas segitiga (relatif terhadap alasSegitiga).
     * @param sisiA_alas panjang sisi A dari alas segitiga (bisa sama dengan alasSegitiga).
     * @param sisiB_alas panjang sisi B dari alas segitiga.
     * @param sisiC_alas panjang sisi C dari alas segitiga.
     * @param tinggiPrisma tinggi prisma.
     */
    public PrismaSegitiga(double alasSegitiga, double tinggiSegitiga,
                          double sisiA_alas, double sisiB_alas, double sisiC_alas,
                          double tinggiPrisma) {
        // Memanggil konstruktor Segitiga untuk dimensi alas
        super(alasSegitiga, tinggiSegitiga, sisiA_alas, sisiB_alas, sisiC_alas);

        if (tinggiPrisma <= 0) {
            throw new IllegalArgumentException("Tinggi prisma harus bernilai positif.");
        }
        this.tinggiPrisma = tinggiPrisma;
    }

    /**
     * Menghitung volume prisma segitiga.
     * Rumus: LuasAlasSegitiga * tinggiPrisma
     * @return volume prisma segitiga.
     */
    public double hitungVolume() {
        // super.hitungLuas() akan mengembalikan luas alas segitiga
        return super.hitungLuas() * this.tinggiPrisma;
    }

    /**
     * Menghitung luas permukaan prisma segitiga.
     * Rumus: (2 * LuasAlasSegitiga) + (KelilingAlasSegitiga * tinggiPrisma)
     * @return luas permukaan prisma segitiga.
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

    // Metode untuk mendapatkan dimensi alas (getAlas(), getTinggiSegitiga(), getSisiA(), dll.)
    // diwarisi dari Segitiga.
}