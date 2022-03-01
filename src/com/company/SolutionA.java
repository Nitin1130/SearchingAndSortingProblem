package com.company;

import java.util.Scanner;

public class SolutionA {
    /**
     * This function implements binary search on the userIDs and attempts to find
     * an index where userIDs[index] == index
     *
     * @param userIDs An array of ints, where the ints are sorted from the smallest to the
     *                largest
     * @return the index where userIDs[index] == index or -1 if no such index exists
     */
    public static int upgradBookSearch(int[] userIDs) {
        int startIdx = 1;
        int endIdx = userIDs.length;

        // using divide and conquering to recursively look through userIDs, so
        // to find an index such that userIDs[index] == index
        while (startIdx <= endIdx) {
            int middleIdx = (startIdx + endIdx) / 2;

            if (middleIdx == userIDs[middleIdx]) {
                return middleIdx;
            }
            if (middleIdx < userIDs[middleIdx]) {
                endIdx = middleIdx - 1;
            } else {
                startIdx = middleIdx + 1;
            }
        }

        // if no such index exist, return -1
        return -1;
    }

    /**
     * Code that runs and executes the upgradBookSearch() function
     */
    public static void main(String[] args) {
        // Reads numbers from the command prompt, so to initialize the array
        // for this problem
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int array[] = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            array[i] = scanner.nextInt();
        }

        int index = upgradBookSearch(array);

        // Prints the index if the index is not -1
        // Otherwise, if the index is -1, print "NOT_FOUND"
        if (index != -1) {
            System.out.println(index);
        } else {
            System.out.println("NOT_FOUND");
        }
    }
}
