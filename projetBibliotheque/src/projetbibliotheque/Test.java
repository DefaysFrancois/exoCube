package projetbibliotheque;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    //TODO afficher liste des livres
    //TODO modifier un livre
    //TODO supprimer un livre

    static Scanner keyb = new Scanner(System.in);
    static String fichierLivre = "livre.txt";
    static String choix;
    static int maxID;

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<Livre> livres = new ArrayList();

        chargerLivres(livres);

        afficherLivres(livres);

        afficherOptions();

        while (!choix.equals("0")) {
            switch (choix) {
                case "1":
                    afficherLivres(livres);
                    break;
                case "2":
                    addLivre(livres);
                    afficherLivres(livres);
                    break;
                case "3":
                    afficherLivres(livres);
                    System.out.print("id du livre à modifier : ");
                    getLivreAModif(getOption(), livres);
                    break;
                case "4":
                    afficherLivres(livres);
                    System.out.println("supprimer ici");
                    break;
                default:
                    choixIncorrect();
                    break;
            }
            afficherOptions();
        }

        goodbye();
        ecrireLivres(livres);
    }

    private static void chargerLivres(ArrayList<Livre> livres) throws FileNotFoundException {
        Scanner fileIn = new Scanner(new File(fichierLivre));
        System.out.println("Chargement des livres...");

        while (fileIn.hasNext()) {
            livres.add(new Livre(fileIn.nextLine()));
        }
        maxID = Integer.parseInt(livres.get(livres.size() - 1).getIdentifiant());
        System.out.println("ID max : " + maxID);
    }

    private static void afficherLivres(ArrayList<Livre> livres) {
        if (livres.size() > 0) {
            System.out.println("Liste des livres : ");

            for (Livre livre : livres) {
                System.out.println(livre);

            }
        } else {
            System.out.println("Pas encore de livres.");
        }

    }

    private static void addLivre(ArrayList<Livre> livres) {
        String identifiant;
        String place;
        String dateAchat;

        maxID++;
        System.out.println("id : " + maxID);
        identifiant = String.valueOf(maxID);
        System.out.print("emplacement : ");
        place = keyb.next();
        System.out.print("date achat : ");
        dateAchat = keyb.next();

        livres.add(new Livre(identifiant, place, dateAchat));
        System.out.print("Livre correctement ajouté");
    }

    private static void ecrireLivres(ArrayList<Livre> livres) throws FileNotFoundException {
        int nbEcrits = 0;
        PrintWriter out = new PrintWriter(fichierLivre);
        if (livres.size() > 0) {
            System.out.println("Ecriture des livres...");

            for (Livre livre : livres) {
                out.println(livre.toCSV(";"));
                nbEcrits++;
            }
            out.close();
            System.out.println("Livres ecrits : " + nbEcrits);
        }
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

    private static int getID(String idRech, ArrayList<Livre> livres) {
        int idRetour=0;
        for (Livre livre : livres) {
            idRetour++;
            if (livre.getIdentifiant().equals(idRech)) {
                return (idRetour);
            }
        }
        return -1;
    }

    private static void getLivreAModif(String option, ArrayList<Livre> livres) {
        int getID = getID(option,livres);
        if (getID>0) {
            System.out.println(livres.get(getID-1));
            modifierLivre(livres.get(getID-1));
            System.out.println(livres.get(getID-1));
        }
        else{
            System.out.println("N'existe pas");
        }
    }

    private static void modifierLivre(Livre livre) {
        String place;
        String dateAchat;

        System.out.println("id : " + livre.getIdentifiant());
        System.out.print("emplacement : ");
        place = keyb.next();
        System.out.print("date achat : ");
        dateAchat = keyb.next();
        
        livre.setDateAchat(dateAchat);
        livre.setEmplacement(place);
             
        System.out.println("Livre correctement modifié");
    }
}