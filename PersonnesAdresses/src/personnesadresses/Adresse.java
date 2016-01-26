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
public class Adresse {

    private String rue;
    private String ville;
    
    
    public Adresse() {
    }

    public Adresse(String rue, String ville) {
        this.rue = rue;
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adresse{" + "rue=" + rue + ", ville=" + ville + '}';
    }
    

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }
    
    
}
