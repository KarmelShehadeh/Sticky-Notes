package com.company;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;


public class Main {

    public static void main(String[] args) throws IOException {
        //create the menu here
        addNewUser();

    }


    private static void addNewUser() throws IOException{

        Scanner input = new Scanner(System.in);
        System.out.print("Welcome aboard new user!\n");

        System.out.print("Please let me know your first name: ");
        String firstName = input.nextLine();           //to write the first name of the user
        System.out.print("Great "+ firstName +",");

        System.out.print(" now please enter your last name:");
        String lastName = input.nextLine(); // to write the last name of the user

        System.out.print("Done! ");
        System.out.print("\nNice to meet you " +firstName+" "+ lastName);
        String fileName = firstName .concat( lastName .concat( ".txt")); //The file name consists of the first and last name
        File file = new File("C:\\Users\\karme\\OneDrive\\Desktop\\notes\\"+fileName);// create the file in the written path
        boolean isFileCreated = file.createNewFile();

        if(isFileCreated)
           System.out.print("\nThe file created Successfully!");
        else
            System.out.print("There is a Problem!");

        System.out.print("\n<Click Enter to return to main menu>");
    }




    }

