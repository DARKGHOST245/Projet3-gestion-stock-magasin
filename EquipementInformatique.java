public class EquipementInformatique extends ProduitElectronique{
    private String type;
    private String systeme;
    private int Stockage;
    public EquipementInformatique(String codeProduit, String nomProduit, String marque, double prix, int quantite,String descrption,String type, String systeme, int Stockage) {
        super(codeProduit,nomProduit, marque,prix, quantite, descrption );
        this.type=type;
        this.systeme=systeme;
        this.Stockage=Stockage;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSysteme() {
        return systeme;
    }
    public void setSysteme(String systeme) {
        this.systeme = systeme;
    }
    public int getStockage() {
        return Stockage;
    }

    public void setStockage(int stockage) {
        this.Stockage = stockage;
    }

    public String afficherProduit() {
        return super.afficherProduit() + "  Type: " + type + "\n" + " Systeme: " + systeme + "\n" + " Stockage: " + Stockage + " GO\n";
    }
}