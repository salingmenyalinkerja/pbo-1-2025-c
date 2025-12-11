package docurepo.view;

import docurepo.controller.DocumentListingController;
import docurepo.controller.DocumentSearchController;
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
        String input1;
        String input2;
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
                        input1 = sc.nextLine();
                        System.out.print("Enter filename: ");
                        input2 = sc.nextLine();

                        response = DocumentStorageController.CreateDocument(input1, input2);
                        break;
                    case 2:
                        System.out.print("Enter filename to be deleted: ");
                        input1 = sc.nextLine();

                        response = DocumentStorageController.DeleteDocument(input1);
                        break;
                    case 3:
                        System.out.print("Enter filename to be changed: ");
                        input1 = sc.nextLine();
                        System.out.print("Enter the version number: ");
                        input2 = sc.nextLine();

                        response = DocumentStorageController.CreateDocument(
                            DocumentVersioningController.GetDocumentOfAVersion(
                                input1, input2
                            )
                        );
                        break;
                    case 4:
                        DocumentListingController.ListFiles();
                        response = "";
                        break;
                    case 5:
                        System.out.print("Enter keyword: ");
                        input1 = sc.nextLine();

                        DocumentSearchController.SearchFiles(input1);
                        response = "";
                        break;
                    default:
                        response = "Invalid command or input";
                        break;
                }
                if (command > -1)
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
        if (input.equals("change"))
            return 3;
        if (input.equals("list"))
            return 4;
        if (input.equals("search"))
            return 5;
        return 0;
    }

    private static void ClearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}