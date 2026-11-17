/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relloso.ai2;

import java.util.Scanner;

/**
 *
 * @author ASUS 2
 */
public class RellosoAI2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many grades? ");
        int n = sc.nextInt();
        int[] grades = new int[n];

        System.out.println("Enter the grades:");
        for (int i = 0; i < n; i++) {
            grades[i] = sc.nextInt();
        }

        System.out.print("Enter passing mark: ");
        int passingMark = sc.nextInt();

        System.out.println("Part A (Loop): " + countPassing(grades, passingMark));
        System.out.println("Part B (Recursive): " + countPassingRecursive(grades, passingMark, 0));

        sc.close();
    }

    public static int countPassing(int[] grades, int passingMark) {
        int count = 0;
        for (int grade : grades) {
            if (grade >= passingMark) {
                count++;
            }
        }
        return count;
    }

    public static int countPassingRecursive(int[] grades, int passingMark, int index) {
        // Base case
        if (index >= grades.length) {
            return 0;
        }

        // Recursive step
        if (grades[index] >= passingMark) {
            return 1 + countPassingRecursive(grades, passingMark, index + 1);
        } else {
            return countPassingRecursive(grades, passingMark, index + 1);
        }
    }
}

//1. What does each recursive call do to index, and why must it change?

//Kada call sa recursive method, gina-addan niya og 1 ang index para mo-move
//na siya sa sunod nga grade sa array. Need gyud ni magchange kay ang index man
//ang nagserve as tracker kung asa na ta dapit, kay kung dili ni nato dugangan,
//ma-stuck lang ang method og check sa parehas nga element balik-balik and dili
//na gyud siya makaabot sa tumoy sa array.

//2. What happens if you delete the base case entirely?

//If walay base case, walay hunong ang method sa pagcall sa iyang self bisan 
//lapas na siya sa end sa array. Pag-abot sa index sa grades.length, sulayan 
//og basa ni Java ang grades nga wala na man unta diha, maong mo-crash dayon 
//ang program ug sa kinatibuk-an, and in general, infinite recursion without 
// a base case leads to a StackOverflowError because the call stack runs out 
//of memory.