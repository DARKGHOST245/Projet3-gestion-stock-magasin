import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        GestionStock gestion = new GestionStock();
        Scanner sc = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println("\n=== GESTION DU STOCK ===");
            System.out.println("1. Afficher tous les produits");
            System.out.println("2. Ajouter un produit");
            System.out.println("3. Modifier un produit");
            System.out.println("4. Supprimer un produit");
            System.out.println("5. Rechercher un produit");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option (1-6) : ");

            String choix = sc.nextLine().trim();

            switch (choix) {
                case "1" -> gestion.afficherTousLesProduits();
                case "2" -> gestion.ajouterProduit();
                case "3" -> gestion.modifierProduit();
                case "4" -> gestion.supprimerProduit();
                case "5" -> gestion.rechercherProduit();
                case "6" -> {
                    System.out.println("Au revoir !");
                    continuer = false;
                }
                default -> System.out.println("Option invalide. Veuillez choisir entre 1 et 6.");
            }
            if (continuer) {
                continuer = gestion.continuerOuQuitter();
            }
        }
        sc.close();
    }
}
