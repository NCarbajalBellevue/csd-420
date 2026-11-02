/*
 * Name: Natalia Carbajal
 * Date: November 1, 2026
 * Assignment: Module 2.2
 */

import java.io.*;
import java.util.Random;

public class WriteData {
    public static void main(String[] args) throws IOException {

        Random random = new Random();

        int[] numbers = new int[5];
        double[] values = new double[5];

        for (int i = 0; i < 5; i++) {
            numbers[i] = random.nextInt(100);
            values[i] = random.nextDouble() * 100;
        }

        PrintWriter output = new PrintWriter(
        new FileWriter("Natalia Carbajal datafile.dat", true));

        for (int i = 0; i < 5; i++) {
            output.println(numbers[i]);
        }

        for (int i = 0; i < 5; i++) {
            output.println(values[i]);
        }

        output.close();

        System.out.println("Data saved successfully.");
    }
}