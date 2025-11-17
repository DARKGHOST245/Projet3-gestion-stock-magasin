public class AccesoireElectronique  extends ProduitElectronique {
    private String compatibilite;
    private int garantieMois;
    private String couleur;
    public AccesoireElectronique(String codeProduit, String nomProduit, String marque, double prix, int quantite,String descrption, String compatibilite, int garantieMois, String couleur ) {
        super(codeProduit,nomProduit,marque,prix,quantite,descrption);
        this.garantieMois=garantieMois;
        this.couleur=couleur;
        this.compatibilite=compatibilite;
    }
    public String getCompatibilite() {
        return compatibilite;
    }
    public void setCompatibilite(String compatibilite) {
        this.compatibilite = compatibilite;
    }
    public int getGarantieMois() {
        return garantieMois;
    }
    public void setGarantieMois(int garantieMois) {
        this.garantieMois = garantieMois;
    }
    public String getCouleur() {
        return couleur;
    }
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
    public String afficherProduit(){
        return super.afficherProduit() + "  Compatibilité: " + compatibilite + "\n" + "  Garantie: " + garantieMois + " mois\n" + " Couleur: " + couleur + "\n" ;
    }
}