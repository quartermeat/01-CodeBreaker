/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codebreaker;


/**
 *
 * @author jeremy.williamson
 */
public class CodeNode{
    
    public static final Character X = 'X';
    public static final Character O = 'O';
    public static final Character NONE = '.';
    
    private Character assignedCharacter;
    private Character accuracyFlag;
    private int index;
    
    public CodeNode(Character newCharacter, int newIndex){
        index = newIndex;
        assignedCharacter = newCharacter;
    }
    
    public Character getCharacter(){
        return assignedCharacter;
    }
    
    
    
    
}
