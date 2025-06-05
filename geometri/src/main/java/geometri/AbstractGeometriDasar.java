package geometri;

/**
 * Kelas abstrak dasar untuk bangun geometri.
 * Menyediakan atribut nama dan implementasi dasar.
 * Semua bangun datar konkret akan mewarisi dari kelas ini.
 */
public abstract class AbstractGeometriDasar implements BangunGeometri {
    protected String namaBangun;

    /**
     * Konstruktor untuk AbstractGeometriDasar.
     * @param namaBangun Nama dari bangun geometri.
     */
    public AbstractGeometriDasar(String namaBangun) {
        this.namaBangun = namaBangun;
    }

    /**
     * Mendapatkan nama bangun geometri.
     * @return Nama bangun.
     */
    public String getNamaBangun() {
        return namaBangun;
    }

    // Metode hitungLuas() dan hitungKeliling() dari interface BangunGeometri
    // akan tetap abstrak di sini (atau tidak dideklarasikan ulang,
    // sehingga kelas konkret turunan wajib mengimplementasikannya).
    // @Override
    // public abstract double hitungLuas(); // Opsional dideklarasikan ulang sbg abstract
    // @Override
    // public abstract double hitungKeliling(); // Opsional dideklarasikan ulang sbg abstract
}