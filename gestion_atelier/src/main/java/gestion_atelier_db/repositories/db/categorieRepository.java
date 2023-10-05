package gestion_atelier_db.repositories.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import gestion_atelier_db.entities.Categorie;
import gestion_atelier_db.repositories.ITables;

public class categorieRepository implements ITables<Categorie>{

    @Override
    public int insert(Categorie data) {
        int nbreLigne=0;
        ArrayList<Categorie> categories=new ArrayList<>();
        try {
            //etape 1: charger la classe de driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // etape 2: creer l'objet de connexion
            Connection connection = DriverManager
                                    .getConnection("jdbc:mysql://localhost:8889/couture-projet" +
                                    "","root", "toor");
            //classe preparedStatement => Executer les requetes prepares                        
            String sql="select id,libelle from categories where id=?";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setString(1,data.getLibelle());
            ResultSet rs=statement.executeQuery();
            if(rs.next()){
                Categorie categorie= new Categorie (rs.getInt("id"),rs.getString("libelle"));
                categories.add(categorie);
            }
            connection.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("erreur de chargement de Driver");
        }catch(ClassNotFoundException e){
            System.out.println("erreur de chargemant de Driver");
        }
        return null;
    }

    @Override
    public int update(Categorie data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArrayList<Categorie> findAll() {
        ArrayList<Categorie> categories=new ArrayList<>();
        try {
            //etape 1: charger la classe de driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // etape 2: creer l'objet de connexion
            Connection connection = DriverManager
                                    .getConnection("jdbc:mysql://localhost:8889/couture-projet" +
                                    "","root", "toor");
            //classe preparedStatement => Executer les requetes prepares                        
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("select id,libelle from categorie");
            if(rs.next()){
                Categorie categorie= new Categorie (rs.getInt("id"),rs.getString("libelle"));
                categories.add(categorie);
            }
            connection.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("erreur de chargement de Driver");
        }catch(ClassNotFoundException e){
            System.out.println("erreur de chargemant de Driver");
        }
        return null;
    }

    @Override
    public Categorie findById(int id) {
        ArrayList<Categorie> categories=new ArrayList<>();
        try {
            //etape 1: charger la classe de driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // etape 2: creer l'objet de connexion
            Connection connection = DriverManager
                                    .getConnection("jdbc:mysql://localhost:8889/couture-projet" +
                                    "","root", "toor");
            //classe preparedStatement => Executer les requetes prepares                        
            String sql="select id,libelle from categories where id=?";
            PreparedStatement statement=connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet rs=statement.executeQuery();
            if(rs.next()){
                Categorie categorie= new Categorie (rs.getInt("id"),rs.getString("libelle"));
                categories.add(categorie);
            }
            connection.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("erreur de chargement de Driver");
        }catch(ClassNotFoundException e){
            System.out.println("erreur de chargemant de Driver");
        }
        return null;
    }

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public int indexOf(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'indexOf'");
    }
    
}
