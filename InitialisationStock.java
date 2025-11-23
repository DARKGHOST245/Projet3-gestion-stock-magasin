import java.util.ArrayList;
public  class InitialisationStock {
    public static ArrayList<ProduitElectronique> produitsInit() {
        ArrayList<ProduitElectronique> Produit = new ArrayList<>() ;
        Produit.add(new Electromenager("EL001 ", " Réfrigérateur LG " , "LG ",450,10, " Frigo basse " ,150,120, "Cuisine "));
        Produit.add(new Electromenager(" EL002 ", "Micro-onde Samsung ", "Samsung ",120,7, " Micro-onde 800W ",800,50, " Cuisine " ));
        Produit.add(new Electromenager("EL003 " , " Lave-linge Bosch " , " Bosch " ,600,5, " Lave-linge 7kg ",1000,200, " Buanderie "));
        Produit.add(new Electromenager( "EL004 ", "Climatiseur LG", "LG ",750,3, "Climatisation 12000 BTU ",1500,400, " Chambre ")) ;
        Produit.add(new Electromenager(" EL005 ", "Four Electrolux ", "Electrolux ",500,6, "Four électrique ",2000,300, "Cuisine ")) ;
        Produit.add(new EquipementInformatique("IT100", "Ordinateur Portable HP " , "HP ",850,5, " Laptop Core i5 ", " Laptop " , "Windows 11 " ,512)) ;
        Produit.add(new EquipementInformatique("IT101" , "Tablette Samsung " , "Samsung ",300,12, "Tablette Android ", "Tablette", "Android 13 ",128)) ;
        Produit.add(new EquipementInformatique(" IT102 ", "Ordinateur Bureau Dell ", "Dell ",1200,4, "PC fixe i7 ", "PC ", "Windows 11 ",1024)) ;
        Produit.add(new EquipementInformatique(" IT103 ", "Laptop Asus ", "Asus ",900,6, "Laptop i5 ", "Laptop ", "Windows 11 ",512)) ;
        Produit.add(new EquipementInformatique(" IT104 ", "Serveur HP ", "HP ",2000,2, "Serveur entreprise ", "Serveur ", "Linux ",2048)) ;
        Produit.add(new AccesoireElectronique( "ACO20" , "Chargeur Type-C ", "Samsung ",20,15, "Chargeur rapide Android" , "Android Type-C ",12, "Noir ")) ;
        Produit.add(new AccesoireElectronique(" ACO21 ", "Souris Logitech ", "Logitech ",25,10, "Souris sans fil ", "PC ",24, "Gris ")) ;
        Produit.add(new AccesoireElectronique(" ACO22 ", " Clavier Razer ", "Razer ",50,8, "Clavier gamer ", "PC ",24, "Noir ")) ;
        Produit.add(new AccesoireElectronique(" ACO23 ", "Casque Sony ", "Sony ",75,6, "Casque audio Bluetooth ", "PC/Smartphone",12, "Bleu ")) ;
        Produit.add(new AccesoireElectronique(" ACO24 ", " Câble HDMI ", "Belkin ",15,20, "Câble HDMI 2m ", "Toutes plateformes ",12, "Noir ")) ;
        return Produit;
    }
}
