package geometri.Benda2D;

import geometri.AbstractGeometriDasar;

/**
 * Kelas yang merepresentasikan bangun datar Trapesium.
 */
public class Trapesium extends AbstractGeometriDasar {

    private double sisiAtas;
    private double sisiBawah;
    private double tinggi;
    private double sisiKiri;
    private double sisiKanan;

    public Trapesium(double sisiAtas, double sisiBawah, double tinggi, double sisiKiri, double sisiKanan) {
        super("Trapesium");
        if (sisiAtas <= 0 || sisiBawah <= 0 || tinggi <= 0 || sisiKiri <= 0 || sisiKanan <= 0) {
            throw new IllegalArgumentException("Semua dimensi trapesium harus bernilai positif.");
        }
        this.sisiAtas = sisiAtas;
        this.sisiBawah = sisiBawah;
        this.tinggi = tinggi;
        this.sisiKiri = sisiKiri;
        this.sisiKanan = sisiKanan;
    }

    @Override
    public double hitungLuas() {
        return 0.5 * (this.sisiAtas + this.sisiBawah) * this.tinggi;
    }

    @Override
    public double hitungKeliling() {
        return this.sisiAtas + this.sisiBawah + this.sisiKiri + this.sisiKanan;
    }

    public double getSisiAtas() { return sisiAtas; }
    public double getSisiBawah() { return sisiBawah; }
    public double getTinggi() { return tinggi; }
    public double getSisiKiri() { return sisiKiri; }
    public double getSisiKanan() { return sisiKanan; }
}