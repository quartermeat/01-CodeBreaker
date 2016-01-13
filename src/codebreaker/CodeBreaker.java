/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codebreaker;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author jeremy.williamson
 */
public class CodeBreaker {

    /**
     * @param args the command line arguments
     */
    private static Code clues;
    private static Code code;
    private static Code answer;

    public static void main(String[] args) {
        // TODO code application logic here
                
        System.out.println("Welcome to Code Breaker!");
        String alphabetString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        char[] alphabetArray = alphabetString.toCharArray();
        
        code = new Code();
        for (int i = 0; i < 5; i++) {
            code.add(new CodeNode(alphabetArray[rand.nextInt(36 + 1)], i));
        }//end for
        
        System.out.println("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        System.out.println("Type 'quit' to exit and 'help' for instructions.");

        Scanner consoleInput = new Scanner(System.in);

        boolean gameRunning = true;
        //int numTry = 10;

        while (gameRunning) {

            System.out.println("Enter guess: ");
            String input = consoleInput.next();

            if (input.equalsIgnoreCase("quit")) {
                gameRunning = false;
                System.out.println("Thanks for playing CodeBreaker");
                break;
            } else if (input.equalsIgnoreCase("help")) {
                System.out.println("Enter 'quit' to exit or 'help' for instructions.");
                System.out.println("Enter a five character guess to what the code word maybe. The code is randomly made up of"
                        + " the letters of the alphabet and the 10 single digit numbers including 0");
                System.out.println("The game will then let you know what characters are correctly guessed in the wrong spot,"
                        + " and what characters were guessed correctly in the correct spot.");
                System.out.println("X = Correct character in the correct location.");
                System.out.println("O = Correct character in incorrect location.");
                System.out.println(". = Not a correct character.");
            } else {
                
                
            }//end if/else if/esle if/else    
        }//end while
    }//end main
   
}//end CodeBreaker
