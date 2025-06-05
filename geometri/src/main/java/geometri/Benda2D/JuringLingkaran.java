package geometri.Benda2D;

/**
 * Kelas yang merepresentasikan Juring Lingkaran.
 */
public class JuringLingkaran extends Lingkaran {

    private double sudutBusurDerajat;

    /**
     * Konstruktor untuk JuringLingkaran.
     * @param jariJari jari-jari lingkaran induk.
     * @param sudutBusurDerajat sudut pusat juring dalam derajat.
     */
    public JuringLingkaran(double jariJari, double sudutBusurDerajat) {
        // Memanggil konstruktor protected Lingkaran untuk mengatur nama spesifik
        super(jariJari, "Juring Lingkaran");
        if (sudutBusurDerajat <= 0 || sudutBusurDerajat > 360) {
            throw new IllegalArgumentException("Sudut busur harus antara 0 (eksklusif) dan 360 (inklusif) derajat.");
        }
        this.sudutBusurDerajat = sudutBusurDerajat;
    }

    private double getSudutBusurRadian() {
        return Math.toRadians(this.sudutBusurDerajat);
    }

    @Override
    public double hitungLuas() {
        return (this.sudutBusurDerajat / 360.0) * (Math.PI * super.jariJari * super.jariJari);
    }

    @Override
    public double hitungKeliling() {
        double panjangBusur = (this.sudutBusurDerajat / 360.0) * (2 * Math.PI * super.jariJari);
        return panjangBusur + (2 * super.jariJari);
    }

    public double getSudutBusurDerajat() {
        return sudutBusurDerajat;
    }
}