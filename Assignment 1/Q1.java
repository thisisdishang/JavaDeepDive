// Java Program to add marks of two subjects. Write the same program using Command line arguments.

import java.util.Scanner;

class Q1 {
    public static void main(String[] args) {
        if (args.length != 0) {
            Scanner s = new Scanner(System.in);

            System.out.println("Subject 1 Marks: " + args[0]);

            System.out.println("Subject 2 Marks: " + args[1]);

            // Here the command line argument are in string so we have to convert into integer for addition
            System.out.println("Total Marks: " + (Integer.parseInt(args[0]) + Integer.parseInt(args[1])));
        } else {
            System.out.println("Please enter two subjects marks via command line");
        }
    }
}