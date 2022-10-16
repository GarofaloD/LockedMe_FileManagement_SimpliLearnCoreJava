package Simplilearn_CoreJava_FileManagement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

//            //Collection to manage the files
//            ArrayList<File> filesinWorkingFolder = new ArrayList<File>(Arrays.asList(workingFolder.listFiles()));

            //Iterator for the collection
            ListIterator<File> iterator = filesinWorkingFolder.listIterator();

            while (iterator.hasNext()){
                System.out.println(iterator.next());
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

    public File searchFiles(String fileName){

        for(int i = 0; i < filesinWorkingFolder.size(); i++){
            if(filesinWorkingFolder.get(i).getAbsolutePath().equals(fileName)){
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
