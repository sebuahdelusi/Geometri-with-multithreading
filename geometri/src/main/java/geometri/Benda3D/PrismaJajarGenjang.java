package geometri.Benda3D;

import geometri.Benda2D.JajarGenjang; // Menggunakan JajarGenjang yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Prisma dengan alas Jajar Genjang.
 */
public class PrismaJajarGenjang extends JajarGenjang {

    private double tinggiPrisma;

    /**
     * Konstruktor untuk membuat objek PrismaJajarGenjang.
     * @param alasJajarGenjang panjang alas dari alas jajar genjang.
     * @param tinggiJajarGenjang tinggi dari alas jajar genjang.
     * @param sisiMiringJajarGenjang panjang sisi miring dari alas jajar genjang.
     * @param tinggiPrisma tinggi prisma.
     */
    public PrismaJajarGenjang(double alasJajarGenjang, double tinggiJajarGenjang,
                              double sisiMiringJajarGenjang, double tinggiPrisma) {
        super(alasJajarGenjang, tinggiJajarGenjang, sisiMiringJajarGenjang); // Memanggil konstruktor JajarGenjang
        if (tinggiPrisma <= 0) {
            throw new IllegalArgumentException("Tinggi prisma harus bernilai positif.");
        }
        this.tinggiPrisma = tinggiPrisma;
    }

    /**
     * Menghitung volume prisma jajar genjang.
     * Rumus: LuasAlasJajarGenjang * tinggiPrisma
     * @return volume prisma jajar genjang.
     */
    public double hitungVolume() {
        return super.hitungLuas() * this.tinggiPrisma;
    }

    /**
     * Menghitung luas permukaan prisma jajar genjang.
     * Rumus: (2 * LuasAlasJajarGenjang) + (KelilingAlasJajarGenjang * tinggiPrisma)
     * @return luas permukaan prisma jajar genjang.
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

    // Metode untuk mendapatkan dimensi alas diwarisi dari JajarGenjang.
}