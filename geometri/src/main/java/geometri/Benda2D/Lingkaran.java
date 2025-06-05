package geometri.Benda2D;

import geometri.AbstractGeometriDasar;

/**
 * Kelas yang merepresentasikan bangun datar Lingkaran.
 */
public class Lingkaran extends AbstractGeometriDasar {

    protected double jariJari;

    /**
     * Konstruktor utama untuk Lingkaran berdasarkan jari-jari.
     * @param jariJari panjang jari-jari lingkaran.
     */
    public Lingkaran(double jariJari) {
        super("Lingkaran"); // Nama default untuk objek Lingkaran
        if (jariJari <= 0) {
            throw new IllegalArgumentException("Jari-jari harus bernilai positif.");
        }
        this.jariJari = jariJari;
    }

    /**
     * Konstruktor overload untuk Lingkaran berdasarkan diameter.
     * @param diameter panjang diameter lingkaran.
     * @param isDiameter flag untuk membedakan dari konstruktor jari-jari (nilai boolean bisa apa saja).
     */
    public Lingkaran(double diameter, boolean isDiameter) {
        super("Lingkaran (dari Diameter)"); // Nama bisa disesuaikan
        if (!isDiameter) {
            // Seharusnya tidak terjadi jika dipanggil dengan benar, tapi sebagai pengaman
            throw new IllegalArgumentException("Gunakan konstruktor Lingkaran(jariJari) untuk input jari-jari.");
        }
        if (diameter <= 0) {
            throw new IllegalArgumentException("Diameter harus bernilai positif.");
        }
        this.jariJari = diameter / 2.0;
    }

    /**
     * Konstruktor protected untuk digunakan oleh subclass seperti JuringLingkaran,
     * memungkinkan mereka mengatur nama bangunnya sendiri.
     * @param jariJari jari-jari.
     * @param namaBangun nama spesifik bangun (misal "Juring Lingkaran").
     */
    protected Lingkaran(double jariJari, String namaBangun) {
        super(namaBangun);
        if (jariJari <= 0) {
            throw new IllegalArgumentException("Jari-jari harus bernilai positif.");
        }
        this.jariJari = jariJari;
    }


    @Override
    public double hitungLuas() {
        return Math.PI * this.jariJari * this.jariJari;
    }

    @Override
    public double hitungKeliling() {
        return 2 * Math.PI * this.jariJari;
    }

    public double getJariJari() {
        return jariJari;
    }

    public double getDiameter() {
        return 2 * this.jariJari;
    }
}