package geometri.Benda2D;

import geometri.AbstractGeometriDasar;

/**
 * Kelas yang merepresentasikan bangun datar Segitiga.
 */
public class Segitiga extends AbstractGeometriDasar {

    private double alas;
    private double tinggi;
    private double sisiA;
    private double sisiB;
    private double sisiC;

    public Segitiga(double alas, double tinggi, double sisiA, double sisiB, double sisiC) {
        super("Segitiga");
        if (alas <= 0 || tinggi <= 0 || sisiA <= 0 || sisiB <= 0 || sisiC <= 0) {
            throw new IllegalArgumentException("Semua dimensi segitiga (alas, tinggi, sisi) harus bernilai positif.");
        }
        if (sisiA + sisiB <= sisiC || sisiA + sisiC <= sisiB || sisiB + sisiC <= sisiA) {
            throw new IllegalArgumentException("Dimensi sisi-sisi tidak membentuk segitiga yang valid.");
        }
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiA = sisiA;
        this.sisiB = sisiB;
        this.sisiC = sisiC;
    }

    @Override
    public double hitungLuas() {
        return 0.5 * this.alas * this.tinggi;
    }

    @Override
    public double hitungKeliling() {
        return this.sisiA + this.sisiB + this.sisiC;
    }

    public double getAlas() { return alas; }
    public double getTinggi() { return tinggi; }
    public double getSisiA() { return sisiA; }
    public double getSisiB() { return sisiB; }
    public double getSisiC() { return sisiC; }
}