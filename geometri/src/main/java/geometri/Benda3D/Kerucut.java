package geometri.Benda3D;

import geometri.Benda2D.Lingkaran; // Menggunakan Lingkaran yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Kerucut.
 * Kerucut memiliki alas lingkaran dan satu puncak.
 */
public class Kerucut extends Lingkaran {

    private double tinggi;
    // Garis pelukis (s) bisa dihitung atau disimpan. Kita akan hitung saat dibutuhkan.

    /**
     * Konstruktor untuk membuat objek Kerucut.
     * Nama konstruktor sebelumnya 'Kecurut' telah diperbaiki menjadi 'Kerucut'.
     * @param jariJari panjang jari-jari alas lingkaran kerucut.
     * @param tinggi tinggi kerucut (jarak dari puncak ke pusat alas).
     */
    public Kerucut(double jariJari, double tinggi) {
        super(jariJari); // Memanggil konstruktor Lingkaran
        if (tinggi <= 0) {
            throw new IllegalArgumentException("Tinggi kerucut harus bernilai positif.");
        }
        this.tinggi = tinggi;
    }

    /**
     * Menghitung panjang garis pelukis (s) kerucut.
     * Rumus: s = sqrt(r^2 + tinggi^2)
     * @return panjang garis pelukis.
     */
    public double getGarisPelukis() {
        // super.jariJari diakses dari Lingkaran
        return Math.sqrt(Math.pow(super.jariJari, 2) + Math.pow(this.tinggi, 2));
    }

    /**
     * Menghitung volume kerucut.
     * Rumus: (1/3) * LuasAlas * tinggi = (1/3) * PI * r^2 * tinggi
     * @return volume kerucut.
     */
    public double hitungVolume() {
        // super.hitungLuas() akan mengembalikan PI * r^2 dari Lingkaran (alas)
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggi;
    }

    /**
     * Menghitung luas permukaan kerucut.
     * Rumus: LuasAlas + LuasSelimut
     * LuasSelimut = PI * r * s (dimana s adalah garis pelukis)
     * @return luas permukaan kerucut.
     */
    public double hitungLuasPermukaan() {
        double luasAlas = super.hitungLuas(); // PI * r^2
        double garisPelukis = getGarisPelukis();
        double luasSelimut = Math.PI * super.jariJari * garisPelukis;
        return luasAlas + luasSelimut;
    }

    public double getTinggi() {
        return tinggi;
    }

    // Metode getJariJari() diwarisi dari Lingkaran
}