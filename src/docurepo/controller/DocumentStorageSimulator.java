import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DocumentStorageSimulator {

    // Penyimpanan dalam memori (tanpa file system)
    private static Map<String, String> storage = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Document Storage Simulator (Memory Mode) ===");
            System.out.println("1. Upload file");
            System.out.println("2. Download file");
            System.out.println("3. View file");
            System.out.println("4. Delete file");
            System.out.println("5. Exit");
            System.out.print("Pilih menu: ");

            int menu = scanner.nextInt();
            scanner.nextLine();  

            switch (menu) {
                case 1:
                    System.out.print("Masukkan nama file: ");
                    String uploadName = scanner.nextLine();
                    uploadFile(uploadName);
                    break;

                case 2:
                    System.out.print("Nama file yg ingin di-download: ");
                    String downloadName = scanner.nextLine();
                    downloadFile(downloadName);
                    break;

                case 3:
                    System.out.print("Nama file yg ingin dilihat: ");
                    String viewName = scanner.nextLine();
                    viewFile(viewName);
                    break;

                case 4:
                    System.out.print("Nama file yg ingin dihapus: ");
                    String deleteName = scanner.nextLine();
                    deleteFile(deleteName);
                    break;

                case 5:
                    System.out.println("Keluar program.");
                    return;

                default:
                    System.out.println("Menu tidak valid.");
            }
        }
    }

    // ====================== FUNCTIONS ============================ //

    public static void uploadFile(String fileName) {
        storage.put(fileName, "Isi file simulasi: " + fileName);
        System.out.println("Upload berhasil: " + fileName);
    }

    public static void downloadFile(String fileName) {
        if (storage.containsKey(fileName)) {
            System.out.println("File ditemukan. Isi:");
            System.out.println(storage.get(fileName));
        } else {
            System.out.println("File tidak ditemukan.");
        }
    }

    public static void viewFile(String fileName) {
        downloadFile(fileName);
    }

    public static void deleteFile(String fileName) {
        if (storage.containsKey(fileName)) {
            storage.remove(fileName);
            System.out.println("File berhasil dihapus: " + fileName);
        } else {
            System.out.println("File tidak ditemukan.");
        }
    }
}
