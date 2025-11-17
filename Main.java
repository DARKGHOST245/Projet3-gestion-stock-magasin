public class Main {
    public static void main(String[] args) {
        Electromenager frigo = new Electromenager(
                "EL001",
                "Réfrigirateur LG 300L",
                "LG",
                450.2F,
                50,
                "Frigo basse",
                150,
                120,
                "Cuisine"
        );
        EquipementInformatique laptop = new EquipementInformatique(
                "IT100",
                "Ordinateur Portable",
                "HP",
                850.2F,
                150,
                "Laptop Core i5",
                "Laptop",
                "Windows 11",
                512
        );
        AccesoireElectronique chargeur = new AccesoireElectronique(
                "ACO20",
                "Chargeur Type-C 25W",
                "Samsung",
                20.2F,
                100,
                "Chargeur rapide compatible Android",
                "Android Type-C",
                1,
                "Noir"
        );
     System.out.println("=== FICHE DE STOCK DU MAGASIN === \n");
     System.out.println(frigo.afficherProduit());
     System.out.println(laptop.afficherProduit());
     System.out.println(chargeur.afficherProduit());
    }
}