package geometri.Benda2D;

import geometri.AbstractGeometriDasar;

/**
 * Kelas yang merepresentasikan bangun datar Layang-Layang.
 */
public class LayangLayang extends AbstractGeometriDasar {

    private double diagonal1;
    private double diagonal2;
    private double sisiPendek;
    private double sisiPanjang;

    public LayangLayang(double diagonal1, double diagonal2, double sisiPendek, double sisiPanjang) {
        super("Layang-Layang");
        if (diagonal1 <= 0 || diagonal2 <= 0 || sisiPendek <= 0 || sisiPanjang <= 0) {
            throw new IllegalArgumentException("Diagonal dan sisi harus bernilai positif.");
        }
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.sisiPendek = sisiPendek;
        this.sisiPanjang = sisiPanjang;
    }

    @Override
    public double hitungLuas() {
        return 0.5 * this.diagonal1 * this.diagonal2;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (this.sisiPendek + this.sisiPanjang);
    }

    public double getDiagonal1() { return diagonal1; }
    public double getDiagonal2() { return diagonal2; }
    public double getSisiPendek() { return sisiPendek; }
    public double getSisiPanjang() { return sisiPanjang; }
}