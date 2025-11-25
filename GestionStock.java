import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class GestionStock {
    private final ArrayList<ProduitElectronique> stock;
    private final Scanner sc = new Scanner(System.in);
    public GestionStock() {
        stock = new ArrayList<>();
        loadFromFile(); // charge depuis stock.txt
        if (stock.isEmpty()) { // si fichier vide, initialise stock de base
            stock.addAll(InitialisationStock.getStock());
            saveToFile();
        }
    }
    public void ajouterProduit() {
        System.out.println("\n=== AJOUT D’UN PRODUIT ===");
        System.out.print("Code produit : ");
        String codeProduit = sc.nextLine().trim();
        System.out.print("Nom produit : ");
        String nomProduit = sc.nextLine().trim();
        System.out.print("Marque : ");
        String marque = sc.nextLine().trim();
        System.out.print("Prix : ");
        double prix = Double.parseDouble(sc.nextLine().trim());
        System.out.print("Quantité : ");
        int quantite = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Description : ");
        String description = sc.nextLine().trim();
        System.out.println("Type de produit : 1=Electroménager, 2=Informatique, 3=Accessoire");
        int typeProduit = Integer.parseInt(sc.nextLine().trim());
        switch (typeProduit) {
            case 1 -> { // Electroménager
                System.out.print("Puissance (W) : ");
                int puissance = Integer.parseInt(sc.nextLine().trim());
                System.out.print("Consommation (kWh) : ");
                int consommation = Integer.parseInt(sc.nextLine().trim());
                System.out.print("Catégorie : ");
                String categorie = sc.nextLine().trim();
                stock.add(new Electromenager(codeProduit, nomProduit, marque, prix, quantite, description, puissance, consommation, categorie));
            }
            case 2 -> { // Equipement Informatique
                System.out.print("Type : ");
                String type = sc.nextLine().trim();
                System.out.print("Système : ");
                String systeme = sc.nextLine().trim();
                System.out.print("Stockage (Go) : ");
                int stockage = Integer.parseInt(sc.nextLine().trim());
                stock.add(new EquipementInformatique(codeProduit, nomProduit, marque, prix, quantite, description, type, systeme, stockage));
            }
            case 3 -> { // Accessoire Electronique
                System.out.print("Compatibilité : ");
                String compatibilite = sc.nextLine().trim();
                System.out.print("Garantie (mois) : ");
                int garantieMois = Integer.parseInt(sc.nextLine().trim());
                System.out.print("Couleur : ");
                String couleur = sc.nextLine().trim();
                stock.add(new AccesoireElectronique(codeProduit, nomProduit, marque, prix, quantite, description, compatibilite, garantieMois, couleur));
            }
            default -> {
                System.out.println("Type invalide !");
                return;
            }
        }

        saveToFile();
        System.out.println("Produit ajouté avec succès !");
    }
    public void supprimerProduit() {
        System.out.print("Entrez le code du produit à supprimer : ");
        String codeProduit = sc.nextLine().trim();
        boolean supprime = stock.removeIf(p -> p.getCodeProduit().trim().equalsIgnoreCase(codeProduit));
        if (supprime) {
            saveToFile();
            System.out.println("Produit supprimé !");
        } else {
            System.out.println("Produit non trouvé !");
        }
    }
    public void modifierProduit() {
        System.out.print("Entrez le code du produit à modifier : ");
        String codeProduit = sc.nextLine().trim();
        for (ProduitElectronique p : stock) {
            if (p.getCodeProduit().trim().equalsIgnoreCase(codeProduit)) {
                System.out.println("Produit trouvé. Entrez les nouvelles valeurs :");
                System.out.print("Nom produit : ");
                p.setNomProduit(sc.nextLine().trim());
                System.out.print("Marque : ");
                p.setMarque(sc.nextLine().trim());
                System.out.print("Prix : ");
                p.setPrix(Double.parseDouble(sc.nextLine().trim()));
                System.out.print("Quantité : ");
                p.setQuantite(Integer.parseInt(sc.nextLine().trim()));
                System.out.print("Description : ");
                p.setDescription(sc.nextLine().trim());

                if (p instanceof Electromenager em) {
                    System.out.print("Puissance (W) : ");
                    em.setPuissance(Integer.parseInt(sc.nextLine().trim()));
                    System.out.print("Consommation (kWh) : ");
                    em.setConsommation(Integer.parseInt(sc.nextLine().trim()));
                    System.out.print("Catégorie : ");
                    em.setCategorie(sc.nextLine().trim());
                } else if (p instanceof EquipementInformatique ei) {
                    System.out.print("Type : ");
                    ei.setType(sc.nextLine().trim());
                    System.out.print("Système : ");
                    ei.setSysteme(sc.nextLine().trim());
                    System.out.print("Stockage (Go) : ");
                    ei.setStockage(Integer.parseInt(sc.nextLine().trim()));
                } else if (p instanceof AccesoireElectronique ae) {
                    System.out.print("Compatibilité : ");
                    ae.setCompatibilite(sc.nextLine().trim());
                    System.out.print("Garantie (mois) : ");
                    ae.setGarantieMois(Integer.parseInt(sc.nextLine().trim()));
                    System.out.print("Couleur : ");
                    ae.setCouleur(sc.nextLine().trim());
                }

                saveToFile();
                System.out.println("Produit modifié avec succès !");
                return;
            }
        }
        System.out.println("Produit non trouvé !");
    }
    public void afficherTousLesProduits() {
        if (stock.isEmpty()) {
            System.out.println("Aucun produit en stock.");
        } else {
            System.out.println("\n=== LISTE DES PRODUITS ===");
            for (ProduitElectronique p : stock) {
                System.out.println(p.afficherProduit() + "-----------------");
            }
        }
    }

    public void rechercherProduit() {
        System.out.print("Entrez le code du produit à rechercher : ");
        String codeProduit = sc.nextLine().trim();
        for (ProduitElectronique p : stock) {
            if (p.getCodeProduit().trim().equalsIgnoreCase(codeProduit)) {
                System.out.println("Produit trouvé :");
                System.out.println(p.afficherProduit());
                return;
            }
        }
        System.out.println("Produit non trouvé !");
    }
    public void saveToFile() {
        try (FileWriter writer = new FileWriter("stock.txt")) {
            for (ProduitElectronique p : stock) {
                String ligne = "";
                if (p instanceof Electromenager em) {
                    ligne = "Electromenager;" + em.getCodeProduit() + ";" + em.getNomProduit() + ";" +
                            em.getMarque() + ";" + em.getPrix() + ";" + em.getQuantite() + ";" +
                            em.getDescription() + ";" + em.getPuissance() + ";" + em.getConsommation() + ";" +
                            em.getCategorie();
                } else if (p instanceof EquipementInformatique ei) {
                    ligne = "EquipementInformatique;" + ei.getCodeProduit() + ";" + ei.getNomProduit() + ";" +
                            ei.getMarque() + ";" + ei.getPrix() + ";" + ei.getQuantite() + ";" +
                            ei.getDescription() + ";" + ei.getType() + ";" + ei.getSysteme() + ";" +
                            ei.getStockage();
                } else if (p instanceof AccesoireElectronique ae) {
                    ligne = "AccessoireElectronique;" + ae.getCodeProduit() + ";" + ae.getNomProduit() + ";" +
                            ae.getMarque() + ";" + ae.getPrix() + ";" + ae.getQuantite() + ";" +
                            ae.getDescription() + ";" + ae.getCompatibilite() + ";" + ae.getGarantieMois() + ";" +
                            ae.getCouleur();
                }
                writer.write(ligne + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde du stock : " + e.getMessage());
        }
    }
    public void loadFromFile() {
        stock.clear();
        File file = new File("stock.txt");
        if (!file.exists()) return; // si fichier n'existe pas, rien à charger
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] parts = ligne.split(";");
                switch (parts[0]) {
                    case "Electromenager" -> stock.add(new Electromenager(
                            parts[1], parts[2], parts[3], Double.parseDouble(parts[4]),
                            Integer.parseInt(parts[5]), parts[6],
                            Integer.parseInt(parts[7]), Integer.parseInt(parts[8]), parts[9]
                    ));
                    case "EquipementInformatique" -> stock.add(new EquipementInformatique(
                            parts[1], parts[2], parts[3], Double.parseDouble(parts[4]),
                            Integer.parseInt(parts[5]), parts[6],
                            parts[7], parts[8], Integer.parseInt(parts[9])
                    ));
                    case "AccessoireElectronique" -> stock.add(new AccesoireElectronique(
                            parts[1], parts[2], parts[3], Double.parseDouble(parts[4]),
                            Integer.parseInt(parts[5]), parts[6],
                            parts[7], Integer.parseInt(parts[8]), parts[9]
                    ));
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors du chargement du stock : " + e.getMessage());
        }
    }
    public boolean continuerOuQuitter() {
        System.out.print("Voulez-vous revenir au menu principal ? (oui/non) : ");
        return sc.nextLine().trim().equalsIgnoreCase("oui");
    }
}
