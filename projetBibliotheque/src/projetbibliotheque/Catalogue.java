package projetbibliotheque;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Catalogue {

//éliminer la cache:    private ArrayList<Livre> ls = new ArrayList<>();
    private final Connection connection;

    public Catalogue() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");//charge le driver pour mysql
        connection = DriverManager.getConnection(
                //"jdbc:mysql://localhost/librairie", "root", "");//crée la connection avec la DB
                "jdbc:mysql://localhost:3306/bibliotheque", "testuser", "");
    }

    public void add(Livre l) throws ClassNotFoundException, SQLException {
        //sql insert
        Statement statement = connection.createStatement();

        // Select the columns from the Student table
        statement.executeUpdate("INSERT INTO `bibliotheque`.`livre` "
                + "(`titre`, `auteur`) VALUES "
                + "('" + l.getTitre() + "', '" + l.getAuteur() + "');");

    }

    public void update(Livre l) throws SQLException {
        //sql update where id
        Statement statement = connection.createStatement();

        // Select the columns from the Student table
        statement.executeUpdate("UPDATE `bibliotheque`.`livre` "
                + "SET titre = '" + l.getTitre() + "', "
                + "auteur = '" + l.getAuteur() + "' "
                + "WHERE id = " + l.getId());
    }

    public void delete(int id) throws SQLException {
        // sql delete where id
        Statement statement = connection.createStatement();

        // Select the columns from the Student table
        statement.executeUpdate("DELETE FROM `bibliotheque`.`livre` "
                + " where id=" + id);

    }

    public void deleteAuteur(String auteur) throws SQLException {
        // sql delete where id
        Statement statement = connection.createStatement();

        // Select the columns from the Student table
        statement.executeUpdate("DELETE FROM `bibliotheque`.`livre` "
                + " where auteur = \""
                + auteur + "\"");
    }

    public Livre read(int id) throws SQLException {
        //select where id
        Statement statement = connection.createStatement();

        // Select the columns from the Student table
        ResultSet resultSet = statement.executeQuery("select id,titre,auteur from livre "
                + " where id=" + id);
        resultSet.next();
        return new Livre(resultSet.getInt(1),
                resultSet.getString(2), resultSet.getString(3));
    }

    public ArrayList<Livre> read() throws ClassNotFoundException, SQLException {

        Statement statement = connection.createStatement();

        // Select the columns from the Student table
        ResultSet resultSet = statement.executeQuery("select id,titre,auteur from livre");

        ArrayList<Livre> listeLivre = new ArrayList<>();
        while (resultSet.next()) {
            listeLivre.add(new Livre(resultSet.getInt(1),
                    resultSet.getString(2), resultSet.getString(3)));
        }

        return listeLivre;
    }

    ArrayList<Livre> readByAuteur(String auteur) throws SQLException, ClassNotFoundException {

        Statement statement = connection.createStatement();

        // Select the columns from the Student table
        ResultSet resultSet = statement.executeQuery("select id,titre,auteur from livre where auteur = \""
                + auteur + "\"");

        ArrayList<Livre> listeLivre = new ArrayList<>();
        while (resultSet.next()) {

            listeLivre.add(new Livre(resultSet.getInt(1),
                    resultSet.getString(2), resultSet.getString(3)));
        }

        return listeLivre;
    }

}
