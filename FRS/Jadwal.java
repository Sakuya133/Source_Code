import java.util.ArrayList;

/**
 * @author Ida Bagus Gde Dimas Sutha Maha
 */
public class Jadwal {
    private ArrayList<MataKuliah> daftarMataKuliah;
    private int maksSKS;
    private int totalSKS;

    public Jadwal(int maksSKS) {
        this.maksSKS = maksSKS;
        this.totalSKS = 0;
        this.daftarMataKuliah = new ArrayList<>();
    }

    public boolean tambahMataKuliah(MataKuliah mk) {
        if ((totalSKS + mk.getJumlahSks()) <= maksSKS) {
            daftarMataKuliah.add(mk);
            totalSKS += mk.getJumlahSks();
            return true;
        } else {
            System.out.println("Gagal menambahkan " + mk.getNama() + " (melebihi batas SKS)");
            return false;
        }
    }

    public void tampilkanJadwal() {
        System.out.println("=== Daftar Mata Kuliah yang Diambil ===");
        if (daftarMataKuliah.isEmpty()) {
            System.out.println("Belum ada mata kuliah yang dipilih.");
        } else {
            for (MataKuliah mk : daftarMataKuliah) {
                System.out.println(mk); 
            }
        }
        System.out.println("Total SKS: " + totalSKS + " / " + maksSKS);
        System.out.println("=======================================");
    }
}
