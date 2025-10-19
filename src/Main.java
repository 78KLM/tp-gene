import java.util.*;
import java.util.function.Predicate;


public class Main {

    // Méthode 1 : afficherListe
    public static <T> void afficherListe(List<T> liste) {
        for (T element : liste) {
            System.out.println(element);
        }
    }

    // Méthode 2 : filtrer
    public static <T> List<T> filtrer(List<T> liste, Predicate<T> critere) {
        List<T> resultat = new ArrayList<>();
        for (T element : liste) {
            if (critere.test(element)) {
                resultat.add(element);
            }
        }
        return resultat;
    }

    public static void trierMedia(List<Media> liste) {
        liste.sort(
                Comparator
                        .comparing(Media::getAnneePublication)
                        .reversed()
                        .thenComparing(Media::getTitre, String.CASE_INSENSITIVE_ORDER)
        );
        System.out.println(liste);
    }

    public static void trierLivre(List<Media> medias) {
        List<Livre> livres = new ArrayList<>();
        for (Media m : medias) {
            if (m instanceof Livre) {
                livres.add((Livre) m);
            }
        }

        livres.sort(
                Comparator
                        .comparing(Livre::getAuteur, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(Media::getTitre, String.CASE_INSENSITIVE_ORDER)
        );
        System.out.println(livres);
    }

    public static <T> void copierCollection(Collection<T> source, Collection<T> destination) {
        destination.clear(); // (optionnel) on vide la destination avant
        destination.addAll(source); // on copie tout
    }

    public static Set<Media> mediasEmpruntesSansDoublons(Map<Membre, List<Media>> emprunts) {
        Set<Media> tousLesMedias = new HashSet<>();

        for (Map.Entry<Membre, List<Media>> entry : emprunts.entrySet()) {
            List<Media> listeMedias = entry.getValue();
            if (listeMedias != null) {
                tousLesMedias.addAll(listeMedias);
            }
        }

        return tousLesMedias;
    }

    public static void main(String[] args) {

        Livre l1 = new Livre("pp", 2015, "molière", 15);
        Livre l2 = new Livre("qq", 2016, "voltaire", 16);
        Livre l3 = new Livre("dd", 2017, "galère", 17);
        CD c1 = new CD("gg", 2000, "koffi", 11);
        CD c2 = new CD("hh", 2001, "loketo", 12);
        CD c3 = new CD("gg", 2002, "Yorssy", 13);

        List<Media> Medias1 = new ArrayList<>();
        List<Media> Medias2 = new ArrayList<>();
        Medias1.add(c1);
        Medias1.add(l1);
        Medias1.add(c2);
        List<Media> mediasM2 = new ArrayList<>(List.of(l2, c1));

        Set<Membre> ms = new HashSet<>();
        Membre m1 = new Membre("klm", 1);
        Membre m2 = new Membre("james", 2);
        Membre m3 = new Membre("drys", 3);

        ms.add(m1);
        ms.add(m2);
        ms.add(m3);


        Map<Membre, List<Media>> emprunts = new HashMap<>();
        emprunts.put(m1, Medias1);
        emprunts.put(m2, mediasM2);

        Set<Media> mediasSansDoublons = mediasEmpruntesSansDoublons(emprunts);
        System.out.println("Médias empruntés sans doublons :");
        afficherListe(new ArrayList<>(mediasSansDoublons));

        List<Media> livres = filtrer(Medias1, m -> m instanceof Livre);
        System.out.println("Médias de type Livre :");
        afficherListe(livres);
        System.out.println("trier Livre test :");
        trierLivre(Medias1);


    }
}


