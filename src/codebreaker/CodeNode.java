/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codebreaker;

import java.util.Objects;


/**
 *
 * @author jeremy.williamson
 */
public class CodeNode extends Object{
    
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
    
    public int getIndex(){
        return index;
    }
   
    @Override
    public boolean equals(Object otherNode){
        if(otherNode instanceof CodeNode){
            CodeNode placeHolder = (CodeNode)otherNode;
            return placeHolder.getCharacter().equals(assignedCharacter);
        }else
            return false;
    }//end equals

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.assignedCharacter);
        return hash;
    }
    
    
    
    
}
