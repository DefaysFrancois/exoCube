/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exocube;

import java.util.Scanner;

public class ExoCube {

    public static void main(String[] args) {
        // TODO code application logic here
        Cube c1 = new Cube();
        try {
            c1.setColor(200, 50, 255);
            c1.setLenght(10);
            c1.setName("le cube");

        } catch (NotAColorException e) {
            System.out.println("color");
        } catch (StringToLongOrShortException e) {
            System.out.println("name");
        } catch (NotPositiveException e) {
            System.out.println("length");
        } catch (Exception e) {

        }
        System.out.println(c1.toString());

        while (askName(c1)) {
        }
        while (askColor(c1)) {
        }
        while (askLenght(c1)) {
        }

        System.out.println(c1.toString());

    }

    public static boolean askColor(Cube c) {
        int red, green, blue;
        Scanner keyb = new Scanner(System.in);

        System.out.println("Couleur");
        System.out.println("-------");
        System.out.println("Entrez les valeurs (0-255) pour : ");
        System.out.print("Red    : ");
        red = keyb.nextInt();
        System.out.print("Green  : ");
        green = keyb.nextInt();
        System.out.print("Blue   : ");
        blue = keyb.nextInt();

        try {
            c.setColor(red, green, blue);
            System.out.println("Merci, nouvelle couleur : " + c.getColor());
            System.out.println();
            return (false);
        } catch (NotAColorException e) {
            return (true);
        }

    }

    public static boolean askLenght(Cube c) {
        int lenght;
        Scanner keyb = new Scanner(System.in);

        System.out.println("Longueur");
        System.out.println("--------");
        System.out.print("Entrez la longueur : ");
        lenght = keyb.nextInt();
        System.out.println("");
        try {
            c.setLenght(lenght);
            System.out.println("Merci, nouvelle longueur : " + c.getLenght());
            System.out.println();
            return (false);
        } catch (NotPositiveException e) {
            return (true);
        }

    }

    public static boolean askName(Cube c) {
        String name;
        Scanner keyb = new Scanner(System.in);

        System.out.println("Nom");
        System.out.println("---");
        System.out.print("Entrez le nom : ");
        name = keyb.nextLine();
        System.out.println("");
        try {
            c.setName(name);
            System.out.println("Merci, nouveau nom : " + c.getName());
            System.out.println();
            return (false);
        } catch (StringToLongOrShortException e) {
            return (true);
        }

    }

}
