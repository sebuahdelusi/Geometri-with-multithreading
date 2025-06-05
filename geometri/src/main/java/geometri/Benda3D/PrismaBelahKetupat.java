package geometri.Benda3D;

import geometri.Benda2D.BelahKetupat; // Menggunakan BelahKetupat yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Prisma dengan alas Belah Ketupat.
 */
public class PrismaBelahKetupat extends BelahKetupat {

    private double tinggiPrisma;

    /**
     * Konstruktor untuk membuat objek PrismaBelahKetupat.
     * Nama konstruktor sebelumnya 'PrismaBelahKetupatat' telah diperbaiki.
     * @param diagonal1Alas panjang diagonal pertama alas belah ketupat.
     * @param diagonal2Alas panjang diagonal kedua alas belah ketupat.
     * @param sisiAlas panjang sisi alas belah ketupat.
     * @param tinggiPrisma tinggi prisma.
     */
    public PrismaBelahKetupat(double diagonal1Alas, double diagonal2Alas, double sisiAlas, double tinggiPrisma) {
        super(diagonal1Alas, diagonal2Alas, sisiAlas); // Memanggil konstruktor BelahKetupat
        if (tinggiPrisma <= 0) {
            throw new IllegalArgumentException("Tinggi prisma harus bernilai positif.");
        }
        this.tinggiPrisma = tinggiPrisma;
    }

    /**
     * Menghitung volume prisma belah ketupat.
     * Rumus: LuasAlasBelahKetupat * tinggiPrisma
     * @return volume prisma belah ketupat.
     */
    public double hitungVolume() {
        return super.hitungLuas() * this.tinggiPrisma;
    }

    /**
     * Menghitung luas permukaan prisma belah ketupat.
     * Rumus: (2 * LuasAlasBelahKetupat) + (KelilingAlasBelahKetupat * tinggiPrisma)
     * @return luas permukaan prisma belah ketupat.
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

    // Metode untuk mendapatkan dimensi alas (getDiagonal1(), getDiagonal2(), getSisi())
    // diwarisi dari BelahKetupat.
}