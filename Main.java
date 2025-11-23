import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        GestionStock gestion  = new GestionStock() ;
        boolean quitter = false;
        Scanner sc = new Scanner(System.in) ;
        while( !quitter) {
            System.out.println(" \n=== GESTION DU STOCK === ");
            System.out.println(" 1. Ajouter un produit ");
            System.out.println(" 2. Supprimer un produit ");
            System.out.println(" 3. Modifier un produit " );
            System.out.println(" 4. Afficher tous les produits ");
            System.out.println(" 5. Rechercher un produit ");
            System.out.println(" 6. Quitter ") ;
            System.out.print(" Choisissez une option : " );
            int choix = Integer.parseInt(sc.nextLine()) ;
            switch (choix) {
                case 1 :
                    gestion.ajouterProduit();
                    quitter = !gestion.continuerOuQuitter();
                    break;
                case 2 :
                    gestion.supprimerProduit();
                    quitter = !gestion.continuerOuQuitter();
                    break;
                case 3 :
                    gestion.modifierProduit();
                    quitter = !gestion.continuerOuQuitter();
                    break;
                case 4 :
                    gestion.afficherTousLesProduits();
                    quitter = !gestion.continuerOuQuitter();
                    break;
                case 5 :
                    gestion.rechercherProduit();
                    quitter = !gestion.continuerOuQuitter();
                    break;
                case 6 :
                    System.out.println(" Au revoir ! ");
                    quitter = true;
                    break;
                default:
                    System.out.println(" Option invalide ! ");
                    break;
            }

        }
    }
}