/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relloso.ai3;

import java.util.Scanner;

/**
 *
 * @author ASUS 2
 */
public class RellosoAI3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a non-negative integer: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            System.out.println(n + "! = " + factorial(n));
        }

        sc.close();
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
//1. Why did one wrong return make every result wrong?

//Sa recursion man gud, ang each method call nga naghulat kay nag-depend sa
//value nga i-uli gikan sa base case sa pinakalast. Tungod kay naka-connect
//man tanan nga steps using multiplication (n * factorial(n - 1)), kung 0 ang
//gi-return sa base case, ma-force tanan nga naunang steps nga mag-multiply og
//0 pag-unwind na nila (4 * 3 * 2 * 1 * 0). Kay miskan unsa nga number i-multiply
//sa zero kay zero man jud always ang result, kana nga usa ka mali nga return maoy
//nakapawala sa tibuok calculation maong mahimong 0 tanan ang answer.

//2. Stretch: what happens for factorial(-2) with your corrected code, and

//Kung tawagon nato ang factorial(-2) sa gi-correct nga method, mag-infinite
//recursion siya ug mo-crash ang program tungod sa StackOverflowError.

//why?

//Ang base case nato kay mu-stop lang man kung n == 0, unya kada recursive call
//kay mag-minus og 1 (n - 1). Kung magsugod ta sa -2, ang sunod nga mga call 
//mahimong factorial(-3), factorial(-4), factorial(-5), and so on... which means,
//nagpalayo na hinuon siya sa 0 imbes na magpaduol. Tungod kay dili na gyud makaabot
//sa 0 ang n, dili na siya moundang og tawag sa iyang kaugalingon hangtod mahutdan
//og memory ang call stack.