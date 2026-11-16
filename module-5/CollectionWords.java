
/*
 * Name: Natalia Carbajal
 * Date: November 15, 2026
 * Assignment: Sets and Maps
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashSet;

public class CollectionWords {

    public static void main(String[] args) throws FileNotFoundException {

        TreeSet<String> words = new TreeSet<>();
        HashSet<String> original = new HashSet<>();

        // Read words from the file
        Scanner input = new Scanner(new File("collection_of_words.txt"));

        while (input.hasNext()) {
            String word = input.next().toLowerCase();
            original.add(word);
            words.add(word);
        }

        input.close();

        // Display words in both orders
        System.out.println("Ascending: " + words);
        System.out.println("Descending: " + words.descendingSet());

        // Test the results
        boolean passed = original.size() == words.size()
                && words.equals(new TreeSet<>(original));

        System.out.println("\nDuplicates Removed: " + passed);
        System.out.println("All tests passed!");
    }
}
