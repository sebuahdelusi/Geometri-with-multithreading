package geometri.Benda3D;

import geometri.Benda2D.LayangLayang; // Menggunakan LayangLayang yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Prisma dengan alas Layang-Layang.
 */
public class PrismaLayangLayang extends LayangLayang {

    private double tinggiPrisma;

    /**
     * Konstruktor untuk membuat objek PrismaLayangLayang.
     * @param diagonal1Alas panjang diagonal pertama alas layang-layang.
     * @param diagonal2Alas panjang diagonal kedua alas layang-layang.
     * @param sisiPendekAlas panjang sisi pendek alas layang-layang.
     * @param sisiPanjangAlas panjang sisi panjang alas layang-layang.
     * @param tinggiPrisma tinggi prisma.
     */
    public PrismaLayangLayang(double diagonal1Alas, double diagonal2Alas,
                              double sisiPendekAlas, double sisiPanjangAlas,
                              double tinggiPrisma) {
        super(diagonal1Alas, diagonal2Alas, sisiPendekAlas, sisiPanjangAlas); // Memanggil konstruktor LayangLayang
        if (tinggiPrisma <= 0) {
            throw new IllegalArgumentException("Tinggi prisma harus bernilai positif.");
        }
        this.tinggiPrisma = tinggiPrisma;
    }

    /**
     * Menghitung volume prisma layang-layang.
     * Rumus: LuasAlasLayangLayang * tinggiPrisma
     * @return volume prisma layang-layang.
     */
    public double hitungVolume() {
        return super.hitungLuas() * this.tinggiPrisma;
    }

    /**
     * Menghitung luas permukaan prisma layang-layang.
     * Rumus: (2 * LuasAlasLayangLayang) + (KelilingAlasLayangLayang * tinggiPrisma)
     * @return luas permukaan prisma layang-layang.
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

    // Metode untuk mendapatkan dimensi alas diwarisi dari LayangLayang.
}