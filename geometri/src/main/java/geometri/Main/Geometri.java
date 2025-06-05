package geometri.Main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Impor kelas-kelas Benda2D
import geometri.AbstractGeometriDasar;
import geometri.BangunGeometri;
import geometri.Benda2D.*;

// Impor kelas-kelas Benda3D
import geometri.Benda3D.*;

public class Geometri {

    private static Scanner scanner = new Scanner(System.in);
    private static ExecutorService executor = Executors.newCachedThreadPool(); // Thread pool


    public static void main(String[] args) {
        int pilihanUtama;
        do {
            tampilkanMenuUtama();
            pilihanUtama = bacaPilihanMenu(0, 3);

            switch (pilihanUtama) {
                case 1:
                    prosesMenu2D();
                    break;
                case 2:
                    prosesMenu3D();
                    break;
                case 3:
                    demonstrasiPolimorfisme();
                    break;
                case 0:
                    System.out.println("Menutup thread pool...");
                    executor.shutdown();
                    try {
                        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                            executor.shutdownNow();
                        }
                    } catch (InterruptedException e) {
                        executor.shutdownNow();
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("Terima kasih telah menggunakan Kalkulator Geometri. Sampai jumpa!");
                    break;
            }
            if (pilihanUtama != 0 && pilihanUtama != 3) {
                System.out.println("\nTekan Enter untuk kembali ke menu utama...");
                scanner.nextLine();
            }
        } while (pilihanUtama != 0);

        scanner.close();
    }

    private static void tampilkanMenuUtama() {
        System.out.println("\n===== Kalkulator Geometri Interaktif =====");
        System.out.println("Pilih jenis bangun:");
        System.out.println("1. Bangun Datar (2D)");
        System.out.println("2. Bangun Ruang (3D)");
        System.out.println("3. Demonstrasi Polimorfisme & Overloading (2D)");
        System.out.println("0. Keluar");
    }

    private static void demonstrasiPolimorfisme() {
        System.out.println("\n--- Demonstrasi Polimorfisme & Overloading ---");
        List<AbstractGeometriDasar> daftarBangun = new ArrayList<>();

        daftarBangun.add(new Persegi(4.0));
        daftarBangun.add(new Lingkaran(3.0));
        daftarBangun.add(new Lingkaran(10.0, true));
        daftarBangun.add(new Segitiga(6, 4, 6, 5, 5));
        daftarBangun.add(new JuringLingkaran(5.0, 60.0));

        System.out.println("\nMenghitung properti bangun datar secara polimorfik (di thread utama):");
        for (AbstractGeometriDasar bangun : daftarBangun) {
            System.out.println("----------------------------------------");
            System.out.println("Objek Tipe Aktual : " + bangun.getClass().getSimpleName());
            System.out.println("Nama Bangun       : " + bangun.getNamaBangun());
            System.out.printf("  Luas            : %.2f\n", bangun.hitungLuas());
            System.out.printf("  Keliling        : %.2f\n", bangun.hitungKeliling());
            if (bangun instanceof Lingkaran) {
                Lingkaran l = (Lingkaran) bangun;
                System.out.printf("  Diameter        : %.2f\n", l.getDiameter());
            }
        }
        System.out.println("----------------------------------------");
        System.out.println("Demonstrasi selesai.");
    }

    private static void prosesMenu2D() {
        int pilihan2D;
        tampilkanMenu2D();
        pilihan2D = bacaPilihanMenu(0, 10);

        switch (pilihan2D) {
            case 1: handlePersegi(); break;
            case 2: handlePersegiPanjang(); break;
            case 3: handleLingkaran(); break;
            case 4: handleSegitiga(); break;
            case 5: handleBelahKetupat(); break;
            case 6: handleJajarGenjang(); break;
            case 7: handleLayangLayang(); break;
            case 8: handleTrapesium(); break;
            case 9: handleJuringLingkaran(); break;
            case 10: handleTemberengLingkaran(); break;
            case 0: return;
            default: System.out.println("Pilihan tidak valid.");
        }
    }

    private static void tampilkanMenu2D() {
        System.out.println("\n--- Pilih Bangun Datar ---");
        System.out.println("1. Persegi");
        System.out.println("2. Persegi Panjang");
        System.out.println("3. Lingkaran");
        System.out.println("4. Segitiga");
        System.out.println("5. Belah Ketupat");
        System.out.println("6. Jajar Genjang");
        System.out.println("7. Layang-Layang");
        System.out.println("8. Trapesium");
        System.out.println("9. Juring Lingkaran");
        System.out.println("10. Tembereng Lingkaran");
        System.out.println("0. Kembali ke Menu Utama");
    }

    private static void prosesMenu3D() {
        int pilihan3D;
        tampilkanMenu3D();
        pilihan3D = bacaPilihanMenu(0, 21);

        switch (pilihan3D) {
            case 1: handleBola(); break;
            case 2: handleTabung(); break;
            case 3: handleKerucut(); break;
            case 4: handlePrismaPersegi(); break;
            case 5: handlePrismaPersegiPanjang(); break;
            case 6: handlePrismaSegitiga(); break;
            case 7: handlePrismaBelahKetupat(); break;
            case 8: handlePrismaJajarGenjang(); break;
            case 9: handlePrismaLayangLayang(); break;
            case 10: handlePrismaTrapesium(); break;
            case 11: handleLimasPersegi(); break;
            case 12: handleLimasPersegiPanjang(); break;
            case 13: handleLimasSegitiga(); break;
            case 14: handleLimasBelahKetupat(); break;
            case 15: handleLimasJajarGenjang(); break;
            case 16: handleLimasLayangLayang(); break;
            case 17: handleLimasTrapesium(); break;
            case 18: handleKerucutTerpancung(); break;
            case 19: handleTemberengBola(); break;
            case 20: handleCincinBola(); break;
            case 21: handleJuringBola(); break;
            case 0: return;
            default: System.out.println("Pilihan tidak valid.");
        }
    }

