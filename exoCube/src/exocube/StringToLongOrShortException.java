/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exocube;

/**
 *
 * @author Def
 */
public class StringToLongOrShortException extends Exception{

    public StringToLongOrShortException() {
        System.out.println("Le nom doit avoir entre 3 et 15 charactères");
    }
    
}
