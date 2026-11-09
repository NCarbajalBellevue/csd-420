
/*
 * Name: Natalia Carbajal
 * Date: November 8, 2026
 * Assignment: Module 3.2
 */

import java.util.ArrayList;
import java.util.Random;

public class RemoveDuplicates {
    // Method that creates a new list without duplicates
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        // Create a new empty ArrayList
        ArrayList<E> newList = new ArrayList<>();
        // Go through each value in the original list
        for (E value : list) {

            // Check if the new list already contains the value
            if (!newList.contains(value)) {

                // Add the value if it is not already there
                newList.add(value);
            }
        }
        // Return the list without duplicates
        return newList;
    }
    public static void main(String[] args) {

        // Create the original ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();

        // Create a Random object
        Random random = new Random();

        // Add 50 random numbers between 1 and 20
        for (int i = 0; i < 50; i++) {
            numbers.add(random.nextInt(20) + 1);
        }
        // Call the method to remove duplicates
        ArrayList<Integer> uniqueNumbers = removeDuplicates(numbers);

        // Display the original list
        System.out.println("Original ArrayList:");
        System.out.println(numbers);

        // Display the list without duplicates
        System.out.println("\nArrayList Without Duplicates:");
        System.out.println(uniqueNumbers);
    }
}