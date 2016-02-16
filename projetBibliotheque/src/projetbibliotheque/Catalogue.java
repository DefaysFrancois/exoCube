/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projetbibliotheque;

import java.util.ArrayList;

/**
 *
 * @author 0605frdefays
 */
public class Catalogue {
    private ArrayList<Livre> livres;

    public void setLivres(ArrayList<Livre> livres) {
        this.livres = livres;
    }

    public ArrayList<Livre> getLivres() {
        return livres;
    }

    public Catalogue(ArrayList<Livre> livres) {
        this.livres = livres;
    }
    
}
