package docurepo.view;

import docurepo.controller.DocumentStorageController;
import docurepo.controller.DocumentVersioningController;
import docurepo.controller.UserController;
import java.util.Scanner;

public class CommandLineInterface {
    public static void Run(){
        if (!DocumentVersioningController.Init()) {
            System.out.println("An error has occurred regarding metadata.data");
            return;
        }
        
        ClearScreen();
        System.out.println("SELAMAT DATANG PADA APLIKASI DOCUREPO!\n");

        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        boolean login = false;
        String path;
        String filename;
        String response = "";
        while (!exit) {
            
            if (!login) {
                System.out.print("Username: ");
                String username = sc.nextLine();

                System.out.print("Password: ");
                String password = sc.nextLine();

                login = UserController.IsUserValid(username, password);
                if (login)
                    ClearScreen();
            } else {
                System.out.print("<DOCUREPO> ");
                int command = GetCommand(sc);
                switch(command){
                    case -1:
                        exit = true;
                        break;
                    case 1:
                        System.out.print("Enter document path: ");
                        path = sc.nextLine();
                        System.out.print("Enter filename: ");
                        filename = sc.nextLine();

                        response = DocumentStorageController.CreateDocument(path, filename);
                        break;
                    case 2:
                        System.out.print("Enter filename to be deleted: ");
                        filename = sc.nextLine();

                        response = DocumentStorageController.DeleteDocument(filename);
                        break;
                    default:
                        response = "Invalid command or input";
                        break;
                }
                if (command > 0)
                    System.out.println(response);
            }
        }
    }

    private static int GetCommand(Scanner sc){
        String input = sc.nextLine();
        if (input.equals("exit"))
            return -1;
        if (input.equals("add"))
            return 1;
        if (input.equals("delete"))
            return 2;
        return 0;
    }

    private static void ClearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}