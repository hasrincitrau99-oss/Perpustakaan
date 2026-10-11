import java.util.Scanner;

// ==========================================
// 1. CLASS NODE (Merepresentasikan Data Buku)
// ==========================================
class Node {
    String kodeBuku;
    String judul;
    String penulis;
    Node next;

    // Konstruktor untuk inisialisasi data buku
    public Node(String kodeBuku, String judul, String penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
        this.next = null;
    }
}

// ==========================================
// 2. CLASS LINKEDLIST (Operasi Struktur Data)
// ==========================================
class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Operasi 1: Tambah Buku (Push) di akhir daftar
    public void tambahBuku(Scanner scanner) {
        System.out.print("\nMasukkan Kode Buku: ");
        String kode = scanner.nextLine();

        // Validasi: kodeBuku maksimal 5 karakter
        if (kode.length() > 5) {
            System.out.println("Validasi Gagal: Kode buku maksimal 5 karakter!");
            return;
        }

        System.out.print("Masukkan Judul: ");
        String judul = scanner.nextLine();

        System.out.print("Masukkan Penulis: ");
        String penulis = scanner.nextLine();

        Node newNode = new Node(kode, judul, penulis);

        // Jika linked list masih kosong, node baru menjadi head
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        System.out.println("Data berhasil ditambahkan!");
    }

    // Operasi 2: Hapus Buku (Pop) dari akhir daftar
    public void hapusBuku() {
        // Jika list kosong
        if (head == null) {
            System.out.println("\nTidak ada data untuk dihapus.");
            return;
        }

        // Jika hanya ada 1 node dalam list
        if (head.next == null) {
            head = null;
            System.out.println("\nData buku terakhir berhasil dihapus.");
            return;
        }

        // Traversal untuk mencari node sebelum terakhir
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        System.out.println("\nData buku terakhir berhasil dihapus.");
    }

    // Operasi 3: Cari Buku berdasarkan kodeBuku
    public void cariBuku(Scanner scanner) {
        if (head == null) {
            System.out.println("\nDaftar buku kosong.");
            return;
        }

        System.out.print("\nMasukkan Kode Buku yang dicari: ");
        String kode = scanner.nextLine();

        Node temp = head;
        boolean ditemukan = false;

        while (temp != null) {
            if (temp.kodeBuku.equalsIgnoreCase(kode)) {
                System.out.println("\nBuku Ditemukan:");
                System.out.println("Kode: " + temp.kodeBuku + " | Judul: " + temp.judul + " | Penulis: " + temp.penulis);
                ditemukan = true;
                break;
            }
            temp = temp.next;
        }

        if (!ditemukan) {
            System.out.println("\nBuku tidak ditemukan.");
        }
    }

    // Operasi 4: Tampilkan Semua Buku beserta totalnya
    public void tampilkanSemuaBuku() {
        System.out.println("\nDaftar Buku:");
        if (head == null) {
            System.out.println("Total Buku: 0");
            return;
        }

        Node temp = head;
        int total = 0;

        while (temp != null) {
            System.out.println("Kode: " + temp.kodeBuku + " | Judul: " + temp.judul + " | Penulis: " + temp.penulis);
            total++;
            temp = temp.next;
        }
        System.out.println("Total Buku: " + total);
    }
}

// ==========================================
// 3. CLASS UTAMA (Pengujian di main())
// ==========================================
public class Perpustakaan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList daftarPerpustakaan = new LinkedList();
        int pilihan = 0;

        // Menu perulangan interaktif untuk menguji semua operasi
        do {
            System.out.println("\n===== SISTEM DATA BUKU =====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Hapus Buku");
            System.out.println("3. Cari Buku");
            System.out.println("4. Lihat Semua Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            if (scanner.hasNextInt()) {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Membersihkan buffer newline
            } else {
                System.out.println("\nInput tidak valid. Masukkan angka pilihan menu.");
                scanner.next();
                continue;
            }

            switch (pilihan) {
                case 1:
                    daftarPerpustakaan.tambahBuku(scanner);
                    break;
                case 2:
                    daftarPerpustakaan.hapusBuku();
                    break;
                case 3:
                    daftarPerpustakaan.cariBuku(scanner);
                    break;
                case 4:
                    daftarPerpustakaan.tampilkanSemuaBuku();
                    break;
                case 5:
                    System.out.println("\nKeluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("\nPilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}