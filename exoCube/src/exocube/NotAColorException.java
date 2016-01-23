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
public class NotAColorException extends Exception{

    public NotAColorException() {
        System.out.println("Les 3 entiers doivent etre compris entre 0 et 255");
    }
    
}
