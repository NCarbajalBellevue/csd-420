/*
 * Name: Natalia Carbajal
 * Date: November 8, 2026
 * Assignment: Module 4.2
 */

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTest {

    // Method to test traversal times
    public static void testList(int size) {

        LinkedList<Integer> numbers = new LinkedList<>();

        // Fill the list with integers
        for (int i = 0; i < size; i++) {
            numbers.add(i);
        }

        // Test traversal using an Iterator
        long startTime = System.nanoTime();

        int iteratorCount = 0;
        Iterator<Integer> iterator = numbers.iterator();

        while (iterator.hasNext()) {
            iterator.next();
            iteratorCount++;
        }

        long iteratorTime = System.nanoTime() - startTime;

        // Test traversal using get(index)
        startTime = System.nanoTime();

        int indexCount = 0;

        for (int i = 0; i < numbers.size(); i++) {
            numbers.get(i);
            indexCount++;
        }

        long indexTime = System.nanoTime() - startTime;

        // Check that both methods visited every element
        if (iteratorCount != size || indexCount != size) {
            System.out.println("Test failed!");
            return;
        }

        // Display the results
        System.out.println("\nList Size: " + size);
        System.out.println("Iterator Time: " + iteratorTime / 1_000_000.0 + " ms");
        System.out.println("get(index) Time: " + indexTime / 1_000_000.0 + " ms");
        System.out.println("Both methods visited all " + size + " elements.");
    }

    public static void main(String[] args) {

        // Test with 50,000 integers
        testList(50000);

        // Test with 500,000 integers
        testList(500000);
    }
}

/*
 * Results and Explanation:
 *
 * For 50,000 integers, the Iterator took 1.918 ms,
 * while get(index) took 759.2172 ms.
 *
 * For 500,000 integers, the Iterator took 3.9235 ms,
 * while get(index) took 76,268.9157 ms.
 *
 * The Iterator was much faster because it moves
 * directly from one element to the next.
 *
 * The get(index) method takes longer because it
 * has to travel through the LinkedList to find
 * each element.
 *
 * When the list increased from 50,000 to 500,000,
 * the get(index) method became much slower.
 *
 * Both methods successfully visited every element.
 */