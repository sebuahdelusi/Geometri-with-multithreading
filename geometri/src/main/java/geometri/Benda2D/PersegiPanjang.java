package geometri.Benda2D;

import geometri.AbstractGeometriDasar;

/**
 * Kelas yang merepresentasikan bangun datar Persegi Panjang.
 */
public class PersegiPanjang extends AbstractGeometriDasar {

    private double panjang;
    private double lebar;

    /**
     * Konstruktor untuk membuat objek PersegiPanjang.
     * @param panjang panjang persegi panjang.
     * @param lebar lebar persegi panjang.
     */
    public PersegiPanjang(double panjang, double lebar) {
        super("Persegi Panjang");
        if (panjang <= 0 || lebar <= 0) {
            throw new IllegalArgumentException("Panjang dan lebar harus bernilai positif.");
        }
        this.panjang = panjang;
        this.lebar = lebar;
    }

    @Override
    public double hitungLuas() {
        return this.panjang * this.lebar;
    }

    @Override
    public double hitungKeliling() {
        return 2 * (this.panjang + this.lebar);
    }

    public double getPanjang() {
        return panjang;
    }

    public double getLebar() {
        return lebar;
    }
}