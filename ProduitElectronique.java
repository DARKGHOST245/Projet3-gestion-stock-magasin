public class ProduitElectronique {
    protected String codeProduit;
    protected String nomProduit;
    protected String marque;
    protected double prix;
    protected int quantite;
    protected String description;
    public ProduitElectronique(String codeProduit, String nomProduit, String marque, double prix, int quantite, String description) {
        this.codeProduit=codeProduit;
        this.nomProduit=nomProduit;
        this.marque=marque;
        this.prix=prix;
        this.quantite=quantite;
        this.description=description;
    }
    public String getCodeProduit() {
        return codeProduit;
    }
    public void setCodeProduit(String codeProduit) {
        this.codeProduit=codeProduit;
    }
    public String getNomProduit() {
        return nomProduit;
    }
    public void setNomProduit(String nomProduit) {
        this.nomProduit=nomProduit;
    }
    public String getMarque() {
        return marque;
    }
    public void setMarque(String marque) {
        this.marque=marque;
    }
    public double getPrix() {
        return prix;
    }
    public void setPrix(double prix) {
        this.prix=prix;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite=quantite;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String afficherProduit() {
        return  " Code : " + codeProduit + "\n" + " Nom : " + nomProduit + "\n" + "  Marque : " + marque + "\n" +  "  Prix : " + prix + " USD\n" + "  Quantite : " + quantite + "\n" + "  Description : " + description + "\n" ;
    }
}