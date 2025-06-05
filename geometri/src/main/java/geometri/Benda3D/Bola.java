package geometri.Benda3D;

import geometri.Benda2D.Lingkaran; // Menggunakan Lingkaran yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Bola.
 * Bola adalah bentuk geometris tiga dimensi yang sempurna bulat.
 */
public class Bola extends Lingkaran {

    /**
     * Konstruktor untuk membuat objek Bola.
     * Jari-jari bola sama dengan jari-jari lingkaran dasarnya.
     * @param jariJari panjang jari-jari bola.
     */
    public Bola(double jariJari) {
        super(jariJari); // Memanggil konstruktor Lingkaran untuk menetapkan jariJari
    }

    /**
     * Menghitung volume bola.
     * Rumus: (4/3) * PI * r^3
     * @return volume bola.
     */
    public double hitungVolume() {
        // super.jariJari dapat diakses karena protected di Lingkaran
        return (4.0 / 3.0) * Math.PI * Math.pow(super.jariJari, 3);
    }

    /**
     * Menghitung luas permukaan bola.
     * Rumus: 4 * PI * r^2
     * @return luas permukaan bola.
     */
    public double hitungLuasPermukaan() {
        return 4 * Math.PI * Math.pow(super.jariJari, 2);
    }

    /**
     * Untuk Bola, "luas alas" tidak relevan secara umum.
     * Metode hitungLuas() dari superclass (Lingkaran) akan mengembalikan luas lingkaran besar.
     * Bisa dianggap sebagai luas penampang tengah bola.
     * @return Luas lingkaran besar dari bola (PI * r^2).
     */
    public double hitungLuasPenampangTengah() {
        return super.hitungLuas(); // Memanfaatkan implementasi dari Lingkaran
    }

    /**
     * Untuk Bola, "keliling alas" tidak relevan secara umum.
     * Metode hitungKeliling() dari superclass (Lingkaran) akan mengembalikan keliling lingkaran besar.
     * @return Keliling lingkaran besar dari bola (2 * PI * r).
     */
    public double hitungKelilingLingkaranBesar() {
        return super.hitungKeliling(); // Memanfaatkan implementasi dari Lingkaran
    }
}