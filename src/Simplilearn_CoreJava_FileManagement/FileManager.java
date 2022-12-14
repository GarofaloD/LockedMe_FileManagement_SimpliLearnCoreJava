package Simplilearn_CoreJava_FileManagement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ListIterator;

public class FileManager {

    static File workingFolder = null;
    static ArrayList<File> filesinWorkingFolder;

    public void setWorkingFolder(File folder){
        this.workingFolder = folder;
        filesinWorkingFolder = new ArrayList<>(Arrays.asList(workingFolder.listFiles()));
    }


    public void listFiles(){

        if(workingFolder != null){

            Collections.sort(filesinWorkingFolder);

            for(File file : filesinWorkingFolder){
                System.out.println(file);
            }

        } else {
            System.out.println("No such working folder");

        }

    }

    public void addFiles(String fileName) throws IOException {

        if(workingFolder != null){

            String newFileFullPath = workingFolder.getAbsolutePath() + "/" +fileName;
            File fileToAdd = new File(newFileFullPath);

            FileOutputStream fos = new FileOutputStream(fileToAdd);
            fos.close();
            filesinWorkingFolder.add(fileToAdd);

        } else {
            System.out.println("No such working folder");

        }
    }

    public void removeFile(String fileName) throws IOException {

        if(workingFolder != null){

            String fileFullPath = workingFolder.getAbsolutePath() + "/" +fileName;
            File fileToRemove = searchFiles(fileFullPath);

            if(fileToRemove != null){
                Files.deleteIfExists(fileToRemove.toPath());
                filesinWorkingFolder.remove(fileToRemove);
            }

        } else {
            System.out.println("No such working folder");

        }
    }


    public File searchFiles(String fileName){

        for(int i = 0; i < filesinWorkingFolder.size(); i++){
            if(filesinWorkingFolder.get(i).getAbsolutePath().equalsIgnoreCase(fileName.toLowerCase())){
                return filesinWorkingFolder.get(i);
            }
        }

        return null;
    }

    public boolean onFileList(String fileToRetrieve){

        String fileToFindFullPath = workingFolder.getAbsolutePath() + "/" + fileToRetrieve;
        File fileToFind = searchFiles(fileToFindFullPath);

        if(fileToFind != null){
            return true;
        }

        return false;
    }





}
