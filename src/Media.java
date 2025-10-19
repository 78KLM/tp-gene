public abstract class Media
{
    private String titre;
    private int anneePublication;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public Media() {
    }

    public Media(String titre, int anneePublication) {
        this.titre = titre;
        this.anneePublication = anneePublication;
    }

    @Override
    public String toString() {
        String g = titre + "(" + anneePublication + ")";
        return g;
    }

    public abstract String getDescription();

    public void afficherDetails() {
        System.out.println(getDescription());
    }
}
