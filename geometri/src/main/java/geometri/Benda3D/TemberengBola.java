package geometri.Benda3D;

import geometri.Benda3D.Bola; // Menggunakan Bola yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan Tembereng Bola (Spherical Cap).
 * Ini adalah bagian dari bola yang dipotong oleh sebuah bidang datar.
 */
public class TemberengBola extends Bola {

    private double tinggiTembereng; // Tinggi tembereng (h)

    /**
     * Konstruktor untuk TemberengBola.
     * @param jariJariBola (R) jari-jari bola induk.
     * @param tinggiTembereng (h) tinggi tembereng (jarak dari puncak cap ke bidang alasnya).
     */
    public TemberengBola(double jariJariBola, double tinggiTembereng) {
        super(jariJariBola); // Memanggil konstruktor Bola
        if (tinggiTembereng <= 0 || tinggiTembereng > (2 * jariJariBola) ) {
            throw new IllegalArgumentException("Tinggi tembereng harus positif dan tidak melebihi diameter bola.");
        }
        this.tinggiTembereng = tinggiTembereng;
    }

    /**
     * Menghitung jari-jari alas tembereng (a).
     * Rumus: a = sqrt(h * (2R - h))
     * @return jari-jari alas tembereng.
     */
    public double getJariJariAlasTembereng() {
        // super.jariJari adalah R (jari-jari bola)
        return Math.sqrt(this.tinggiTembereng * (2 * super.getJariJari() - this.tinggiTembereng));
    }

    /**
     * Menghitung volume tembereng bola.
     * Rumus: (1/3) * PI * h^2 * (3R - h)
     * @return volume tembereng bola.
     */
    @Override // Meng-override hitungVolume dari Bola (jika ada & public) atau menyediakan implementasi baru
    public double hitungVolume() {
        // super.jariJari adalah R (jari-jari bola)
        return (1.0 / 3.0) * Math.PI * Math.pow(this.tinggiTembereng, 2) * (3 * super.getJariJari() - this.tinggiTembereng);
    }

    /**
     * Menghitung luas permukaan tembereng bola.
     * Ini termasuk luas permukaan lengkung (calotte) dan luas alas lingkaran tembereng.
     * Luas Permukaan Lengkung = 2 * PI * R * h
     * Luas Alas Tembereng = PI * a^2
     * @return total luas permukaan tembereng bola.
     */
    @Override // Meng-override hitungLuasPermukaan dari Bola (jika ada & public)
    public double hitungLuasPermukaan() {
        // super.jariJari adalah R (jari-jari bola)
        double luasPermukaanLengkung = 2 * Math.PI * super.getJariJari() * this.tinggiTembereng;
        double jariJariAlas = getJariJariAlasTembereng();
        double luasAlasTembereng = Math.PI * Math.pow(jariJariAlas, 2);

        return luasPermukaanLengkung + luasAlasTembereng;
    }

    /**
     * Menghitung luas permukaan lengkung saja (calotte).
     * @return luas permukaan lengkung tembereng bola.
     */
    public double hitungLuasPermukaanLengkung() {
        return 2 * Math.PI * super.getJariJari() * this.tinggiTembereng;
    }

    public double getTinggiTembereng() {
        return tinggiTembereng;
    }

    // getJariJari() (untuk jariJariBola) diwarisi dari Lingkaran (via Bola)
}