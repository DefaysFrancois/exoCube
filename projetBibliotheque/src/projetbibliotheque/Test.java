package projetbibliotheque;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    //TODO afficher liste des livres
    //TODO modifier un livre
    //TODO supprimer un livre

    static Scanner keyb = new Scanner(System.in);
    static String choix;
    static int maxID;

    public static void main(String[] args) throws FileNotFoundException, SQLException, ClassNotFoundException {

        Catalogue catalogue = new Catalogue();

        afficherLivres(catalogue);

        afficherOptions();

        while (!choix.equals("0")) {
            switch (choix) {
                case "1":
                    afficherLivres(catalogue);
                    break;
                case "2":
                    addLivre(catalogue);
                    afficherLivres(catalogue);
                    break;
                case "3":
                    afficherLivres(catalogue);
                    System.out.print("id du livre à modifier : ");
                    updateLivre(getOption(), catalogue);
                    break;
                case "4":
                    afficherLivres(catalogue);
                    System.out.println("id du livre à delete : ");
                    deleteLivre(getOption(), catalogue);
                    afficherLivres(catalogue);
                    break;
                default:
                    choixIncorrect();
                    break;
            }
            afficherOptions();
        }

        goodbye();
    }

    private static void afficherLivres(Catalogue catalogue) throws ClassNotFoundException, SQLException {
        ArrayList<Livre> listeLivre = catalogue.read();
        for (Livre livre : listeLivre) {
            System.out.println(livre);
        }
    }

    private static void afficherLivre(Catalogue catalogue, int id) throws ClassNotFoundException, SQLException {
        Livre l = catalogue.read(id);
        System.out.println(l);
    }

    private static void addLivre(Catalogue catalogue) throws ClassNotFoundException, SQLException {

        String titre;
        String auteur;

        System.out.print("Titre : ");
        titre = keyb.next();
        System.out.print("Auteur : ");
        auteur = keyb.next();

        catalogue.add(new Livre(titre, auteur));
        System.out.print("Livre correctement ajouté");
    }

    private static void goodbye() {
        System.out.println("Merci");
    }

    private static void afficherOptions() {
        System.out.println("                      ");
        System.out.println("----------------------");
        System.out.println("1 : lister les livres");
        System.out.println("2 : ajouter   un livre");
        System.out.println("3 : modifier  un livre");
        System.out.println("4 : supprimer un livre");
        System.out.println("0 : quitter");
        System.out.print("votre choix : ");
        choix = getOption();
    }

    private static String getOption() {
        return (keyb.next());
    }

    private static void choixIncorrect() {
        System.out.println("!!! Choix incorrect !!!");
    }

    private static void updateLivre(String option, Catalogue catalogue)
            throws SQLException, ClassNotFoundException {

        Livre l = catalogue.read((int) Integer.parseInt(option));

        String titre;
        String auteur;
        afficherLivre(catalogue, l.getId());
        System.out.print("Titre : ");
        titre = keyb.next();
        System.out.print("Auteur : ");
        auteur = keyb.next();

        l.setTitre(titre);
        l.setAuteur(auteur);

        catalogue.update(l);
        System.out.println("modification OK...");
    }

    private static void deleteLivre(String option, Catalogue catalogue)
            throws SQLException, ClassNotFoundException {
        
        catalogue.delete((int) Integer.parseInt(option));
        System.out.println("delete OK...");
    }

}
