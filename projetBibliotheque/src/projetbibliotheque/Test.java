package projetbibliotheque;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    static Scanner keyb = new Scanner(System.in);

    private static boolean getGoOn() {

        switch (keyb.next()) {
            case "y":
            case "Y":
                return (true);
            default:
                return (false);

        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        String fichierLivre = "livre.txt";
        Scanner fileIn = new Scanner(new File(fichierLivre));

        String identifiant;
        String place;
        String dateAchat;

        ArrayList<Livre> livres = new ArrayList();

        System.out.println("Chargement des livres : ");

        while (fileIn.hasNext()) {
            livres.add(new Livre(fileIn.nextLine()));
        }

        if (livres.size() > 0) {
            System.out.println("Liste des livres : ");

            for (Livre livre : livres) {
                System.out.println(livre);

            }
        } else {
            System.out.println("Pas de livres.");
        }

        System.out.print("encoder ?(Y/N) ");

        while (getGoOn()) {

            System.out.print("id : ");
            identifiant = keyb.next();
            System.out.print("emplacement : ");
            place = keyb.next();
            System.out.print("date achat : ");
            dateAchat = keyb.next();

            livres.add(new Livre(identifiant, place, dateAchat));

            System.out.print("Encoder un autre livre (Y/N) : ");
        }

        System.out.println("Merci");

        PrintWriter out = new PrintWriter(fichierLivre);
        if (livres.size() > 0) {
            System.out.println("Liste des livres : ");

            for (Livre livre : livres) {
                System.out.println(livre);
                out.println(livre.toCSV(";"));
            }
            out.close();
        }

    }

}
