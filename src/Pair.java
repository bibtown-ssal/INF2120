/**
 * Classe qui permet a des methodes de retourner 2 valeurs generique
 */

public class Pair <T,U>{
    public T premiere;
    public U deuxieme;

    /**
     * Pas de champs static generique. (Static T var =... ne fonctionnera pas... variable de classe, mais de differents type...)
     *
     * Pas de casting vers generique ((U)a marche pas)
     *
     * Pas de new U generique (new U() marche pas)
     *
     * Pas de instanceOf ( a instanceOf U marche pas)
     *
     * par contre, premiere instanceOf Fraction fonctionne.
     *
     * peut pas declarer un tableau de type generique. T[] test3 marche pas.
     * on peut recevoir un T[], par contre.
     *
     *
     * On peut recursivé des types generiques: Pair<Pair<String,Integer>,Fraction> p3 = new Pair<>(new Pair<>("allo,4),new Fraction(3,4));
     *
     * @param premiere
     * @param deuxieme
     */
    public Pair(T premiere, U deuxieme){
        this.premiere = premiere;
        this.deuxieme = deuxieme;
    }

}
/*Pourquoi est-ce que ça c'est mieux que de faire des variables objects?
    public static void main(String[] args){
        Pair<String,Integer> test = new Pair<>("allo",4);
        Pair<String,Fraction> test2 = new Pair<>("b", new Fraction(3,5));

        System.out.print(test2.deuxieme.getDenominateur()); //Compile!
    }   test peut donc UNIQUEMENT contenir des pairs String/Integer, rien d'autre




 */