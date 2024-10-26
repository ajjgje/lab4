import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.random.*;

public class Lab4_Rubio {
    // TODO Task 0: Scan text file
    public static String[] buildArray(String filepath) {
        String[] words = {};
        try {
            // Step 1: Create a Scanner object to read the file
            File file = new File("WordList.txt");
            Scanner scanner = new Scanner(file);
            // TODO Step 2: Read the entire file content

            // TODO Step 3: Split the string into an array of words
            words = scanner.nextLine().split(",");
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }

        return words;
    }

    // TODO Task 1: Reverse a string
    public static String reverseString(String s) {
        // Base case(s)
        if (s == null || s.length() == 0) {
            return "";
        } else {
            return reverseString(s.substring(1, s.length())) + s.substring(0, 1);
        }
        // Recursive case(s)
    }

    // TODO Task 2: Count number of char, c, in a string
    public static int countChar(String s, char c) {
        // Base case(s)
        char[] arrchar = new char[s.length()];
        int countChar = 0;
        if (s == null || s.length() == 0) {
            return 0;
        }
        for (int i = 0; i < s.length(); i++) {
            arrchar[i] = s.charAt(i);
            if (arrchar[i] == c) {
                countChar++;
            }
        }
        // Recursive case(s)
        return countChar;
    }

    // TODO Task 3: Check if word is a palindrome
    public static boolean isPalindrome(String s) {
        // Base case(s)
        int num = s.length();
        for (int i = 0; i < num; i++) {
            if (s.charAt(i) != s.charAt(num - i - 1)) {
                return false;
            }
        }
        // Recursive case(s)
        return true;
    }

    // TODO Task 4: Recursive method to print the linked list in reverse order
    public static void printReverse(ListNode head) {
        // Base case(s)
        if (head == null) {
            return;
        }
        printReverse(head.next);
        System.out.print(head.value + " ");
    }

    // TODO Task 5: Compute the nth Fibonacci number
    public static int fibonacci(int n) {
        // Base case(s)
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        }

        // Recursive case(s)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /** --------------------- DO NOT TOUCH CODE ------------------------------- */

    // Helper method to create and append nodes to a LList
    public static ListNode createList(int[] values) {
        if (values.length == 0)
            return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to print printReverse tests
    public static void runTestCase(String label, int[] values) {
        System.out.println(label + ":  ");
        for (int val : values) {
            System.out.print(val + " ");
        }
        System.out.println();
        ListNode head = createList(values);
        printReverse(head);
        System.out.println();
    }

    public static void main(String[] args) {
        Random rndm = new Random();
        String filename = "./WordList.txt";
        String testString = "";
        int randomIndex = 1;
        char testChar = 'a';
        int n = 10; // the first n Fibonacci numbers

        // Task 0
        System.out.println("Task 0 ########################");
        String[] words = buildArray(filename);
        // Print out the array contents to confirm success
        for (int i = 0; i < words.length; i += 200) {
            int randInt = rndm.nextInt(i + 1);
            System.out.println("Word #" + randInt + "\t\t" + words[randInt].trim());
        }

        // Task 1
        System.out.println("\nTask 1 ########################");
        System.out.println("Original  :  Reversed");
        for (int i = 0; i < 12; i++) {
            testString = words[rndm.nextInt(words.length)].trim();
            System.out.println(testString + "\t" + reverseString(testString));
        }

        // Task 2
        System.out.println("\nTask 2 ########################");
        for (int i = 0; i < 12; i++) {
            testString = words[rndm.nextInt(words.length)].trim();
            randomIndex = rndm.nextInt(testString.length());
            testChar = testString.charAt(randomIndex);
            System.out.println("Occurrences of '" + testChar + "' in " +
                    testString + ": \t" + countChar(testString, testChar));
        }

        // Task 3
        System.out.println("\nTask 3 ########################");
        for (int i = 0; i < 12; i++) {
            testString = words[rndm.nextInt(40)].trim();
            System.out.println("Is '" + testString + "' a palindrome?   " + isPalindrome(testString));
        }

        // Task 4
        System.out.println("\nTask 4 ########################");
        System.out.println("Fibonacci sequence up to " + n + ":");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();

        // Task 5
        System.out.println("\nTask 5 ########################");
        // Test Case 1: Empty List
        runTestCase("Empty List", new int[] {});
        // Test Case 2: Single Node
        runTestCase("Single Node", new int[] { 1 });
        // Test Case 3: Two Nodes
        runTestCase("Two Nodes", new int[] { 1, 2 });
        // Test Case 4: Three Nodes
        runTestCase("Three Nodes", new int[] { 1, 2, 3 });
        // Test Case 5: Four Nodes
        runTestCase("Four Nodes", new int[] { 1, 2, 3, 4 });
        // Test Case 6: Five Nodes
        runTestCase("Five Nodes", new int[] { 1, 2, 3, 4, 5 });
        // Test Case 7: List with Repeated Values
        runTestCase("LList with Repeated Values", new int[] { 5, 5, 5, 5, 5 });
        // Test Case 8: List with Negative Numbers
        runTestCase("LList with Negative Numbers", new int[] { -1, -2, -3, -4, -5 });
        // Test Case 9: List with Positive and Negative Numbers
        runTestCase("LList with Positive and Negative Numbers", new int[] { 1, -2, 3, -4, 5 });
        // Test Case 10: List with Large Numbers
        runTestCase("LList with Large Numbers", new int[] { 1000, 2000, 3000, 4000, 5000 });

    }

    /** --------------------- END OF DO NOT TOUCH CODE ------------------------ */
}