import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Username dan password yang benar
        String usernameBenar = "adrizal";
        String passwordBenar = "021240085";

        // Input dari user
        System.out.print("Masukkan Username: ");
        String username = input.nextLine();

        System.out.print("Masukkan Password: ");
        String password = input.nextLine();

        // Proses pengecekan
        if (username.equals(usernameBenar) && password.equals(passwordBenar)) {
            System.out.println("Login berhasil! ");
        } else {
            System.out.println("Username atau password salah.");
        }
    }
}