package geometri.Benda2D;

/**
 * Kelas yang merepresentasikan Tembereng Lingkaran.
 */
public class TemberengLingkaran extends Lingkaran {

    private double sudutPusatDerajat;

    public TemberengLingkaran(double jariJari, double sudutPusatDerajat) {
        super(jariJari, "Tembereng Lingkaran"); // Panggil konstruktor protected Lingkaran
        if (sudutPusatDerajat <= 0 || sudutPusatDerajat >= 360) {
            throw new IllegalArgumentException("Sudut pusat harus antara 0 (eksklusif) dan 360 (eksklusif) derajat untuk tembereng yang valid.");
        }
        this.sudutPusatDerajat = sudutPusatDerajat;
    }

    private double getSudutPusatRadian() {
        return Math.toRadians(this.sudutPusatDerajat);
    }

    @Override
    public double hitungLuas() {
        double sudutRadian = getSudutPusatRadian();
        double luasJuring = 0.5 * super.jariJari * super.jariJari * sudutRadian;
        double luasSegitigaDalamJuring = 0.5 * super.jariJari * super.jariJari * Math.sin(sudutRadian);
        return luasJuring - luasSegitigaDalamJuring;
    }

    @Override
    public double hitungKeliling() {
        double sudutRadian = getSudutPusatRadian();
        double panjangBusur = super.jariJari * sudutRadian;
        double panjangTaliBusur = 2 * super.jariJari * Math.sin(sudutRadian / 2.0);
        return panjangBusur + panjangTaliBusur;
    }

    public double getSudutPusatDerajat() {
        return sudutPusatDerajat;
    }
}