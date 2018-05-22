
public class cour2 {

    public static void echanger(Object [] t, int i, int j){
        Object temp = t[i];
        t[i] = t[j];
        t[j] = temp;
    }//pas tres secure, on peut avoir un tableau qui contient int, string et Fraction en meme temps.
    //on va recevoir  en argument le type du tableau
        //Type Generique.
        //note <variableType>
    public static <T> void echangerMieux(T [] t, int i, int j){
        T temp = t[i];
        t[i] = t[j];
        t[j] = temp;
    }
    //int -> Integer

    //limite les types possibles au PieceEchec et ceux qui en herite
    public static <T extends PieceEchec> void echangerMieuxLimite(T [] t, int i, int j){
        T temp = t[i];
        t[i] = t[j];
        t[j] = temp;
    }



}
