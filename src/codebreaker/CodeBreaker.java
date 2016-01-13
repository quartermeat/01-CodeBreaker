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
    private static Character[] clues;
    private static Character[] code;
    private static Character[] answer;

    public static void main(String[] args) {
        // TODO code application logic here
        initializeArrays();
        
        System.out.println("Welcome to Code Breaker!");
        String alphabetString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rand = new Random();
        char[] alphabetArray = alphabetString.toCharArray();

        for (int i = 0; i < 5; i++) {
            code[i] = alphabetArray[rand.nextInt(36 + 1)];
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
            } else if (input.equalsIgnoreCase(code.toString())) {
                System.out.println("Good job! You've cracked the code!");
                break;
            } else {

                char[] tempAnswer = input.toUpperCase().toCharArray();
                for(int i = 0; i < tempAnswer.length; i++){
                    answer[i] = tempAnswer[i];
                }

                System.out.println("You've entered: " + new String(tempAnswer));

                //fill in the rest of the char array
                for (int i = answer.length; i < code.length; i++) {
                    answer[i] = '.';
                }
                System.out.println("(Troubleshooting only)The code is: " + new String())

                for (int i = 0; i < answer.length; i++) {

                    //if it is a correct character in the correct spot
                    if (answer[i] == code[i]) {
                        clues[i] = 'X';
                    //if this character is anywhere in the code
                    } else if (answer.toString().contains(String.valueOf(code[i]))) {
                        clues[i] = 'O';
                    //if this character does not exist in code
                    } else {
                        clues[i] = '.';
                        //todo 
                    }//end if/else if/else

                }//end for

                System.out.println("Guess recieved, here are the clues:");

                for (int i = 0; i < clues.length; i++) {
                    System.out.print(clues[i]);

                }
                System.out.println();

                Arrays.fill(clues, '*');

            }//end if/else if/esle if/else    
        }//end while
    }//end main

    public static void initializeArrays() {
        clues = new Character[5];
        code = new Character[5];
        answer = new Character[5];
        
        for(int i = 0; i < 5; i++){
            clues[i] = '.';
            code[i] = '*';
            
        }
    }//end initializeClues

}//end CodeBreaker
