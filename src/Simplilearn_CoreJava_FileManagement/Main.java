package Simplilearn_CoreJava_FileManagement;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    File workingFolder;

    public static void main(String[] args) throws Exception {

        boolean quitProgram = false;
        int choice1 = 0;

        while (!quitProgram){
            initiatingMenu();
            choice1 = scanner.nextInt();

            switch (choice1) {
                case 1 -> folderSelection();
                case 2 -> quitProgram = true;
            }
        }


    }

    private static File folderSelection() throws Exception {

        File fileLocation;

        System.out.println("Please, type the location for your files");
        fileLocation = new File(scanner.next());

        if(fileLocation.exists()){
            showMainMenu();
        } else {
            System.out.println("Location does not exist. Make sure the location exists in your computer.");
        }

        return fileLocation;

    }

    private static void initiatingMenu(){
        System.out.println("------LockedMe.com------");
        System.out.println("Enter your choice:");
        System.out.println("1.Input folder location:");
        System.out.println("2.Exit Program:");
    }


    private static void showMainMenu() {

        boolean quitMain = false;
        int choice2 = 0;

        System.out.println("\n ------Main Menu------");
        System.out.println("\n Select your option:");
        System.out.println("\n 1.List files in your location");
        System.out.println("\n 2.File Operations");
        System.out.println("\n 3.Exit Program");

        switch (choice2){
            case 1 -> listFiles();
            case 2 -> showOperationsMenu();
            case 3 -> quitMain = true;
        }

    }

    private static void showOperationsMenu(){

        System.out.println("\n Select your options:");
        System.out.println("\n 1.Add a new file");
        System.out.println("\n 2.Delete a file");
        System.out.println("\n 3.Search for a file");
        System.out.println("\n 3.Exit to Main Menu");
    }


}