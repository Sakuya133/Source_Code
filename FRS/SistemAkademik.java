import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Ida Bagus Gde Dimas Sutha Maha
 */
public class SistemAkademik {
    private static ArrayList<Mahasiswa> listMahasiswa = new ArrayList<>();
    private static ArrayList<Dosen> listDosen = new ArrayList<>();
    private static ArrayList<MataKuliah> listMataKuliah = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        siapkanDataAwal();

        boolean jalan = true;
        while (jalan) {
            tampilkanMenuUtama();
            int pilihan = input.nextInt();
            input.nextLine(); 

            switch (pilihan) {
                case 1 -> menuRegistrasiMahasiswa();
                case 2 -> menuTampilkanMataKuliah();
                case 3 -> menuTampilkanDosen();
                case 4 -> menuIsiKrs();
                case 5 -> menuLihatKrs();
                case 6 -> {
                    jalan = false;
                    System.out.println("Sampai Jumpa di pemilihan berikutnya :D");
                }
                default -> System.out.println("Silahkan coba lagi");
            }

            if (jalan) {
                System.out.print("\nTekan Enter untuk kembali ke menu utama...");
                input.nextLine();
            }
        }
        input.close();
    }

    public static void tampilkanMenuUtama() {
        System.out.println("\n=== SISTEM FRS - INFORMATIKA ===");
        System.out.println("1. Registrasi Mahasiswa Baru");
        System.out.println("2. Lihat Mata Kuliah");
        System.out.println("3. Lihat Dosen");
        System.out.println("4. Ambil Mata Kuliah");
        System.out.println("5. Tampilkan KRS Mahasiswa");
        System.out.println("6. Keluar");
        System.out.print("Pilih menu [1-6]: ");
    }
    
    public static void siapkanDataAwal() {
    
    Dosen d1 = new Dosen("Ir. Arya Yudhi Wijaya, S.Kom., M.Kom.", "2009121001");
    Dosen d2 = new Dosen("Imam Mustafa Kamal, S.ST., Ph.D.", "2010122002");
    Dosen d3 = new Dosen("Fajar Baskoro, S.Kom., M.T.", "2012122002");
    Dosen d4 = new Dosen("Royyana Muslim Ijtihadie, S.Kom., M.Kom., Ph.D.", "2008101003");
    Dosen d5 = new Dosen("Dr. Sarwosri, S.Kom., M.T.", "2006042001");
    Dosen d6 = new Dosen("Ir. Misbakhul Munir Irfan Subakti, S.Kom., M.Sc., M.Phil.", "2010121001");
    Dosen d7 = new Dosen("Ilham Gurat Adillion, S.Kom., M.Kom.", "2015041004");

    listDosen.add(d1);
    listDosen.add(d2);
    listDosen.add(d3);
    listDosen.add(d4);
    listDosen.add(d5);
    listDosen.add(d6);
    listDosen.add(d7);

   
    listMataKuliah.add(new MataKuliah("EF234304", "Teori Graf", 3, d1));
    listMataKuliah.add(new MataKuliah("EK234201", "Konsep Kecerdasan Artifisial", 3, d2));
    listMataKuliah.add(new MataKuliah("EF234302", "Pemrograman Berorientasi Objek", 3, d3));
    listMataKuliah.add(new MataKuliah("EF234303", "Jaringan Komputer", 4, d4));
    listMataKuliah.add(new MataKuliah("EF234307", "Konsep Pengembangan Perangkat Lunak", 2, d5));
    listMataKuliah.add(new MataKuliah("EF234301", "Pemrograman Web", 3, d6));
    listMataKuliah.add(new MataKuliah("EF234305", "Matematika Diskrit", 3, d7));
        
        listMahasiswa.add(new Mahasiswa("Ida Bagus Gde Dimas Sutha Maha", "5025241218"));
        
    }

    public static void menuRegistrasiMahasiswa() {
        System.out.println("\n=== Registrasi Mahasiswa Baru ===");
        System.out.print("Nama Mahasiswa : ");
        String nama = input.nextLine();
        System.out.print("NRP Mahasiswa  : ");
        String nim = input.nextLine();

        listMahasiswa.add(new Mahasiswa(nama, nim));
        System.out.println("==> Mahasiswa " + nama + " berhasil ditambahkan.");
    }

    public static void menuTampilkanMataKuliah() {
        System.out.println("\n=== Daftar Mata Kuliah ===");
        System.out.println("===============================================================================================");
        System.out.println("| Kode MK  | Nama Mata Kuliah                    |SKS| Dosen Pengampu       |");
        System.out.println("===============================================================================================");
        for (MataKuliah mk : listMataKuliah) {
            System.out.printf("| %-8s | %-35s | %d | %-20s |\n", 
                              mk.getKode(), mk.getNama(), mk.getJumlahSks(), mk.getPengampu().getName());
        }
        System.out.println("===============================================================================================");
    }

    public static void menuTampilkanDosen() {
        System.out.println("\n=== Daftar Dosen ===");
        int nomor = 1;
        for (Dosen d : listDosen) {
            System.out.println(nomor + ". " + d);
            nomor++;
        }
    }
    
    public static void menuIsiKrs() {
        System.out.println("\n=== Pengisian FRS ===");
        System.out.print("Masukkan NRP: ");
        String nim = input.nextLine();

        Mahasiswa mhs = null;
        for (Mahasiswa m : listMahasiswa) {
            if (m.getNim().equals(nim)) {
                mhs = m;
                break;
            }
        }
        
        if (mhs == null) {
            System.out.println("==> Mahasiswa dengan NRP " + nim + " tidak ditemukan.");
            return;
        }

        System.out.println("Nama: " + mhs.getNamaLengkap());
        menuTampilkanMataKuliah(); 
        
        System.out.print("Masukkan kode Mata Kuliah yang dipilih: ");
        String kodeMk = input.nextLine();
        
        MataKuliah mkDipilih = null;
        for (MataKuliah mk : listMataKuliah) {
            if (mk.getKode().equalsIgnoreCase(kodeMk)) {
                mkDipilih = mk;
                break;
            }
        }

        if (mkDipilih == null) {
            System.out.println("==> Mata kuliah dengan kode " + kodeMk + " tidak ditemukan.");
            return;
        }
        
        mhs.daftarMataKuliah(mkDipilih);
    }

    public static void menuLihatKrs() {
        System.out.println("\n=== Tampilkan FRS ===");
        System.out.print("Masukkan NRP  ");
        String nim = input.nextLine();
        
        Mahasiswa mhs = null;
        for (Mahasiswa m : listMahasiswa) {
            if (m.getNim().equals(nim)) {
                mhs = m;
                break;
            }
        }
        
        if (mhs != null) {
            mhs.cetakKrs();
        } else {
            System.out.println("==> Data mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }
}
