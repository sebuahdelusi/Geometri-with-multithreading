package geometri.Benda3D;

import geometri.Benda2D.Lingkaran; // Menggunakan Lingkaran yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Tabung (Silinder).
 * Tabung memiliki dua alas lingkaran yang identik dan sebuah selimut persegi panjang.
 */
public class Tabung extends Lingkaran {

    private double tinggi;

    /**
     * Konstruktor untuk membuat objek Tabung.
     * @param jariJari panjang jari-jari alas lingkaran tabung.
     * @param tinggi tinggi tabung.
     */
    public Tabung(double jariJari, double tinggi) {
        super(jariJari); // Memanggil konstruktor Lingkaran untuk menetapkan jariJari alas
        if (tinggi <= 0) {
            throw new IllegalArgumentException("Tinggi tabung harus bernilai positif.");
        }
        this.tinggi = tinggi;
    }

    /**
     * Menghitung volume tabung.
     * Rumus: LuasAlas * tinggi = PI * r^2 * tinggi
     * @return volume tabung.
     */
    public double hitungVolume() {
        // super.hitungLuas() akan mengembalikan PI * r^2 dari Lingkaran (alas)
        return super.hitungLuas() * this.tinggi;
    }

    /**
     * Menghitung luas permukaan tabung.
     * Rumus: 2 * LuasAlas + LuasSelimut
     * LuasSelimut = KelilingAlas * tinggi = (2 * PI * r) * tinggi
     * @return luas permukaan tabung.
     */
    public double hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas(); // PI * r^2
        double kelilingAlas = super.hitungKeliling(); // 2 * PI * r
        double luasSelimut = kelilingAlas * this.tinggi;
        return (2 * luasAlas) + luasSelimut;
    }

    public double getTinggi() {
        return tinggi;
    }

    // Metode getJariJari() diwarisi dari Lingkaran
}