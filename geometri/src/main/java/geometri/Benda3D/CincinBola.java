package geometri.Benda3D;

import geometri.Benda3D.Bola; // Menggunakan Bola yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan Cincin Bola (Spherical Zone).
 * Ini adalah bagian dari bola yang terletak di antara dua bidang sejajar.
 */
public class CincinBola extends Bola {

    private double tinggiCincin; // Tinggi cincin/zone (h)
    private double jariJariAlas1; // Jari-jari alas pertama (r1)
    private double jariJariAlas2; // Jari-jari alas kedua (r2)

    /**
     * Konstruktor untuk CincinBola.
     * @param jariJariBola (R) jari-jari bola induk.
     * @param tinggiCincin (h) tinggi cincin (jarak antara dua bidang alas).
     * @param jariJariAlas1 (r1) jari-jari lingkaran alas pertama.
     * @param jariJariAlas2 (r2) jari-jari lingkaran alas kedua.
     */
    public CincinBola(double jariJariBola, double tinggiCincin, double jariJariAlas1, double jariJariAlas2) {
        super(jariJariBola); // Memanggil konstruktor Bola

        if (tinggiCincin <= 0 || jariJariAlas1 < 0 || jariJariAlas2 < 0) { // jari-jari alas bisa 0 jika bidang menyentuh bola
            throw new IllegalArgumentException("Tinggi cincin harus positif, dan jari-jari alas tidak boleh negatif.");
        }
        if (tinggiCincin > 2 * jariJariBola) {
            throw new IllegalArgumentException("Tinggi cincin tidak boleh melebihi diameter bola.");
        }
        if (jariJariAlas1 > jariJariBola || jariJariAlas2 > jariJariBola) {
            throw new IllegalArgumentException("Jari-jari alas tidak boleh melebihi jari-jari bola.");
        }
        // Validasi lebih lanjut diperlukan untuk memastikan r1, r2, dan h konsisten dengan R.
        // d1^2 = R^2 - r1^2, d2^2 = R^2 - r2^2. h = |d1 +/- d2|.
        // Untuk kesederhanaan, kita asumsikan input r1, r2, h sudah konsisten.

        this.tinggiCincin = tinggiCincin;
        this.jariJariAlas1 = jariJariAlas1;
        this.jariJariAlas2 = jariJariAlas2;
    }

    /**
     * Menghitung volume cincin bola.
     * Rumus: (1/6) * PI * h * (3*r1^2 + 3*r2^2 + h^2)
     * @return volume cincin bola.
     */
    @Override
    public double hitungVolume() {
        return (1.0 / 6.0) * Math.PI * this.tinggiCincin * (3 * Math.pow(this.jariJariAlas1, 2) +
                3 * Math.pow(this.jariJariAlas2, 2) +
                Math.pow(this.tinggiCincin, 2));
    }

    /**
     * Menghitung luas permukaan lengkung cincin bola.
     * Rumus: 2 * PI * R * h
     * @return luas permukaan lengkung cincin bola.
     */
    public double hitungLuasPermukaanLengkung() {
        // super.jariJari adalah R (jari-jari bola)
        return 2 * Math.PI * super.getJariJari() * this.tinggiCincin;
    }

    /**
     * Menghitung total luas permukaan cincin bola.
     * Ini termasuk luas permukaan lengkung dan luas kedua alas lingkaran.
     * @return total luas permukaan cincin bola.
     */
    @Override
    public double hitungLuasPermukaan() {
        double luasLengkung = hitungLuasPermukaanLengkung();
        double luasAlas1 = Math.PI * Math.pow(this.jariJariAlas1, 2);
        double luasAlas2 = Math.PI * Math.pow(this.jariJariAlas2, 2);
        return luasLengkung + luasAlas1 + luasAlas2;
    }

    public double getTinggiCincin() {
        return tinggiCincin;
    }

    public double getJariJariAlas1() {
        return jariJariAlas1;
    }

    public double getJariJariAlas2() {
        return jariJariAlas2;
    }

    // getJariJari() (untuk jariJariBola) diwarisi dari Lingkaran (via Bola)
}