    private static void tampilkanMenu3D() {
        System.out.println("\n--- Pilih Bangun Ruang ---");
        System.out.println("1. Bola");
        System.out.println("2. Tabung");
        System.out.println("3. Kerucut");
        System.out.println("4. Prisma Persegi");
        System.out.println("5. Prisma Persegi Panjang (Balok)");
        System.out.println("6. Prisma Segitiga");
        System.out.println("7. Prisma Belah Ketupat");
        System.out.println("8. Prisma Jajar Genjang");
        System.out.println("9. Prisma Layang-Layang");
        System.out.println("10. Prisma Trapesium");
        System.out.println("11. Limas Persegi");
        System.out.println("12. Limas Persegi Panjang");
        System.out.println("13. Limas Segitiga");
        System.out.println("14. Limas Belah Ketupat");
        System.out.println("15. Limas Jajar Genjang");
        System.out.println("16. Limas Layang-Layang");
        System.out.println("17. Limas Trapesium");
        System.out.println("18. Kerucut Terpancung");
        System.out.println("19. Tembereng Bola");
        System.out.println("20. Cincin Bola");
        System.out.println("21. Juring Bola");
        System.out.println("0. Kembali ke Menu Utama");
    }

    private static int bacaPilihanMenu(int min, int max) {
        int pilihan = -1;
        boolean inputValid = false;
        while (!inputValid) {
            try {
                System.out.print("Pilihan (" + min + "-" + max + "): ");
                pilihan = scanner.nextInt();
                scanner.nextLine();
                if (pilihan >= min && pilihan <= max) {
                    inputValid = true;
                } else {
                    System.out.println("Pilihan di luar rentang.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Masukan salah. Harap masukkan angka.");
                scanner.nextLine();
            }
        }
        return pilihan;
    }

    private static double bacaDouble(String prompt) {
        double nilai = 0;
        boolean inputValid = false;
        while (!inputValid) {
            try {
                System.out.print(prompt);
                nilai = scanner.nextDouble();
                scanner.nextLine();
                if (nilai > 0) {
                    inputValid = true;
                } else {
                    System.out.println("Dimensi harus bernilai positif.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Masukan salah. Harap masukkan angka yang valid.");
                scanner.nextLine();
            }
        }
        return nilai;
    }

    private static double bacaDoubleNonNegatif(String prompt) {
        double nilai = -1;
        boolean inputValid = false;
        while (!inputValid) {
            try {
                System.out.print(prompt);
                nilai = scanner.nextDouble();
                scanner.nextLine();
                if (nilai >= 0) {
                    inputValid = true;
                } else {
                    System.out.println("Dimensi tidak boleh negatif.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Masukan salah. Harap masukkan angka yang valid.");
                scanner.nextLine();
            }
        }
        return nilai;
    }

    private static void submitTugasKeExecutor(Runnable tugas, String namaTugas) {
        System.out.println("Memproses perhitungan untuk " + namaTugas + " di thread terpisah...");
        executor.submit(() -> {
            Thread.currentThread().setName("Thread-" + namaTugas + "-" + System.nanoTime());
            try {
                tugas.run();
            } catch (IllegalArgumentException e) {
                System.err.println("\nError Input di thread [" + Thread.currentThread().getName() + "]: " + e.getMessage());
            } catch (InputMismatchException e) { // Seharusnya sudah ditangani oleh bacaDouble, tapi sebagai lapisan tambahan
                System.err.println("\nError Tipe Data di thread [" + Thread.currentThread().getName() + "]: Masukan harus berupa angka.");
            } catch (Exception e) {
                System.err.println("\nKesalahan tak terduga di thread [" + Thread.currentThread().getName() + "]: " + e.getMessage());
                e.printStackTrace();
            }
        });
    }

    // --- Handler untuk Benda2D (Beberapa dengan multithreading) ---
    private static void handlePersegi() {
        System.out.println("\n-- Menghitung Persegi --");
        final double sisi = bacaDouble("Masukkan panjang sisi: ");
        Runnable tugas = () -> {
            Persegi persegi = new Persegi(sisi);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk " + persegi.getNamaBangun() + ":");
            System.out.printf("  Sisi      : %.2f\n", persegi.getSisi());
            System.out.printf("  Luas      : %.2f\n", persegi.hitungLuas());
            System.out.printf("  Keliling  : %.2f\n", persegi.hitungKeliling());
        };
        submitTugasKeExecutor(tugas, "Persegi");
    }

    private static void handleLingkaran() {
        System.out.println("\n-- Menghitung Lingkaran --");
        System.out.print("Hitung berdasarkan jari-jari (j) atau diameter (d)? [j/d]: ");
        String pilihanInput = scanner.nextLine().trim().toLowerCase();

        final double dimensi;
        final boolean isDiameterInput;

        if (pilihanInput.equals("d")) {
            dimensi = bacaDouble("Masukkan diameter: ");
            isDiameterInput = true;
        } else {
            dimensi = bacaDouble("Masukkan jari-jari: ");
            isDiameterInput = false;
        }

        Runnable tugas = () -> {
            Lingkaran lingkaran;
            if (isDiameterInput) {
                lingkaran = new Lingkaran(dimensi, true); // Menggunakan konstruktor overload diameter
            } else {
                lingkaran = new Lingkaran(dimensi); // Menggunakan konstruktor jari-jari
            }

            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk " + lingkaran.getNamaBangun() + ":");
            System.out.printf("  Jari-jari : %.2f\n", lingkaran.getJariJari());
            System.out.printf("  Diameter  : %.2f\n", lingkaran.getDiameter());
            System.out.printf("  Luas      : %.2f\n", lingkaran.hitungLuas());
            System.out.printf("  Keliling  : %.2f\n", lingkaran.hitungKeliling());
        };
        submitTugasKeExecutor(tugas, "Lingkaran");
    }

    // Handler Benda2D lainnya (tanpa multithreading eksplisit di sini untuk keringkasan,
    // namun pola `submitTugasKeExecutor` bisa diterapkan jika diinginkan)
    private static void handlePersegiPanjang() {
        System.out.println("\n-- Menghitung Persegi Panjang --");
        final double panjang = bacaDouble("Masukkan panjang: ");
        final double lebar = bacaDouble("Masukkan lebar: ");
        Runnable tugas = () -> {
            PersegiPanjang pp = new PersegiPanjang(panjang, lebar);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk " + pp.getNamaBangun() + ":");
            System.out.printf("  Panjang   : %.2f\n", pp.getPanjang());
            System.out.printf("  Lebar     : %.2f\n", pp.getLebar());
            System.out.printf("  Luas      : %.2f\n", pp.hitungLuas());
            System.out.printf("  Keliling  : %.2f\n", pp.hitungKeliling());
        };
        submitTugasKeExecutor(tugas, "PersegiPanjang");
    }

    private static void handleSegitiga() {
        System.out.println("\n-- Menghitung Segitiga --");
        final double sisiA_alas = bacaDouble("Masukkan panjang sisi A (alas untuk luas): ");
        final double tinggiSegitiga = bacaDouble("Masukkan tinggi segitiga (relatif terhadap sisi A): ");
        final double sisiB_alas = bacaDouble("Masukkan panjang sisi B: ");
        final double sisiC_alas = bacaDouble("Masukkan panjang sisi C: ");
        Runnable tugas = () -> {
            Segitiga segitiga = new Segitiga(sisiA_alas, tinggiSegitiga, sisiA_alas, sisiB_alas, sisiC_alas);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk " + segitiga.getNamaBangun() + ":");
            System.out.printf("  Alas (utk luas): %.2f, Tinggi (utk luas): %.2f\n", segitiga.getAlas(), segitiga.getTinggi());
            System.out.printf("  Sisi A, B, C   : %.2f, %.2f, %.2f\n", segitiga.getSisiA(), segitiga.getSisiB(), segitiga.getSisiC());
            System.out.printf("  Luas           : %.2f\n", segitiga.hitungLuas());
            System.out.printf("  Keliling       : %.2f\n", segitiga.hitungKeliling());
        };
        submitTugasKeExecutor(tugas, "Segitiga");
    }
    // ... Implementasikan handler Benda2D lainnya dengan pola multithreading jika diinginkan ...
    private static void handleBelahKetupat() {
        System.out.println("\n-- Menghitung Belah Ketupat --");
        final double d1 = bacaDouble("Masukkan panjang diagonal 1: ");
        final double d2 = bacaDouble("Masukkan panjang diagonal 2: ");
        final double sisi = bacaDouble("Masukkan panjang sisi: ");
        Runnable tugas = () -> {
            BelahKetupat bk = new BelahKetupat(d1, d2, sisi);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk " + bk.getNamaBangun() + ":");
            System.out.printf("  Diagonal 1: %.2f, Diagonal 2: %.2f, Sisi: %.2f\n", bk.getDiagonal1(), bk.getDiagonal2(), bk.getSisi());
            System.out.printf("  Luas      : %.2f\n", bk.hitungLuas());
            System.out.printf("  Keliling  : %.2f\n", bk.hitungKeliling());
        };
        submitTugasKeExecutor(tugas, "BelahKetupat");
    }
    private static void handleJajarGenjang() {
        System.out.println("\n-- Menghitung Jajar Genjang --");
        final double alas = bacaDouble("Masukkan panjang alas: ");
        final double tinggi = bacaDouble("Masukkan tinggi jajar genjang: ");
        final double sisiMiring = bacaDouble("Masukkan panjang sisi miring: ");
        Runnable tugas = () -> {
            JajarGenjang jg = new JajarGenjang(alas, tinggi, sisiMiring);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk " + jg.getNamaBangun() + ":");
            System.out.printf("  Alas: %.2f, Tinggi: %.2f, Sisi Miring: %.2f\n", jg.getAlas(), jg.getTinggi(), jg.getSisiMiring());
            System.out.printf("  Luas      : %.2f\n", jg.hitungLuas());
            System.out.printf("  Keliling  : %.2f\n", jg.hitungKeliling());
        };
        submitTugasKeExecutor(tugas, "JajarGenjang");
    }
    private static void handleLayangLayang() {
        System.out.println("\n-- Menghitung Layang-Layang --");
        final double d1 = bacaDouble("Masukkan panjang diagonal 1: ");
        final double d2 = bacaDouble("Masukkan panjang diagonal 2: ");
        final double sisiPendek = bacaDouble("Masukkan panjang sisi pendek: ");
        final double sisiPanjang = bacaDouble("Masukkan panjang sisi panjang: ");
        Runnable tugas = () -> {
            LayangLayang ll = new LayangLayang(d1, d2, sisiPendek, sisiPanjang);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk " + ll.getNamaBangun() + ":");
            System.out.printf("  D1: %.2f, D2: %.2f, Sisi Pendek: %.2f, Sisi Panjang: %.2f\n", ll.getDiagonal1(), ll.getDiagonal2(), ll.getSisiPendek(), ll.getSisiPanjang());
            System.out.printf("  Luas      : %.2f\n", ll.hitungLuas());
            System.out.printf("  Keliling  : %.2f\n", ll.hitungKeliling());
        };
        submitTugasKeExecutor(tugas, "LayangLayang");
    }
    private static void handleTrapesium() {
        System.out.println("\n-- Menghitung Trapesium --");
        final double sisiAtas = bacaDouble("Masukkan panjang sisi atas: ");
        final double sisiBawah = bacaDouble("Masukkan panjang sisi bawah: ");
        final double tinggi = bacaDouble("Masukkan tinggi trapesium: ");
        final double sisiKiri = bacaDouble("Masukkan panjang sisi miring kiri: ");
        final double sisiKanan = bacaDouble("Masukkan panjang sisi miring kanan: ");
        Runnable tugas = () -> {
            Trapesium tr = new Trapesium(sisiAtas, sisiBawah, tinggi, sisiKiri, sisiKanan);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk " + tr.getNamaBangun() + ":");
            System.out.printf("  Sisi Atas: %.2f, Sisi Bawah: %.2f, Tinggi: %.2f\n", tr.getSisiAtas(), tr.getSisiBawah(), tr.getTinggi());
            System.out.printf("  Sisi Kiri: %.2f, Sisi Kanan: %.2f\n", tr.getSisiKiri(), tr.getSisiKanan());
            System.out.printf("  Luas      : %.2f\n", tr.hitungLuas());
            System.out.printf("  Keliling  : %.2f\n", tr.hitungKeliling());
        };
        submitTugasKeExecutor(tugas, "Trapesium");
    }
    private static void handleJuringLingkaran() {
        System.out.println("\n-- Menghitung Juring Lingkaran --");
        final double jariJari = bacaDouble("Masukkan jari-jari lingkaran: ");
        final double sudut = bacaDouble("Masukkan sudut pusat juring (derajat, >0 dan <=360): ");
        Runnable tugas = () -> {
            JuringLingkaran juring = new JuringLingkaran(jariJari, sudut);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk " + juring.getNamaBangun() + ":");
            System.out.printf("  Jari-jari: %.2f, Sudut: %.1f deg\n", juring.getJariJari(), juring.getSudutBusurDerajat());
            System.out.printf("  Luas      : %.2f\n", juring.hitungLuas());
            System.out.printf("  Keliling  : %.2f\n", juring.hitungKeliling());
        };
        submitTugasKeExecutor(tugas, "JuringLingkaran");
    }
    private static void handleTemberengLingkaran() {
        System.out.println("\n-- Menghitung Tembereng Lingkaran --");
        final double jariJari = bacaDouble("Masukkan jari-jari lingkaran: ");
        final double sudut = bacaDouble("Masukkan sudut pusat tembereng (derajat, >0 dan <360): ");
        Runnable tugas = () -> {
            TemberengLingkaran tembereng = new TemberengLingkaran(jariJari, sudut);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk " + tembereng.getNamaBangun() + ":");
            System.out.printf("  Jari-jari: %.2f, Sudut: %.1f deg\n", tembereng.getJariJari(), tembereng.getSudutPusatDerajat());
            System.out.printf("  Luas      : %.2f\n", tembereng.hitungLuas());
            System.out.printf("  Keliling  : %.2f\n", tembereng.hitungKeliling());
        };
        submitTugasKeExecutor(tugas, "TemberengLingkaran");
    }


    // --- Handler untuk Benda3D (Semua dengan multithreading) ---
    private static void handleBola() {
        System.out.println("\n-- Menghitung Bola --");
        final double jariJari = bacaDouble("Masukkan jari-jari bola: ");
        Runnable tugas = () -> {
            Bola bola = new Bola(jariJari);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Bola:");
            System.out.printf("  Jari-jari        : %.2f\n", bola.getJariJari());
            System.out.printf("  Volume           : %.2f\n", bola.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", bola.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "Bola");
    }

    private static void handleTabung() {
        System.out.println("\n-- Menghitung Tabung --");
        final double jariJari = bacaDouble("Masukkan jari-jari alas tabung: ");
        final double tinggi = bacaDouble("Masukkan tinggi tabung: ");
        Runnable tugas = () -> {
            Tabung tabung = new Tabung(jariJari, tinggi);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Tabung:");
            System.out.printf("  Jari-jari Alas   : %.2f\n", tabung.getJariJari());
            System.out.printf("  Tinggi           : %.2f\n", tabung.getTinggi());
            System.out.printf("  Volume           : %.2f\n", tabung.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", tabung.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "Tabung");
    }

    private static void handleKerucut() {
        System.out.println("\n-- Menghitung Kerucut --");
        final double jariJari = bacaDouble("Masukkan jari-jari alas kerucut: ");
        final double tinggi = bacaDouble("Masukkan tinggi kerucut: ");
        Runnable tugas = () -> {
            Kerucut kerucut = new Kerucut(jariJari, tinggi);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Kerucut:");
            System.out.printf("  Jari-jari Alas   : %.2f\n", kerucut.getJariJari());
            System.out.printf("  Tinggi           : %.2f\n", kerucut.getTinggi());
            System.out.printf("  Garis Pelukis    : %.2f\n", kerucut.getGarisPelukis());
            System.out.printf("  Volume           : %.2f\n", kerucut.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", kerucut.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "Kerucut");
    }

    private static void handlePrismaPersegi() {
        System.out.println("\n-- Menghitung Prisma Persegi --");
        final double sisiAlas = bacaDouble("Masukkan panjang sisi alas persegi: ");
        final double tinggiPrisma = bacaDouble("Masukkan tinggi prisma: ");
        Runnable tugas = () -> {
            PrismaPersegi pp = new PrismaPersegi(sisiAlas, tinggiPrisma);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Prisma Persegi:");
            System.out.printf("  Sisi Alas        : %.2f\n", pp.getSisi());
            System.out.printf("  Tinggi Prisma    : %.2f\n", pp.getTinggiPrisma());
            System.out.printf("  Volume           : %.2f\n", pp.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", pp.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "PrismaPersegi");
    }

    private static void handlePrismaPersegiPanjang() {
        System.out.println("\n-- Menghitung Prisma Persegi Panjang (Balok) --");
        final double panjang = bacaDouble("Masukkan panjang alas: ");
        final double lebar = bacaDouble("Masukkan lebar alas: ");
        final double tinggiPrisma = bacaDouble("Masukkan tinggi prisma: ");
        Runnable tugas = () -> {
            PrismaPersegiPanjang balok = new PrismaPersegiPanjang(panjang, lebar, tinggiPrisma);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Prisma Persegi Panjang (Balok):");
            System.out.printf("  Panjang Alas     : %.2f\n", balok.getPanjang());
            System.out.printf("  Lebar Alas       : %.2f\n", balok.getLebar());
            System.out.printf("  Tinggi Prisma    : %.2f\n", balok.getTinggiPrisma());
            System.out.printf("  Volume           : %.2f\n", balok.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", balok.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "PrismaPersegiPanjang");
    }

    private static void handlePrismaSegitiga() {
        System.out.println("\n-- Menghitung Prisma Segitiga --");
        System.out.println("Masukkan dimensi alas segitiga:");
        final double sisiA_alas = bacaDouble("  Sisi A (alas untuk luas segitiga): ");
        final double tinggiSegitigaAlas = bacaDouble("  Tinggi alas segitiga (relatif thd Sisi A): ");
        final double sisiB_alas = bacaDouble("  Sisi B: ");
        final double sisiC_alas = bacaDouble("  Sisi C: ");
        final double tinggiPrisma = bacaDouble("Masukkan tinggi prisma: ");
        Runnable tugas = () -> {
            PrismaSegitiga ps = new PrismaSegitiga(sisiA_alas, tinggiSegitigaAlas, sisiA_alas, sisiB_alas, sisiC_alas, tinggiPrisma);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Prisma Segitiga:");
            System.out.printf("  Tinggi Prisma    : %.2f\n", ps.getTinggiPrisma());
            System.out.printf("  Volume           : %.2f\n", ps.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", ps.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "PrismaSegitiga");
    }

    private static void handlePrismaBelahKetupat() {
        System.out.println("\n-- Menghitung Prisma Belah Ketupat --");
        System.out.println("Masukkan dimensi alas belah ketupat:");
        final double d1 = bacaDouble("  Diagonal 1: ");
        final double d2 = bacaDouble("  Diagonal 2: ");
        final double sisi = bacaDouble("  Sisi: ");
        final double tinggiPrisma = bacaDouble("Masukkan tinggi prisma: ");
        Runnable tugas = () -> {
            PrismaBelahKetupat pbk = new PrismaBelahKetupat(d1, d2, sisi, tinggiPrisma);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Prisma Belah Ketupat:");
            System.out.printf("  Tinggi Prisma    : %.2f\n", pbk.getTinggiPrisma());
            System.out.printf("  Volume           : %.2f\n", pbk.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", pbk.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "PrismaBelahKetupat");
    }

    private static void handlePrismaJajarGenjang() {
        System.out.println("\n-- Menghitung Prisma Jajar Genjang --");
        System.out.println("Masukkan dimensi alas jajar genjang:");
        final double alasJG = bacaDouble("  Alas jajar genjang: ");
        final double tinggiJG = bacaDouble("  Tinggi jajar genjang: ");
        final double sisiMiringJG = bacaDouble("  Sisi miring jajar genjang: ");
        final double tinggiPrisma = bacaDouble("Masukkan tinggi prisma: ");
        Runnable tugas = () -> {
            PrismaJajarGenjang pjg = new PrismaJajarGenjang(alasJG, tinggiJG, sisiMiringJG, tinggiPrisma);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Prisma Jajar Genjang:");
            System.out.printf("  Tinggi Prisma    : %.2f\n", pjg.getTinggiPrisma());
            System.out.printf("  Volume           : %.2f\n", pjg.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", pjg.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "PrismaJajarGenjang");
    }

    private static void handlePrismaLayangLayang() {
        System.out.println("\n-- Menghitung Prisma Layang-Layang --");
        System.out.println("Masukkan dimensi alas layang-layang:");
        final double d1 = bacaDouble("  Diagonal 1: ");
        final double d2 = bacaDouble("  Diagonal 2: ");
        final double sisiPendek = bacaDouble("  Sisi Pendek: ");
        final double sisiPanjang = bacaDouble("  Sisi Panjang: ");
        final double tinggiPrisma = bacaDouble("Masukkan tinggi prisma: ");
        Runnable tugas = () -> {
            PrismaLayangLayang pll = new PrismaLayangLayang(d1, d2, sisiPendek, sisiPanjang, tinggiPrisma);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Prisma Layang-Layang:");
            System.out.printf("  Tinggi Prisma    : %.2f\n", pll.getTinggiPrisma());
            System.out.printf("  Volume           : %.2f\n", pll.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", pll.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "PrismaLayangLayang");
    }

    private static void handlePrismaTrapesium() {
        System.out.println("\n-- Menghitung Prisma Trapesium --");
        System.out.println("Masukkan dimensi alas trapesium:");
        final double sisiAtas = bacaDouble("  Sisi Atas: ");
        final double sisiBawah = bacaDouble("  Sisi Bawah: ");
        final double tinggiT = bacaDouble("  Tinggi Trapesium: ");
        final double sisiKiri = bacaDouble("  Sisi Miring Kiri: ");
        final double sisiKanan = bacaDouble("  Sisi Miring Kanan: ");
        final double tinggiPrisma = bacaDouble("Masukkan tinggi prisma: ");
        Runnable tugas = () -> {
            PrismaTrapesium pt = new PrismaTrapesium(sisiAtas, sisiBawah, tinggiT, sisiKiri, sisiKanan, tinggiPrisma);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Prisma Trapesium:");
            System.out.printf("  Tinggi Prisma    : %.2f\n", pt.getTinggiPrisma());
            System.out.printf("  Volume           : %.2f\n", pt.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", pt.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "PrismaTrapesium");
    }

    private static void handleLimasPersegi() {
        System.out.println("\n-- Menghitung Limas Persegi --");
        final double sisiAlas = bacaDouble("Masukkan panjang sisi alas persegi: ");
        final double tinggiLimas = bacaDouble("Masukkan tinggi limas: ");
        Runnable tugas = () -> {
            LimasPersegi limas = new LimasPersegi(sisiAlas, tinggiLimas);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Limas Persegi:");
            System.out.printf("  Sisi Alas        : %.2f\n", limas.getSisi());
            System.out.printf("  Tinggi Limas     : %.2f\n", limas.getTinggiLimas());
            System.out.printf("  Tinggi Sisi Tegak: %.2f\n", limas.hitungTinggiSisiTegak());
            System.out.printf("  Luas Selubung    : %.2f\n", limas.hitungLuasSelubung());
            System.out.printf("  Volume           : %.2f\n", limas.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", limas.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "LimasPersegi");
    }

    private static void handleLimasPersegiPanjang() {
        System.out.println("\n-- Menghitung Limas Persegi Panjang --");
        final double panjangAlas = bacaDouble("Masukkan panjang alas: ");
        final double lebarAlas = bacaDouble("Masukkan lebar alas: ");
        final double tinggiLimas = bacaDouble("Masukkan tinggi limas: ");
        Runnable tugas = () -> {
            LimasPersegiPanjang lpp = new LimasPersegiPanjang(panjangAlas, lebarAlas, tinggiLimas);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Limas Persegi Panjang:");
            System.out.printf("  P Alas           : %.2f\n", lpp.getPanjang());
            System.out.printf("  L Alas           : %.2f\n", lpp.getLebar());
            System.out.printf("  T Limas          : %.2f\n", lpp.getTinggiLimas());
            System.out.printf("  Luas Selubung    : %.2f\n", lpp.hitungLuasSelubung());
            System.out.printf("  Volume           : %.2f\n", lpp.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", lpp.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "LimasPersegiPanjang");
    }

    private static void handleLimasSegitiga() {
        System.out.println("\n-- Menghitung Limas Segitiga --");
        System.out.println("Masukkan dimensi alas segitiga:");
        final double sisiA_alas = bacaDouble("  Sisi A (alas untuk luas segitiga): ");
        final double tinggiSegitigaAlas = bacaDouble("  Tinggi alas segitiga (relatif thd Sisi A): ");
        final double sisiB_alas = bacaDouble("  Sisi B: ");
        final double sisiC_alas = bacaDouble("  Sisi C: ");
        final double tinggiLimas = bacaDouble("Masukkan tinggi limas: ");
        System.out.println("Untuk Luas Permukaan Limas Segitiga Umum, butuh tinggi tiap sisi tegak:");
        final double tsA = bacaDouble("  Tinggi sisi tegak pada alas sisi A: ");
        final double tsB = bacaDouble("  Tinggi sisi tegak pada alas sisi B: ");
        final double tsC = bacaDouble("  Tinggi sisi tegak pada alas sisi C: ");
        Runnable tugas = () -> {
            LimasSegitiga ls = new LimasSegitiga(sisiA_alas, tinggiSegitigaAlas, sisiA_alas, sisiB_alas, sisiC_alas, tinggiLimas);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Limas Segitiga:");
            System.out.printf("  T Limas          : %.2f\n", ls.getTinggiLimas());
            System.out.printf("  Volume           : %.2f\n", ls.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", ls.hitungLuasPermukaan(tsA, tsB, tsC));
        };
        submitTugasKeExecutor(tugas, "LimasSegitiga");
    }

    private static void handleLimasBelahKetupat() {
        System.out.println("\n-- Menghitung Limas Belah Ketupat --");
        System.out.println("Masukkan dimensi alas belah ketupat:");
        final double d1 = bacaDouble("  Diagonal 1: ");
        final double d2 = bacaDouble("  Diagonal 2: ");
        final double sisi = bacaDouble("  Sisi: ");
        final double tinggiLimas = bacaDouble("Masukkan tinggi limas: ");
        Runnable tugas = () -> {
            LimasBelahKetupat lbk = new LimasBelahKetupat(d1, d2, sisi, tinggiLimas);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Limas Belah Ketupat:");
            System.out.printf("  T Limas          : %.2f\n", lbk.getTinggiLimas());
            System.out.printf("  T Sisi Tegak     : %.2f\n", lbk.hitungTinggiSisiTegak());
            System.out.printf("  Luas Selubung    : %.2f\n", lbk.hitungLuasSelubung());
            System.out.printf("  Volume           : %.2f\n", lbk.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", lbk.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "LimasBelahKetupat");
    }

    private static void handleLimasJajarGenjang() {
        System.out.println("\n-- Menghitung Limas Jajar Genjang --");
        System.out.println("Masukkan dimensi alas jajar genjang:");
        final double alasJG = bacaDouble("  Alas jajar genjang: ");
        final double tinggiJG = bacaDouble("  Tinggi jajar genjang: ");
        final double sisiMiringJG = bacaDouble("  Sisi miring jajar genjang: ");
        final double tinggiLimas = bacaDouble("Masukkan tinggi limas: ");
        System.out.println("Untuk Luas Permukaan Limas Jajar Genjang Umum, butuh tinggi tiap sisi tegak:");
        final double tsAlas = bacaDouble("  Tinggi sisi tegak pada sisi alas (" + alasJG + "): ");
        final double tsSisiMiring = bacaDouble("  Tinggi sisi tegak pada sisi miring (" + sisiMiringJG + "): ");
        Runnable tugas = () -> {
            LimasJajarGenjang ljg = new LimasJajarGenjang(alasJG, tinggiJG, sisiMiringJG, tinggiLimas);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Limas Jajar Genjang:");
            System.out.printf("  T Limas          : %.2f\n", ljg.getTinggiLimas());
            System.out.printf("  Volume           : %.2f\n", ljg.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", ljg.hitungLuasPermukaan(tsAlas, tsSisiMiring));
        };
        submitTugasKeExecutor(tugas, "LimasJajarGenjang");
    }

    private static void handleLimasLayangLayang() {
        System.out.println("\n-- Menghitung Limas Layang-Layang --");
        System.out.println("Masukkan dimensi alas layang-layang:");
        final double d1 = bacaDouble("  Diagonal 1: ");
        final double d2 = bacaDouble("  Diagonal 2: ");
        final double sisiPendek = bacaDouble("  Sisi Pendek: ");
        final double sisiPanjang = bacaDouble("  Sisi Panjang: ");
        final double tinggiLimas = bacaDouble("Masukkan tinggi limas: ");
        System.out.println("Untuk Luas Permukaan Limas Layang-Layang Umum, butuh tinggi tiap sisi tegak:");
        final double tsSisiPendek = bacaDouble("  Tinggi sisi tegak pada sisi pendek ("+sisiPendek+"): ");
        final double tsSisiPanjang = bacaDouble("  Tinggi sisi tegak pada sisi panjang ("+sisiPanjang+"): ");
        Runnable tugas = () -> {
            LimasLayangLayang lll = new LimasLayangLayang(d1, d2, sisiPendek, sisiPanjang, tinggiLimas);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Limas Layang-Layang:");
            System.out.printf("  T Limas          : %.2f\n", lll.getTinggiLimas());
            System.out.printf("  Volume           : %.2f\n", lll.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", lll.hitungLuasPermukaan(tsSisiPendek, tsSisiPanjang));
        };
        submitTugasKeExecutor(tugas, "LimasLayangLayang");
    }

    private static void handleLimasTrapesium() {
        System.out.println("\n-- Menghitung Limas Trapesium --");
        System.out.println("Masukkan dimensi alas trapesium:");
        final double sisiAtas = bacaDouble("  Sisi Atas: ");
        final double sisiBawah = bacaDouble("  Sisi Bawah: ");
        final double tinggiT = bacaDouble("  Tinggi Trapesium: ");
        final double sisiKiri = bacaDouble("  Sisi Miring Kiri: ");
        final double sisiKanan = bacaDouble("  Sisi Miring Kanan: ");
        final double tinggiLimas = bacaDouble("Masukkan tinggi limas: ");
        System.out.println("Untuk Luas Permukaan Limas Trapesium Umum, butuh tinggi tiap sisi tegak:");
        final double tsAtas = bacaDouble("  Tinggi sisi tegak pada sisi atas ("+sisiAtas+"): ");
        final double tsBawah = bacaDouble("  Tinggi sisi tegak pada sisi bawah ("+sisiBawah+"): ");
        final double tsKiri = bacaDouble("  Tinggi sisi tegak pada sisi kiri ("+sisiKiri+"): ");
        final double tsKanan = bacaDouble("  Tinggi sisi tegak pada sisi kanan ("+sisiKanan+"): ");
        Runnable tugas = () -> {
            LimasTrapesium lt = new LimasTrapesium(sisiAtas, sisiBawah, tinggiT, sisiKiri, sisiKanan, tinggiLimas);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Limas Trapesium:");
            System.out.printf("  T Limas          : %.2f\n", lt.getTinggiLimas());
            System.out.printf("  Volume           : %.2f\n", lt.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", lt.hitungLuasPermukaan(tsAtas, tsBawah, tsKiri, tsKanan));
        };
        submitTugasKeExecutor(tugas, "LimasTrapesium");
    }

    private static void handleKerucutTerpancung() {
        System.out.println("\n-- Menghitung Kerucut Terpancung --");
        final double rBawah = bacaDouble("Masukkan jari-jari alas bawah (R): ");
        final double rAtas = bacaDouble("Masukkan jari-jari alas atas (r < R): ");
        final double tinggi = bacaDouble("Masukkan tinggi kerucut terpancung: ");
        Runnable tugas = () -> {
            KerucutTerpancung kt = new KerucutTerpancung(rBawah, rAtas, tinggi);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Kerucut Terpancung:");
            System.out.printf("  R Bawah          : %.2f\n", kt.getJariJari()); // Dari superclass
            System.out.printf("  r Atas           : %.2f\n", kt.getJariJariAtas());
            System.out.printf("  Tinggi Frustum   : %.2f\n", kt.getTinggiFrustum());
            System.out.printf("  Garis Pelukis    : %.2f\n", kt.getGarisPelukisFrustum());
            System.out.printf("  Volume           : %.2f\n", kt.hitungVolume());
            System.out.printf("  Luas Permukaan   : %.2f\n", kt.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "KerucutTerpancung");
    }

    private static void handleTemberengBola() {
        System.out.println("\n-- Menghitung Tembereng Bola --");
        final double rBola = bacaDouble("Masukkan jari-jari bola (R): ");
        final double tinggiTembereng = bacaDouble("Masukkan tinggi tembereng (h <= 2R): ");
        Runnable tugas = () -> {
            TemberengBola tb = new TemberengBola(rBola, tinggiTembereng);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Tembereng Bola:");
            System.out.printf("  R Bola                : %.2f\n", tb.getJariJari());
            System.out.printf("  h Tembereng           : %.2f\n", tb.getTinggiTembereng());
            System.out.printf("  r Alas Tembereng      : %.2f\n", tb.getJariJariAlasTembereng());
            System.out.printf("  Volume                : %.2f\n", tb.hitungVolume());
            System.out.printf("  Luas Permukaan Lengkung: %.2f\n", tb.hitungLuasPermukaanLengkung());
            System.out.printf("  Total Luas Permukaan  : %.2f\n", tb.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "TemberengBola");
    }

    private static void handleCincinBola() {
        System.out.println("\n-- Menghitung Cincin Bola (Spherical Zone) --");
        final double rBola = bacaDouble("Masukkan jari-jari bola (R): ");
        final double tinggiCincin = bacaDouble("Masukkan tinggi cincin/zone (h <= 2R): ");
        final double rAlas1 = bacaDoubleNonNegatif("Masukkan jari-jari alas 1 (r1 <= R, bisa 0): ");
        final double rAlas2 = bacaDoubleNonNegatif("Masukkan jari-jari alas 2 (r2 <= R, bisa 0): ");
        Runnable tugas = () -> {
            CincinBola cb = new CincinBola(rBola, tinggiCincin, rAlas1, rAlas2);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Cincin Bola:");
            System.out.printf("  R Bola                : %.2f\n", cb.getJariJari());
            System.out.printf("  h Cincin              : %.2f\n", cb.getTinggiCincin());
            System.out.printf("  r Alas 1              : %.2f\n", cb.getJariJariAlas1());
            System.out.printf("  r Alas 2              : %.2f\n", cb.getJariJariAlas2());
            System.out.printf("  Volume                : %.2f\n", cb.hitungVolume());
            System.out.printf("  Luas Permukaan Lengkung: %.2f\n", cb.hitungLuasPermukaanLengkung());
            System.out.printf("  Total Luas Permukaan  : %.2f\n", cb.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "CincinBola");
    }

    private static void handleJuringBola() {
        System.out.println("\n-- Menghitung Juring Bola (Spherical Sector) --");
        final double rBola = bacaDouble("Masukkan jari-jari bola (R): ");
        final double tinggiTemberengDasar = bacaDouble("Masukkan tinggi tembereng dasar (h <= 2R): ");
        Runnable tugas = () -> {
            JuringBola jb = new JuringBola(rBola, tinggiTemberengDasar);
            System.out.println("\nThread [" + Thread.currentThread().getName() + "] hasil untuk Juring Bola:");
            System.out.printf("  R Bola                : %.2f\n", jb.getJariJari());
            System.out.printf("  h Tembereng Dasar     : %.2f\n", jb.getTinggiTemberengDasar());
            System.out.printf("  r Alas Tembereng Dasar: %.2f\n", jb.getJariJariAlasTembereng());
            System.out.printf("  Volume                : %.2f\n", jb.hitungVolume());
            System.out.printf("  Luas Permukaan        : %.2f\n", jb.hitungLuasPermukaan());
        };
        submitTugasKeExecutor(tugas, "JuringBola");
    }
}