package com.company;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.io.File;


public class Main {

    public static void main(String[] args) throws IOException {

        //create the menu here
     //   addNewUser();
        viewNotes();

    }
    private static void addNewUser() throws IOException{
        String path = "C:/Users/karme/OneDrive/Desktop/Notes/";

        Scanner input = new Scanner(System.in);
        System.out.print("Welcome aboard new user!\n ");

        System.out.print("Please let me know your first name: ");
        String firstName = input.nextLine();
        System.out.print("Great"+ firstName +",");  //to write the first name of the user

        System.out.print(" now please enter your last name:");
        String lastName = input.nextLine(); // to write the last name of the user

        System.out.print("Done! ");
        System.out.print("\nNice to meet you " +firstName+" "+ lastName);
        String fileName = firstName + lastName + ".txt";
        File file = new File(path +fileName);// create the file in the written path
        System.out.print("\n<Click Enter to return to main menu>");
        boolean isFileCreated = file.createNewFile();
        if(isFileCreated)
        System.out.print("The file Created Successfully");
        else
            System.out.print("There is a Problem");

    }

    private static void viewNotes() throws IOException {
        String path = "C:/Users/karme/OneDrive/Desktop/Notes/"; //the path of notes directory

        Scanner input = new Scanner(System.in);
        System.out.print("Retrieve your notes? Absolutely! \n" +
                "Please let know your full name first: \n");

        String yourName = input.nextLine(); //the user have to write his name here
        String fullName = yourName + ".txt"; //add .txt extintion to the user name

        File dir = new File(path); //create dir object
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept (File dir, String name) {
                return name.startsWith(fullName);
            }
        };

        String[] children = dir.list(filter); //create children list
        if (children == null) {       //if there is no directory with the previous path

            System.out.println("Either dir does not exist or is not a directory");
        } else {
            if(children.length==0)//if there is no  file with the written name
                System.out.print("Umm, can’t find any saved notes for you.");
         else{ // if the file exist

                    System.out.println("Found it!\n" +
                            "Here are your stored notes:\n ");
                    Files.lines(Paths.get(path + fullName ), StandardCharsets.UTF_8).forEach(System.out::println); //print the content of the file

                    System.out.print("\n Happy to serve you :)");
                }
                }


        }

    }


