import java.util.ArrayList;

/**
 *  @author Ida Bagus Gde Dimas Sutha Maha
 * 
 */
public class Mahasiswa {
    private String namaLengkap;
    private String nim;
    private ArrayList<MataKuliah> mkTerdaftar;

    public Mahasiswa(String namaLengkap, String nim) {
        this.namaLengkap = namaLengkap;
        this.nim = nim;
        this.mkTerdaftar = new ArrayList<>();
    }

    public String getNamaLengkap() { return namaLengkap; }
    public String getNim() { return nim; }

    public void daftarMataKuliah(MataKuliah mk) {
        if (!mkTerdaftar.contains(mk)) {
            mkTerdaftar.add(mk);
            mk.daftarkanMahasiswa(this); 
            System.out.println("==> " + namaLengkap + " berhasil mendaftar " + mk.getNama());
        } else {
            System.out.println("==> Gagal " + mk.getNama() + " sudah ada di FRS.");
        }
    }

    public void cetakKrs() {
        System.out.println("\n========= Formulir RENCANA STUDI =========");
        System.out.println("Nama Mahasiswa : " + namaLengkap);
        System.out.println("NRP            : " + nim);
        System.out.println("============================================");
        if (mkTerdaftar.isEmpty()) {
            System.out.println("Belum ada mata kuliah");
        } else {
            int totalSks = 0;
            System.out.println("======================================================");
            System.out.println("| Kode   | Nama Mata Kuliah                    | SKS |");
            System.out.println("======================================================");
            for (MataKuliah mk : mkTerdaftar) {
                System.out.printf("| %-6s | %-35s | %3d |\n", 
                                  mk.getKode(), mk.getNama(), mk.getJumlahSks());
                totalSks += mk.getJumlahSks();
            }
            System.out.println("=====================================================");
            System.out.println("TOTAL SKS : " + totalSks);
        }
        System.out.println("========================================");
    }
}
