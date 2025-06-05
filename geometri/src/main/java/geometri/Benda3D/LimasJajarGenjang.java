package geometri.Benda3D;

import geometri.Benda2D.JajarGenjang; // Menggunakan JajarGenjang yang sudah diperbaiki

/**
 * Kelas yang merepresentasikan bangun ruang Limas dengan alas Jajar Genjang.
 * Perhitungan luas selubung sangat bergantung pada posisi puncak dan bentuk spesifik.
 */
public class LimasJajarGenjang extends JajarGenjang {

    private double tinggiLimas;

    /**
     * Konstruktor untuk LimasJajarGenjang.
     * @param alasJajarGenjangAlas panjang alas dari alas jajar genjang.
     * @param tinggiJajarGenjangAlas tinggi dari alas jajar genjang.
     * @param sisiMiringJajarGenjangAlas panjang sisi miring dari alas jajar genjang.
     * @param tinggiLimas tinggi limas.
     */
    public LimasJajarGenjang(double alasJajarGenjangAlas, double tinggiJajarGenjangAlas,
                             double sisiMiringJajarGenjangAlas, double tinggiLimas) {
        super(alasJajarGenjangAlas, tinggiJajarGenjangAlas, sisiMiringJajarGenjangAlas);
        if (tinggiLimas <= 0) {
            throw new IllegalArgumentException("Tinggi limas harus bernilai positif.");
        }
        this.tinggiLimas = tinggiLimas;
    }

    public double hitungVolume() {
        return (1.0 / 3.0) * super.hitungLuas() * this.tinggiLimas;
    }

    /**
     * Menghitung luas selubung limas jajar genjang.
     * Terdiri dari 2 pasang segitiga sisi tegak yang mungkin berbeda.
     * Perhitungan tinggi masing-masing sisi tegak ini kompleks tanpa asumsi lebih lanjut
     * (misalnya, puncak limas tepat di atas centroid alas).
     *
     * @param tsAlas Tinggi sisi tegak yang bersandar pada sisi 'alas' jajar genjang.
     * @param tsSisiMiring Tinggi sisi tegak yang bersandar pada sisi 'sisiMiring' jajar genjang.
     * @return luas selubung.
     */
    public double hitungLuasSelubung(double tsAlas, double tsSisiMiring) {
        if (tsAlas <=0 || tsSisiMiring <=0) {
            throw new IllegalArgumentException("Tinggi sisi tegak harus positif.");
        }
        // Luas 2 segitiga pada sisi 'alas'
        double luasTegak1 = 2 * (0.5 * super.getAlas() * tsAlas);
        // Luas 2 segitiga pada sisi 'sisiMiring'
        double luasTegak2 = 2 * (0.5 * super.getSisiMiring() * tsSisiMiring);
        return luasTegak1 + luasTegak2;
    }

    /**
     * Menghitung luas permukaan limas jajar genjang.
     * @param tsAlas Tinggi sisi tegak yang bersandar pada sisi 'alas' jajar genjang.
     * @param tsSisiMiring Tinggi sisi tegak yang bersandar pada sisi 'sisiMiring' jajar genjang.
     * @return luas permukaan.
     */
    public double hitungLuasPermukaan(double tsAlas, double tsSisiMiring) {
        return super.hitungLuas() + hitungLuasSelubung(tsAlas, tsSisiMiring);
    }

    /**
     * Versi hitungLuasPermukaan tanpa parameter tinggi sisi tegak.
     * Akan memberikan hasil tidak lengkap (hanya luas alas) atau memerlukan override.
     */
    public double hitungLuasPermukaan() {
        System.err.println("PERINGATAN: hitungLuasPermukaan() untuk LimasJajarGenjang umum dipanggil tanpa parameter tinggi sisi tegak. " +
                "Hasil mungkin tidak akurat atau metode ini harus di-override dengan logika spesifik.");
        return super.hitungLuas(); // Tidak menghitung selubung.
    }

    public double getTinggiLimas() {
        return tinggiLimas;
    }
}