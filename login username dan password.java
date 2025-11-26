import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String correctUsername = "geriansa";
        String correctPassword = "021240107";

        System.out.print("Masukkan Username: ");
        String username = input.nextLine();

        System.out.print("Masukkan Password: ");
        String password = input.nextLine();

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            System.out.println("Login berhasil! Selamat datang, " + username + "!");
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }

        input.close();
    }
}
