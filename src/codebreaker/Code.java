/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codebreaker;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jeremy.williamson
 */
public class Code extends ArrayList<CodeNode> {

    private int size;
        
    public Code() {
        super();
        size = 4;
    }

    public Code(String newCode) {
        super();
        
        char[] newCharArray = newCode.toCharArray();
        size = newCharArray.length;
        for (int i = 0; i < size; i++) {
            add(new CodeNode(newCharArray[i], i));
        }
    }
    
    public Code(char[] newCode){
        super();
        size = newCode.length;
        for (int i = 0; i < size; i++) {
            add(new CodeNode(newCode[i], i));
        }
    }

    public Code getClues(ArrayList<CodeNode> newGuess) {

        Code resultList = new Code();
        Code leftOverCharacters = (Code) this.clone();

        newGuess.stream().forEach((guessCharacter) -> {

            //used for testing
            //System.out.println("*********************");
            //System.out.println("Guessed character = " +guessCharacter);
            //System.out.println("Code character = " + get(guessCharacter.getIndex()));
            //System.out.println("*********************");
            
            if (guessCharacter.equals(get(guessCharacter.getIndex()))) {
                resultList.add(new CodeNode(CodeNode.X, newGuess.indexOf(guessCharacter)));
                leftOverCharacters.remove(guessCharacter);
            } else if (leftOverCharacters.contains(guessCharacter)) {
                resultList.add(new CodeNode(CodeNode.O, indexOf(newGuess.indexOf(guessCharacter))));
                leftOverCharacters.remove(guessCharacter);
            } else {
                resultList.add(new CodeNode(CodeNode.NONE, newGuess.indexOf(guessCharacter)));
                leftOverCharacters.remove(guessCharacter);
            }//end if/else if/else

        }); //end foreach

        return resultList;
    }//end getClues()

    @Override
    public String toString() {
        String outputString = new String();

        for (CodeNode currentCharacter : this) {
            outputString = outputString.concat(String.valueOf(currentCharacter.getCharacter()));
        }

        return outputString;
    }
    
    public void setCode(String newCode) {
        char[] tempcode = newCode.toCharArray();

        for (int i = 0; i < size; i++) {
            add(new CodeNode(tempcode[i], i));
        }
    }
    
    public void initialize() {

        String alphabetString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        Random rand = new Random();
        char[] alphabetArray = alphabetString.toCharArray();

        for (int i = 0; i < size; i++) {
            add(new CodeNode(alphabetArray[rand.nextInt(36)], i));
        }//end for
    }//end initializeCode()

}
