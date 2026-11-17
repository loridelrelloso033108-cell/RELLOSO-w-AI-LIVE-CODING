/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package relloso.ai;

/**
 *
 * @author RELLOSO_CPE113
 */
public class RellosoAI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Put your test cases inside main
        System.out.println(computeAverage(5,2));
    }

    public static double computeAverage(int total, int count) {
        if (count <= 0) {
            return 0.0; // boundary guard
        }
        return (double) total / count; // double division
    }
}

//1. Why does the method need the word double (or a cast) in the return?
//Kay parehas man nga int (whole number) ang total ug count, 
//mag-integer division ang Java kung walay cast, meaning putlon or tanggalon niya ang decimal part.
//For example, ang 5 / 2 mahimo na lang 2 imbes na 2.5. Bisan pag double ang return type sa method,
//humanon sa man gud ni Java ang pag-divide bag-o niya i-convert, so ang 2 mahimo lang 2.0 ug mawala na ang .5.
//Pag nagbutang tag (double), ma-force ang Java nga i-treat ang total as decimal if mag-divide,
//para makuha gyud ang exact nga answer nga naay decimal like ang 2.5.


//2. What would go wrong without the count <= 0 guard?
//Kung 0 ang count, Bawal man mag-divide by zero sa math. 
//Kung regular integer division lang, mag-crash ang program tungod sa ArithmeticException.
//Pero tungod kay naay (double) cast, ang i-output ni Java kay Infinity or 
//Not a Number imbes na tarong nga 0.0.
//On the other hand, kung negative ang count, sa real life, 
//wala man tay negative nga ihap sa items. Kung walay guard, mo-divide gihapon siya 
//sa negative number unya mogawas nga mali or negative ang average imbes na mo-return 
//na lang og safe nga 0.0.
