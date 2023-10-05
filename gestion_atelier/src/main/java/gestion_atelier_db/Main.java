package gestion_atelier_db;
import java.util.Scanner;

import gestion_atelier_db.entities.Categorie;
import gestion_atelier_db.repositories.ITables;
import gestion_atelier_db.repositories.list.TableCategories;
import gestion_atelier_db.services.CategorieService;
import gestion_atelier_db.services.CategorieServiceImpl;

public class Main {
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) throws Exception {
         ITables<Categorie> repository=new TableCategories();
         CategorieService categorieServiceImpl=new CategorieServiceImpl(repository);
        int choix;
        do {
            
            System.out.println("-------MENU GENERAL-------");
            System.out.println("1---- Ajouter categorie");
            System.out.println("2----Lister les categories");
            System.out.println("3----Modifier une categorie");
            System.out.println("4----Editer une categorie");
            System.out.println("5----Supprime les categories");
            System.out.println("6----Quitter");
            System.out.print("Choisir votre option: ");
            choix=scanner.nextInt();
            scanner.nextLine();
            switch(choix){
                case 1:
                    effacer();
                    System.out.println("Entrer le libelle :");
                    Categorie categorie=new Categorie(scanner.nextLine());
                    categorieServiceImpl.add(categorie);
                    break;
                case 2:
                    effacer();
                    categorieServiceImpl.getAll().forEach(System.out::println);
                    break;
                
                case 3:
                    effacer();
                    categorieServiceImpl.getAll().forEach(System.out::println);
                    System.out.println("Entrer l'id de la categorie a modifier :");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(idToUpdate);
                    Categorie categorieUpdate= categorieServiceImpl.show(idToUpdate);
                    if(categorieUpdate !=null){
                        System.out.println("Entrez un nouveau libelle:");
                        String newLiblelle = scanner.nextLine();
                        categorieUpdate.setLibelle(newLiblelle);
                        categorieServiceImpl.update(categorieUpdate);
                        System.out.println("La categorie a été modifié.");        
                    }else{
                        System.out.println("echec");
                    }
                    
                case 4:
                    break;     
                case 5:
                    effacer();
                    categorieServiceImpl.getAll().forEach(System.out::println);
                    System.out.println("Entrer l'id de la categorie a supprimer: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine();
                    Categorie categorieToDelete = categorieServiceImpl.show(idToDelete);
                    if (categorieToDelete != null) {
                        categorieServiceImpl.remove(categorieToDelete.getId());
                        System.out.println("La categorie a été supprimée.");
                    } else {
                        System.out.println("echec");
                    }
                    break;   
                default:
                break;

            }
        } while (choix!=6);
        
    }
    

    public static void effacer(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    } 
}
       