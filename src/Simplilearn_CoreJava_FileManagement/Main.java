package Simplilearn_CoreJava_FileManagement;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    //Properties
    private static Scanner scanner = new Scanner(System.in);
    private static FileManager fileManager = new FileManager();



    public static void main(String[] args) throws Exception {

        //Main method controllers
        boolean quitProgram = false;
        int choice1;
        String userInput;

        while (!quitProgram){
            initiatingMenu();

            userInput = scanner.nextLine();

            //Input verification
            while (containsString(userInput)){
                wrongOptionMessage();
                initiatingMenu();
                userInput = scanner.nextLine();
            }

            choice1 = Integer.parseInt(userInput);

            //Menu logic
            switch (choice1) {
                case 1 -> folderSelection();
                case 2 -> quitProgram = true;
                default -> wrongOptionMessage();
            }
        }
    }

    //Menus functionality
    private static void showMainMenu() throws Exception{

        boolean quitToInitiating = false;
        String userInput2;
        int choice2 = 0;

        while (!quitToInitiating){
            mainMenu();

            userInput2 = scanner.nextLine();

            while (containsString(userInput2)){
                wrongOptionMessage();
                mainMenu();
                userInput2 = scanner.nextLine();
            }

            choice2 = Integer.parseInt(userInput2);

            switch (choice2) {
                case 1 -> fileManager.listFiles();
                case 2 -> showOperationsMenu();
                case 3 -> quitToInitiating = true;
                default -> wrongOptionMessage();
            }
        }
    }

    private static void showOperationsMenu() throws IOException {

        boolean quitToMain = false;
        String userInput3;
        int choice3 = 0;

        while (!quitToMain){
            opsMenu();

            userInput3 = scanner.nextLine();
            while (containsString(userInput3)){
                wrongOptionMessage();
                opsMenu();
                userInput3 = scanner.nextLine();
            }

            choice3 = Integer.parseInt(userInput3);

            switch (choice3){
                case 1 -> addFile();
                case 2 -> deleteFile();
                case 3 -> searchFile();
                case 4 -> quitToMain = true;
                default -> wrongOptionMessage();
            }
        }
    }





    //File Operations
    private static void searchFile() {

        System.out.println("Please, type the name of the file (remember to add the extension)");
        String fileName = scanner.nextLine();

        boolean result = fileManager.onFileList(fileName);

        if(result){
            System.out.println("Found " + fileName + " in the folder");
        } else {
            System.out.println("File not found on the folder");
        }

    }

    private static void addFile() throws IOException {

        System.out.println("Please, enter the name of the file (remember to add an extension at the end):");
        String fileName = scanner.nextLine();

        if(fileManager.onFileList(fileName)){
            System.out.println("File is already on the folder");
        } else {
            fileManager.addFiles(fileName);
            System.out.println(fileName + " successfully added!");
        }

    }

    private static void deleteFile() throws IOException {

        Scanner deleteChoice = new Scanner(System.in);

        System.out.println("Please, enter the name of the file (remember to add an extension at the end):");
        String fileName = scanner.nextLine();

        boolean result = fileManager.onFileList(fileName);

        if(result){
            System.out.println("Are you sure you want to delete the file? ");
            System.out.println("Y/N?");
            String response = deleteChoice.next().toLowerCase();

            if(response.equals("y")){
                fileManager.removeFile(fileName);
                System.out.println("File deleted");
            } else {
                System.out.println("Exiting feature...");
            }

        } else {
            System.out.println("File not found on the folder");
        }

    }





    //Utility functions
    //Verification of input
    public static boolean containsString(String userInput){

        boolean hasString = false;
        int index = 0;

        while (index < userInput.length()){
            if (!(userInput.charAt(index) > '0' && userInput.charAt(index) < '9')) {
                hasString = true;
                break;
            }
            index++;
        }

        return hasString;
    }

    //Wrong option message
    private static void wrongOptionMessage() {
        System.out.println("Wrong option! Please, select one of the items in the prompt");
    }

    private static void folderSelection() throws Exception {

        File fileLocation = null;

        System.out.println("Please, type the location for your files");
        fileLocation = new File(scanner.nextLine());

        if(fileLocation.exists()){
            System.out.println("Location found. Taking you to the main menu.");
            fileManager.setWorkingFolder(fileLocation);
            showMainMenu();
        } else {
            System.out.println("Location does not exist. Make sure the location exists in your computer.");
        }

    }



    //Menus - Text
    private static void initiatingMenu(){
        System.out.println("---------LockedMe.com--------");
        System.out.println("------Initializing Menu------");
        System.out.println("Select your option:");
        System.out.println("1.Input folder location");
        System.out.println("2.Exit Program");
    }

    private static void mainMenu(){
        System.out.println("------Main Menu------");
        System.out.println("Select your option:");
        System.out.println(" 1.List files in your location");
        System.out.println(" 2.File Operations");
        System.out.println(" 3.Go back to Initializing Menu ");
    }

    private static void opsMenu(){
        System.out.println("------Operations Menu------");
        System.out.println("Select your options:");
        System.out.println("1.Add a new file");
        System.out.println("2.Delete a file");
        System.out.println("3.Search for a file");
        System.out.println("4.Exit to Main Menu");
    }



}







