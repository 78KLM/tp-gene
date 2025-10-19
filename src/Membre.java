import java.util.List;

public class Membre {
    private String nom;
    private int id;
    private List<Media> mediasEmpruntes;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Media> getMediasEmpruntes() {
        return mediasEmpruntes;
    }

    public void setMediasEmpruntes(List<Media> mediasEmpruntes) {
        this.mediasEmpruntes = mediasEmpruntes;
    }

    public Membre(String nom, int id) {
        this.nom = nom;
        this.id = id;
    }

    public void emprunterMedia(Media media){
        mediasEmpruntes.add(media);
    }

    @Override
    public String toString() {
        return "Membre { " + nom + ", " + id + "}";
    }
}
