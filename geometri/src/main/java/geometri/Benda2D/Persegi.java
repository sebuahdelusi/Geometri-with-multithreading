package geometri.Benda2D;

import geometri.AbstractGeometriDasar; // Impor kelas abstrak baru

/**
 * Kelas yang merepresentasikan bangun datar Persegi.
 */
public class Persegi extends AbstractGeometriDasar { // Mewarisi dari AbstractGeometriDasar

    private double sisi;

    /**
     * Konstruktor untuk membuat objek Persegi.
     * @param sisi panjang sisi persegi.
     */
    public Persegi(double sisi) {
        super("Persegi"); // Memanggil konstruktor superclass dengan nama bangun
        if (sisi <= 0) {
            throw new IllegalArgumentException("Sisi harus bernilai positif.");
        }
        this.sisi = sisi;
    }

    @Override
    public double hitungLuas() {
        return this.sisi * this.sisi;
    }

    @Override
    public double hitungKeliling() {
        return 4 * this.sisi;
    }

    public double getSisi() {
        return sisi;
    }
}