package personnesadresses;

import java.util.ArrayList;

public class PersonnesAdresses {

    public static void main(String[] args) {
        // TODO code application logic here

        Personne p = new Personne("MichMich",
                new Adresse("rue de la paix",
                        "ville de la paix"));

        System.out.println(p.toString());

        p.getAdresse().setRue("rue en guerre");
        System.out.println(p.toString());
        p.getAdresse().setVille("Oh que c'est moche");
        System.out.println(p.toString());

        Adresse a = new Adresse("hihihi", "ohohoh");
        p.setAdresse(a);
        System.out.println(p.toString());

        ArrayList<Personne> pepe = new ArrayList<>();

        pepe.add(p);

        System.out.println(pepe.get(0).toString());
        System.out.println("------------------");
        pepe.add(new Personne("ChimChim",
                new Adresse("paix drue",
                        "paiville")));
        for (Personne indP : pepe) {
            System.out.println(indP.toString());
        }

    }

}
