package Simplilearn_CoreJava_FileManagement;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        showMainMenu();


    }

    private static void showMainMenu() {
        System.out.println("\n ------Main Menu------");
        System.out.println("\n Select your option:");
        System.out.println("\n 1.List files in your location");
        System.out.println("\n 2.File Operations");
        System.out.println("\n 3.Exit Program");
    }

    private static void showOperationsMenu(){
        System.out.println("\n Select your options:");
        System.out.println("\n 1.Add a new file");
        System.out.println("\n 2.Delete a file");
        System.out.println("\n 3.Search for a file");
        System.out.println("\n 3.Exit to Main Menu");}


}