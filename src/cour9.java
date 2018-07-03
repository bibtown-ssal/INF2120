public class cour9 {

    /*resume cour 8
        GUI
            Composante (JLabel, JTextField, JButton)
            Container  (JFrame, JPanel)
            Layout     (Flow, Border, Grid, GridBag)
            Listener   (ActionListener)
    */



    //Algorithme:
        //Definition: Specification (certains niveau d'abstracction) des operations (manipulation) a faire pour effectuer
        //            une tache plus complexe

        //Comment: language specialise
        //         langage de prog
        //         informel (pour, tant que, math
        //         Graphe (Flu de controle)

        //Objectif: Premiere descr du code a ecrire
        //Anayle de ressource (tmps d'execution, memoire), prediction/comparer

        //complexite: spatiale/temporelle
        //            tx croissance
        //            algorithme: entree (taille n)
        //          Construire une fonction qui calcule le nb d'operation simple. (+, -, *, /, >, <, ==, !=, =)



        //Famille d'equation (ensemble)
        // Grand O (F(n))   famille d'equation qui on le meme tx de croissance, ou moins, que F(n)
        //                  F(n) = borne sup de la famille O(F(n))
        //                  G(n) appartien O(F(n))
        //                  s'il existe s, k > 0 tq tt n >= s, alors g(n) < k*F(n)

        //les grandes familles:
        //                      0(1)        : constant
        //                      O(log(n))   : logarithmique   (double qtté = augm tmps lineaire)   excellente vitesse (ie; 8min vs 40h en lineaire)
        //                      0(n)        : lineaire
        //                      0(n log(n)) :       (algo de tri les plus efficaces)
        //                      O(n^2)      : quadratique
        //                      O(n^3)...

        //      ^^^   famille polynomiale   ('viable'.. n^7 et plus, moins realiste..)

        //                      O(2^n)      : exponentielle         (NOPE.)
        //                      O(n^n) hahahahha. no.
        //                      O(n!)




        /*
            Recherche;
                Collection d'element
                trouver un element (appartenance, position, reference)

                cas speciaux:
                    multiples:
                        premier?
                        dernier?
                        iterateur?
                        tableau de resultat?
                    element non trouve:
                        appartenance: retourne faux
                        position:   erreur, fermer app? nah.
                                    Exception
                                    valeur impossible (ex -1 )



               "trouver" un element veux dire equals retourne true


         */

    /**Fouille lineaire.
     *
     * O(n) pour pire et moyen cas
     *l'algorithme utilise equals pour comparer les elements
     *
     * @param tab   tableau dans lequel l'element est recherche
     * @param e     element recherche
     * @return   la position de la premiere occurance de l'element dans le tableau (-1 si l'element n'y est pas)
     */
        public static <E> int rechercheLineaire(E[] tab, E e){
           /*i = 0
           * tantque(tab[i] != e et
           *        i< taille)
           *    i++
           *
           * si i == tab.taille alors
           *    resultat = -1
           * sinon
           *    resultat = i
           *
           * Analyse temporelle:
           *    !=, <, +, ==
           *
           * K tour de boucle, 3 op par tour de boucle
           * 2 operations pour finir boucle (while (faux))
           * 1 op de comparaison pour finir
           *
           * 3K+3 operations total
           *
           * au plus n tour de boucle
           *
           * 3 analyses: meilleur cas, pire cas, cas moyen
           *
           * meilleurs cas: F(n) = 3
           *                O(1)
           *
           * pire cas:      F(n) = 3n + 3
           *                O(n)
           *
           * cas moyen:     F(n) est entre (3n+3)/2 et 3n+3 (si on inclu donnée non trouvée)
           *                O(n)
           *
           *
           * */
            int i = 0;

            while((tab[i].equals(e)) && i < tab.length){
                i++;
            }

            return i == tab.length ? -1 : i;
        }


        public static <E extends Comparable<E>> int rechercheLogarithmique(E[] tab, E e){
            /*
            * debut = 0
            * fin = tab.taille - 1
            *
            * Tantque (fin != debut)
            *   //diviser le tableau en 2
            *   milieu = (fin + debut) / 2
            *   si tab[milieu] <= e
            *   alors debut = milieu
            *   sinon fin = milieu - 1
            *
            * Si tab[debut] == e,
            *   resultat = debut
            * sinon
            *   resultat = -1
            *
            *
            *
            *
            * Taille = n
            *
            * k tour de boucle
            *   4 operations (desfois 5)
            *
            * 1op a la fin
            *
            * 5K+3
            *
            * Combien de tour de boucle?
            *   log(n) tour.
            *
            *   2^k = N     => log2(n) = k
            *
            *
            *
            * */

            int debut = 0;
            int fin = tab.length;
            int milieu;


            while(fin != debut){
                milieu = (debut + fin)/2;
                /*if(tab[milieu] <= e){
                    debut = milieu;
                }else{
                    fin = milieu - 1;
                }*/
            }

            return (tab[debut].equals(e)) ? debut : -1;//voir version correcte sur moodle
        }

        public static void main( String[] args ){


        }



}
