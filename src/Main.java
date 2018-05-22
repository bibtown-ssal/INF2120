import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        ArrayList<String> t = new ArrayList<>();
        t.add("allo");  //case 0
        t.add("comment");  //case 1
        t.add("va");  //case 2    add change la taille du tableau
        t.add(2, "ca"); //t = "allo", "comment", "ca", "va"
                    // "va" est maintenant a la case 3
        for (int i = 0; i < t.size(); i++){
            System.out.println( t.get( i ) );
        }
        t.set(1, "test");
        t.remove(1);

        PieceEchec p = new Tour(1, Colonne.A);

        System.out.println(p.getClass().getName());


    }
}
