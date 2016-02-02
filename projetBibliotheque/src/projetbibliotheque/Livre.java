package projetbibliotheque;

public class Livre {

    private String identifiant;
    private String emplacement;
    private String dateAchat;

    public String toCSV(String separateur) {
        return (identifiant + separateur + emplacement
                + separateur + dateAchat);
    }

    @Override
    public String toString() {
        return "Livre{" + "identifiant=" + identifiant + ", place=" + emplacement
                + ", dateAchat=" + dateAchat + '}';
    }

    public Livre(String identifiant, String emplacement, String dateAchat) {
        this.identifiant = identifiant;
        this.emplacement = emplacement;
        this.dateAchat = dateAchat;
    }

    public Livre(String csvLine) {

        this.identifiant = csvLine.split(";")[0];
        this.emplacement = csvLine.split(";")[1];
        this.dateAchat = csvLine.split(";")[2];

    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public String getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(String dateAchat) {
        this.dateAchat = dateAchat;
    }

}
