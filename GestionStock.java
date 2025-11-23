import java.util.ArrayList;
import java.util.Scanner;
public class GestionStock {
    private ArrayList<ProduitElectronique> stock;
    private Scanner sc = new Scanner(System.in);
    public GestionStock() {
        stock = InitialisationStock.produitsInit();
    }
    public void ajouterProduit() {
        System.out.println("\n=== AJOUT D’UN PRODUIT ===");
        System.out.print("Code produit : ");
        String codeProduit = sc.nextLine();
        System.out.print(" Nom produit : ");
        String nomProduit = sc.nextLine();
        System.out.print(" Marque : ");
        String marque = sc.nextLine();
        System.out.print(" Prix : ");
        double prix = Double.parseDouble(sc.nextLine());
        System.out.print(" Quantité : ");
        int quantite = Integer.parseInt(sc.nextLine());
        System.out.print("Description : ");
        String description = sc.nextLine();

        System.out.println("Type de produit : 1=Electroménager, 2=Informatique, 3=Accessoire");
        int typeProduit =Integer.parseInt(sc.nextLine());

        switch (typeProduit) {
            case 1 -> {
                System.out.print("Puissance (W) : ");
                int puissance = Integer.parseInt(sc.nextLine());
                System.out.print("Consommation (kWh) : ");
                int consommation = Integer.parseInt(sc.nextLine());
                System.out.print("Catégorie : ");
                String categorie = sc.nextLine();
                stock.add(new Electromenager(codeProduit, nomProduit, marque, (float) prix, quantite, description, puissance, consommation, categorie));
            }
            case 2 -> { // Equipement Informatique
                System.out.print("Type : ");
                String type = sc.nextLine();
                System.out.print("Système : ");
                String systeme = sc.nextLine();
                System.out.print("Stockage (Go) : ");
                int Stockage = Integer.parseInt(sc.nextLine());
                stock.add(new EquipementInformatique(codeProduit, nomProduit, marque, prix, quantite, description, type, systeme, Stockage));
            }
            case 3 -> { // Accessoire Electronique
                System.out.print("Compatibilité : ");
                String compatibilite = sc.nextLine();
                System.out.print("Garantie (mois) : ");
                int garantieMois = Integer.parseInt(sc.nextLine());
                System.out.print("Couleur : ");
                String couleur = sc.nextLine();
                stock.add(new AccesoireElectronique(codeProduit, nomProduit, marque, prix, quantite, description, compatibilite, garantieMois, couleur));
            }
            default -> System.out.println("Type invalide !");
        }

        System.out.println("Produit ajouté avec succès !");
    }
    public void supprimerProduit() {
        System.out.print("Entrez le code du produit à supprimer : ");
        String codeProduit = sc.nextLine();
        boolean supprime = stock.removeIf(p -> p.getCodeProduit().equalsIgnoreCase(codeProduit));
        if (supprime) System.out.println("Produit supprimé !");
        else System.out.println("Produit non trouvé !");
    }
    public void modifierProduit() {
        System.out.print("Entrez le code du produit à modifier : ");
        String codeProduit = sc.nextLine();
        for (ProduitElectronique p : stock) {
            if (p.getCodeProduit().equalsIgnoreCase(codeProduit)) {
                System.out.println("Produit trouvé. Entrez les nouvelles valeurs :");
                System.out.print("Nom produit : ");
                p.setNomProduit(sc.nextLine());
                System.out.print("Marque : ");
                p.setMarque(sc.nextLine());
                System.out.print("Prix : ");
                p.setPrix(Double.parseDouble(sc.nextLine()));
                System.out.print("Quantité : ");
                p.setQuantite(Integer.parseInt(sc.nextLine()));
                System.out.print("Description : ");
                p.setDescription(sc.nextLine());

                if (p instanceof Electromenager em) {
                    System.out.print("Puissance (W) : ");
                    em.setPuissance(Integer.parseInt(sc.nextLine()));
                    System.out.print("Consommation (kWh) : ");
                    em.setConsommation(Integer.parseInt(sc.nextLine()));
                    System.out.print("Catégorie : ");
                    em.setCategorie(sc.nextLine());
                } else if (p instanceof EquipementInformatique ei) {
                    System.out.print("Type : ");
                    ei.setType(sc.nextLine());
                    System.out.print("Système : ");
                    ei.setSysteme(sc.nextLine());
                    System.out.print("Stockage (Go) : ");
                    ei.setStockage(Integer.parseInt(sc.nextLine()));
                } else if (p instanceof AccesoireElectronique ae) {
                    System.out.print("Compatibilité : ");
                    ae.setCompatibilite(sc.nextLine());
                    System.out.print("Garantie (mois) : ");
                    ae.setGarantieMois(Integer.parseInt(sc.nextLine()));
                    System.out.print("Couleur : ");
                    ae.setCouleur(sc.nextLine());
                }

                System.out.println("Produit modifié avec succès !");
                return;
            }
        }
        System.out.println("Produit non trouvé !");
    }
    public void afficherTousLesProduits() {
        if (stock.isEmpty()) System.out.println("Aucun produit en stock.");
        else {
            System.out.println("\n=== LISTE DES PRODUITS ===");
            for (ProduitElectronique p : stock) {
                System.out.println(p.afficherProduit() + "\n-----------------");
            }
        }
    }
    public void rechercherProduit() {
        System.out.print("Entrez le code du produit à rechercher : ");
        String codeProduit = sc.nextLine();
        for (ProduitElectronique p : stock) {
            if (p.getCodeProduit().equalsIgnoreCase(codeProduit)) {
                System.out.println("Produit trouvé :");
                System.out.println(p.afficherProduit());
                return;
            }
        }
        System.out.println("Produit non trouvé !");
    }

    public boolean continuerOuQuitter() {
        System.out.print("Voulez-vous revenir au menu principal ? (oui/non) : ");
        return sc.nextLine().equalsIgnoreCase("oui");
    }
}

