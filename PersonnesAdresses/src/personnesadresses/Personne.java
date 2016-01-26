/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package personnesadresses;

/**
 *
 * @author 0605frdefays
 */
public class Personne {

    private String nom;
    private Adresse adresse;

     
    
    public Personne() {
    }

    public Personne(String nom, Adresse adresse) {
        this.nom = nom;
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "Personne{" + "nom=" + nom + ", adresse=" + adresse.toString() + '}';
    }
    
    public Adresse getAdresse() {
        return adresse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }
    
    
    
}
