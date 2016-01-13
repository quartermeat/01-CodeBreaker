/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codebreaker;

import java.util.ArrayList;
import codebreaker.CodeNode;
import java.util.Arrays;

/**
 *
 * @author jeremy.williamson
 */
public class Code extends ArrayList<CodeNode> {

    public Code() {
        super();
    }
    
    public Code(String newCode){
        super();
        char[] newCharArray = newCode.toCharArray();
        for(int i = 0; i < newCharArray.length; i++){
            this.add(e)
        }
    }

    public ArrayList<CodeNode> getClues(ArrayList<CodeNode> newCode, ArrayList<CodeNode> newGuess) {

        ArrayList<CodeNode> resultList = new ArrayList<>();

        newGuess.stream().forEach((guessCharacter) -> {
            do {

                newCode.stream().forEach((codeCharacter) -> {
                    do {
                        if (guessCharacter == codeCharacter) {
                            resultList.add(new CodeNode(CodeNode.X, newCode.indexOf(codeCharacter)));
                        } else if (newGuess.contains(codeCharacter)) {
                            resultList.add(new CodeNode(CodeNode.O, newCode.indexOf(codeCharacter)));
                        } else {
                            resultList.add(new CodeNode(CodeNode.NONE, newCode.indexOf(codeCharacter)));
                        }
                    } while (newCode.remove(codeCharacter));//end do/while
                }); //end foreach

            } while (newGuess.remove(guessCharacter));//end do/while
        }); //end foreach
        
        return resultList;
    }//end getClues()
    
    @Override
    public String toString(){
        String outputString = new String();
        
        for(CodeNode currentCharacter : this){
            outputString.concat(Character.toString(currentCharacter.getCharacter()));
        }
        
        return outputString;
    }

}
