package geometri.Benda3D;

import geometri.Benda2D.Lingkaran; // Induk dari Kerucut adalah Lingkaran
import geometri.Benda3D.Kerucut;   // Kelas induk

/**
 * Kelas yang merepresentasikan bangun ruang Kerucut Terpancung (Frustum).
 * Ini adalah kerucut dengan bagian atasnya dipotong oleh bidang sejajar alas.
 */
public class KerucutTerpancung extends Kerucut {

    private double jariJariAtas; // Jari-jari lingkaran atas (r kecil)
    private double tinggiFrustum;  // Tinggi dari kerucut terpancung (h frustum)
    // jariJari (dari superclass Lingkaran via Kerucut) akan dianggap sebagai jariJariBawah (R besar)
    // tinggi (dari superclass Kerucut) mungkin tidak langsung digunakan atau perlu interpretasi

    /**
     * Konstruktor untuk membuat objek KerucutTerpancung.
     * @param jariJariBawah (R) jari-jari alas bawah.
     * @param jariJariAtas (r) jari-jari alas atas.
     * @param tinggiFrustum (h) tinggi kerucut terpancung.
     */
    public KerucutTerpancung(double jariJariBawah, double jariJariAtas, double tinggiFrustum) {
        // Memanggil konstruktor Kerucut. Parameter 'tinggi' untuk superclass Kerucut
        // bisa jadi tinggi kerucut "asli" jika diketahui, atau nilai dummy jika tidak relevan.
        // Untuk kesederhanaan, kita bisa anggap tinggi kerucut asli tidak langsung digunakan
        // dalam formula frustum yang umum, jadi kita bisa pass tinggiFrustum atau nilai placeholder.
        // Namun, lebih baik jika Kerucut (superclass) lebih fleksibel atau frustum tidak extend.
        // Mengingat struktur, kita akan pass jariJariBawah ke superclass.
        // Tinggi yang di-pass ke superclass Kerucut tidak akan dipakai langsung oleh frustum.
        super(jariJariBawah, tinggiFrustum); // jariJariBawah akan menjadi super.jariJari
        // super.tinggi akan di-set ke tinggiFrustum (shadowed)

        if (jariJariAtas <= 0 || tinggiFrustum <= 0) {
            throw new IllegalArgumentException("Jari-jari atas dan tinggi frustum harus bernilai positif.");
        }
        if (jariJariAtas >= jariJariBawah) {
            throw new IllegalArgumentException("Jari-jari atas harus lebih kecil dari jari-jari bawah.");
        }
        this.jariJariAtas = jariJariAtas;
        this.tinggiFrustum = tinggiFrustum; // Ini akan men-shadow this.tinggi dari superclass Kerucut
    }

    /**
     * Menghitung garis pelukis (s') kerucut terpancung.
     * s' = sqrt(h_frustum^2 + (R-r)^2)
     * @return panjang garis pelukis kerucut terpancung.
     */
    public double getGarisPelukisFrustum() {
        double selisihJariJari = super.getJariJari() - this.jariJariAtas; // R - r
        return Math.sqrt(Math.pow(this.tinggiFrustum, 2) + Math.pow(selisihJariJari, 2));
    }

    /**
     * Menghitung volume kerucut terpancung.
     * Rumus: (1/3) * PI * h_frustum * (R^2 + R*r + r^2)
     * @return volume kerucut terpancung.
     */
    @Override // Meng-override hitungVolume dari Kerucut (jika ada & public) atau menyediakan implementasi baru
    public double hitungVolume() {
        double R = super.getJariJari(); // Jari-jari bawah
        double r = this.jariJariAtas;   // Jari-jari atas
        return (1.0 / 3.0) * Math.PI * this.tinggiFrustum * (R*R + R*r + r*r);
    }

    /**
     * Menghitung luas permukaan kerucut terpancung.
     * Rumus: LuasAlasBawah + LuasAlasAtas + LuasSelimutFrustum
     * LuasSelimutFrustum = PI * (R+r) * s'
     * @return luas permukaan kerucut terpancung.
     */
    @Override // Meng-override hitungLuasPermukaan dari Kerucut (jika ada & public)
    public double hitungLuasPermukaan() {
        double R = super.getJariJari(); // Jari-jari bawah
        double r = this.jariJariAtas;   // Jari-jari atas

        double luasAlasBawah = Math.PI * R * R;
        double luasAlasAtas = Math.PI * r * r;

        double garisPelukis = getGarisPelukisFrustum();
        double luasSelimutFrustum = Math.PI * (R + r) * garisPelukis;

        return luasAlasBawah + luasAlasAtas + luasSelimutFrustum;
    }

    public double getJariJariAtas() {
        return jariJariAtas;
    }

    public double getTinggiFrustum() {
        return tinggiFrustum;
    }

    // getJariJari() (untuk jariJariBawah) diwarisi dari Lingkaran (via Kerucut)
}