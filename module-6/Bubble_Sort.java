
// Name: Natalia
// Date: November 22, 2026
// Assignment: Module 6.2 Programming Assignment
// Description: This program demonstrates two generic bubble sort methods.
// One uses Comparable and the other uses Comparator.

import java.util.Arrays;
import java.util.Comparator;

public class Bubble_Sort {

    // This method sorts an array using the Comparable interface.
    // Comparable allows objects to define their natural sorting order.
    public static <T extends Comparable<? super T>> void bubbleSort(T[] array) {

        // Repeat the sorting process until the array is sorted.
        for (int i = 0; i < array.length - 1; i++) {

            // Tracks whether any elements were switched.
            boolean swapped = false;

            // Compare neighboring elements in the array.
            // The - i prevents checking elements already sorted.
            for (int j = 0; j < array.length - 1 - i; j++) {

                // If the first element is greater, switch their positions.
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            // Stop early if no elements needed to be switched.
            if (!swapped) {
                break;
            }
        }
    }

    // This method sorts an array using the Comparator interface.
    // Comparator allows the programmer to choose how objects are sorted.
    public static <T> void bubbleSort(T[] array, Comparator<? super T> comparator) {

        // Continue comparing elements until the array is sorted.
        for (int i = 0; i < array.length - 1; i++) {

            // Tracks whether elements were switched during this pass.
            boolean swapped = false;

            // Compare each pair of neighboring elements.
            for (int j = 0; j < array.length - 1 - i; j++) {

                // Use the Comparator to decide whether the elements need to switch.
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;

                    swapped = true;
                }
            }

            // Stop sorting if the array is already in the correct order.
            if (!swapped) {
                break;
            }
        }
    }

    // This Student class provides objects to test the Comparator method.
    static class Student {
        String name;
        int grade;

        // Constructor stores each student's name and grade.
        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        // Displays the student's name and grade when printed.
        public String toString() {
            return name + ": " + grade;
        }
    }

    // Main method tests both bubble sort methods.
    public static void main(String[] args) {

        // Create an array of integers for the Comparable test.
        Integer[] numbers = {8, 3, 5, 1, 9, 3};

        System.out.println("Before Comparable sort:");
        System.out.println(Arrays.toString(numbers));

        // Sort the numbers from smallest to largest.
        bubbleSort(numbers);

        System.out.println("After Comparable sort:");
        System.out.println(Arrays.toString(numbers));

        // Check that the Comparable method produced the correct order.
        if (!Arrays.equals(numbers, new Integer[]{1, 3, 3, 5, 8, 9})) {
            throw new AssertionError("Comparable sort failed.");
        }

        // Create an array of Student objects for the Comparator test.
        Student[] students = {
            new Student("Mia", 88),
            new Student("Jordan", 72),
            new Student("Alex", 95),
            new Student("Sam", 81)
        };

        System.out.println("\nBefore Comparator sort:");
        System.out.println(Arrays.toString(students));

        // Sort students by grade from lowest to highest.
        // Comparator.comparingInt() compares the grade of each student.
        bubbleSort(students, Comparator.comparingInt(student -> student.grade));

        System.out.println("After Comparator sort:");
        System.out.println(Arrays.toString(students));

        // Store the grades in the order we expect after sorting.
        int[] expectedGrades = {72, 81, 88, 95};

        // Check that the students were sorted correctly.
        for (int i = 0; i < students.length; i++) {
            if (students[i].grade != expectedGrades[i]) {
                throw new AssertionError("Comparator sort failed.");
            }
        }

        // Display a message when both sorting tests are successful.
        System.out.println("\nBoth bubble sort tests passed.");
    }
}
