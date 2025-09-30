import java.util.ArrayList;

/**
 * 
 * @author Ida Bagus Gde Dimas Sutha Maha
 */
public class MataKuliah {
    private String kode;
    private String nama;
    private int jumlahSks;
    private Dosen pengampu;
    private ArrayList<Mahasiswa> pesertaKelas;

    public MataKuliah(String kode, String nama, int jumlahSks, Dosen pengampu) {
        this.kode = kode;
        this.nama = nama;
        this.jumlahSks = jumlahSks;
        this.pengampu = pengampu;
        this.pesertaKelas = new ArrayList<>();
    }

    public void daftarkanMahasiswa(Mahasiswa mhs) {
        pesertaKelas.add(mhs);
    }
    
    public String getKode() { return kode; }
    public String getNama() { return nama; }
    public int getJumlahSks() { return jumlahSks; }
    public Dosen getPengampu() { return pengampu; }

    @Override
    public String toString() {
        return String.format("[ %s ] %s (%d SKS) - Dosen: %s", 
                             kode, nama, jumlahSks, pengampu.getName());
    }
}
