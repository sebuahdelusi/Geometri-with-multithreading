package geometri.Benda2D;

import geometri.AbstractGeometriDasar;

/**
 * Kelas yang merepresentasikan bangun datar Belah Ketupat.
 */
public class BelahKetupat extends AbstractGeometriDasar {

    private double diagonal1;
    private double diagonal2;
    private double sisi;

    public BelahKetupat(double diagonal1, double diagonal2, double sisi) {
        super("Belah Ketupat");
        if (diagonal1 <= 0 || diagonal2 <= 0 || sisi <= 0) {
            throw new IllegalArgumentException("Diagonal dan sisi harus bernilai positif.");
        }
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisi = sisi;
    }

    @Override
    public double hitungLuas() {
        return (this.diagonal1 * this.diagonal2) / 2.0;
    }

    @Override
    public double hitungKeliling() {
        return 4 * this.sisi;
    }

    public double getDiagonal1() { return diagonal1; }
    public double getDiagonal2() { return diagonal2; }
    public double getSisi() { return sisi; }
}