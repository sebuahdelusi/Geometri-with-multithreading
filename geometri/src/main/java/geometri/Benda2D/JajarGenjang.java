package geometri.Benda2D;

import geometri.AbstractGeometriDasar;

/**
 * Kelas yang merepresentasikan bangun datar Jajar Genjang.
 */
public class JajarGenjang extends AbstractGeometriDasar {

    private double alas;
    private double tinggi;
    private double sisiMiring;

    public JajarGenjang(double alas, double tinggi, double sisiMiring) {
        super("Jajar Genjang");
        if (alas <= 0 || tinggi <= 0 || sisiMiring <= 0) {
            throw new IllegalArgumentException("Alas, tinggi, dan sisi miring harus bernilai positif.");
        }
        this.alas = alas;
        this.tinggi = tinggi;
        this.sisiMiring = sisiMiring;
    }

    @Override
    public double hitungLuas() {
        return this.alas * this.tinggi;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (this.alas + this.sisiMiring);
    }

    public double getAlas() { return alas; }
    public double getTinggi() { return tinggi; }
    public double getSisiMiring() { return sisiMiring; }
}