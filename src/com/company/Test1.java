package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Test1 {

    public static void main(String[] args) throws IOException {

        //creates the file

        // Accept a string
//        String str = "File Handling in Java using " +
//                " FileWriter and FileReader";

        // attach a file to FileWriter
//        FileWriter fw = new FileWriter("text");

        // read character wise from string and write
        // into FileWriter
//        for (int i = 0; i < str.length(); i++)
//            fw.write(str.charAt(i));

        //close the file
//        fw.close();

        // reads the file

        // variable declaration
//        int ch;

        // check if File exists or not
//        FileReader fr=null;
//        try
//        {
//            fr = new FileReader("text");
//        }
//        catch (FileNotFoundException fe)
//        {
//            System.out.println("File not found");
//        }

        // read from FileReader till the end of file
//        while ((ch=fr.read())!=-1)
//            System.out.print((char)ch);

        // close the file
//        fr.close();

        //Alignment

//        String heading1 = "Exam_Name";
//        String heading2 = "Exam_Grade";
//
//        System.out.printf( "%-15s %15s %n", heading1, heading2);

        // Files and paths
//
//        Files.write(taskList, tasks,
//                Files.exists(taskList) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
//        final Path taskList = Paths.get("TaskList.txt");
//        private List<String> tasks = new ArrayList<>();

//        Path path =
//        byte[] bytes = ...
//        Files.write(path, bytes, StandardOpenOption.APPEND);
    }
}