
public class  Electromenager extends ProduitElectronique {
    private int puissance;
    private int consommation;
    private String categorie;
    public Electromenager(String codeProduit, String nomProduit, String marque, Double prix, int quantite, String descrption, int puissance, int consommation, String categorie) {
        super(codeProduit,nomProduit,marque,prix,quantite,descrption);
        this.puissance=puissance;
        this.consommation=consommation;
        this.categorie=categorie;
    }
    public int getPuissance() {
        return puissance;
    }
    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }
    public int getConsommation() {
        return consommation;
    }
    public void setConsommation(int consommation) {
        this.consommation = consommation;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public String afficherProduit() {
        return super.afficherProduit() + " Puissance : " + puissance + " W\n" + "  Consommation : " + consommation + " kwh \n" + " Categorie : " + categorie + "\n" ;
    }
}
