import java.util.ArrayList;

public class Cours3 {
    /*Interface: permet de construire des caracteristique pour des types de donnees
    *
    * Contrat pour des methodes (signature)
    *
    * pour se qualifier, il faut ecrire le code des methodes
    *
    * Resoud a probleme similaire a celui que l'heritage resoud. (heritage etant une solution locale, interface etant un
    * peu plus abstrait
    *
    * */

    public static boolean estTrier(int [] tab){
        boolean resultat = true;
        int i = 0;

        for(int j = 0; j < tab.length-1; j++){

            /*if(tab[j] > tab[j+1]){
                resultat = false;
            }*///pas ideal.. if = boolean, + operation booleane...

          //  resultat = resultat && (tab[j] > tab[j+1]);
        }


        while(resultat && i < tab.length -1) {
            resultat = (tab[i] < tab[i+1]); //change la comparaison, puisque la boucle continue lorsque vrai..
            i++;
        }

        return resultat;
    }

    /**
     *
     * @param tab
     * @return
     */
    // ">" n'est pas une operation acceptee...
    //Si on cree l'interface "SontComparable"
    public static <E extends SontComparable<? super E>> boolean estTrier(E [] tab){

        boolean resultat = true;
        int i = 0;
        while(resultat && i < tab.length -1) {
            resultat = tab[i].plusPetitQue(tab[i+1]);
            i++;
        }
        return resultat;
    }

    public static double sommeAires(Surface a, Surface b){
        return a.aire()+b.aire();
    }


    public static void main(String[] args) {
        Fraction [] t = new Fraction[5];
        t[0] = new Fraction(8,2);
        t[1] = new Fraction(3,2);
        t[2] = new Fraction(5,2);
        t[3] = new Fraction(7,2);
        t[4] = new Fraction (9,2);
        if(estTrier( t )){
            System.out.println("trie!");
        }else{
            System.out.println("Non trie :(");
        }

        ArrayList<Fraction> t3 = new ArrayList<>();
        for(Fraction f : t){
            t3.add(f);
        }

        System.out.println(sommeAires(new Rectangle(1,2),new Cercle(1)));

        Surface t1[] = new Surface[3];
        t1[1] = new Rectangle(1,2);
        t1[0] = new Cercle(1);
        t1[2] = new Cercle(3.14);

        for(int i = 0; i < t1.length; i++){
            System.out.println( t1[i].perimetre());
        }
        //Puisque Array implement Iterateur, on peut faire ceci:
        for(Surface s : t1){
            System.out.println( s.perimetre());
        }
        //ArrayList l'implemente aussi!

        ArrayList<Surface> t2 = new ArrayList<>();
        for(Surface s : t1){
            t2.add(s);
        }
        for(Surface s : t2){
            System.out.println( s.perimetre());
        }
        /*== Surface s;
        for(new Iterator<Surface> it = t2.iterator(); it.hasNext(); s = it.next()){  blah blah  }
         */
        t3.forEach(System.out::println);

    }

}

/*
pour type generique:
E extends X     : E est AU MOINS X (X, ou une classe qui en herite)

<? super E>     : de la classe E ou une classe dont E herite

Donc, <E extends SontComparable<? super E> : E est au moins SontComparable ET ce que la variable de type E est compare
                                                                avec doit etre de type E ou quelque chose dont E herite
 */