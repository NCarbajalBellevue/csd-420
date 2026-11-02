/*
 * Name: Natalia Carbajal
 * Date: November 1, 2026
 * Assignment: Module 2.2
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadData {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("Natalia Carbajal datafile.dat");
        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {
            System.out.println(input.nextLine());
        }

        input.close();
    }
}