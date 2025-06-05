package geometri.Benda3D;

import geometri.Benda3D.Bola; // Menggunakan Bola yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan Juring Bola (Spherical Sector).
 * Terbentuk dari sebuah tembereng bola (cap) dan sebuah kerucut dengan puncak
 * di pusat bola dan alasnya adalah alas tembereng tersebut.
 */
public class JuringBola extends Bola {

    private double tinggiTemberengDasar; // Tinggi tembereng (cap) yang membentuk juring (h)

    /**
     * Konstruktor untuk JuringBola.
     * @param jariJariBola (R) jari-jari bola induk.
     * @param tinggiTemberengDasar (h) tinggi tembereng (cap) yang menjadi dasar juring.
     */
    public JuringBola(double jariJariBola, double tinggiTemberengDasar) {
        super(jariJariBola); // Memanggil konstruktor Bola
        if (tinggiTemberengDasar <= 0 || tinggiTemberengDasar > (2 * jariJariBola)) {
            throw new IllegalArgumentException("Tinggi tembereng dasar harus positif dan tidak melebihi diameter bola.");
        }
        this.tinggiTemberengDasar = tinggiTemberengDasar;
    }

    /**
     * Menghitung jari-jari alas tembereng (a) yang menjadi dasar juring.
     * Rumus: a = sqrt(h * (2R - h))
     * @return jari-jari alas tembereng.
     */
    public double getJariJariAlasTembereng() {
        // super.jariJari adalah R (jari-jari bola)
        return Math.sqrt(this.tinggiTemberengDasar * (2 * super.getJariJari() - this.tinggiTemberengDasar));
    }

    /**
     * Menghitung volume juring bola.
     * Rumus: (2/3) * PI * R^2 * h
     * @return volume juring bola.
     */
    @Override
    public double hitungVolume() {
        // super.jariJari adalah R (jari-jari bola)
        return (2.0 / 3.0) * Math.PI * Math.pow(super.getJariJari(), 2) * this.tinggiTemberengDasar;
    }

    /**
     * Menghitung luas permukaan juring bola.
     * Terdiri dari luas permukaan lengkung tembereng (calotte) dan luas selimut kerucut
     * yang puncaknya di pusat bola dan alasnya adalah alas tembereng.
     * Luas Permukaan Lengkung Tembereng = 2 * PI * R * h
     * Luas Selimut Kerucut (dengan garis pelukis = R) = PI * a * R
     * Total = PI * R * (2h + a)
     * @return total luas permukaan juring bola.
     */
    @Override
    public double hitungLuasPermukaan() {
        double R_bola = super.getJariJari();
        double h_tembereng = this.tinggiTemberengDasar;
        double a_alasTembereng = getJariJariAlasTembereng();

        double luasLengkungTembereng = 2 * Math.PI * R_bola * h_tembereng;
        double luasSelimutKerucutDalam = Math.PI * a_alasTembereng * R_bola;

        return luasLengkungTembereng + luasSelimutKerucutDalam;
        // Atau: return Math.PI * R_bola * (2 * h_tembereng + a_alasTembereng);
    }

    public double getTinggiTemberengDasar() {
        return tinggiTemberengDasar;
    }

    // getJariJari() (untuk jariJariBola) diwarisi dari Lingkaran (via Bola)
}