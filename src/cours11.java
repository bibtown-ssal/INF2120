public class cours11 {

    /*
        Comment matcher les tris des tableaux (efficace) et l'insertion des listes chainees?

        arbre binaire de recherche.
            milieu est important pour la recherche, pk ne pas mettre le pointeur au milieu de l'ensemble?
            le milieu pointe vers le milieu de chacune des parties restantes...

            ie: 1,3,7,18,21,30,37

                    18
                   /  \
                  3    30
                /  \  /  \
               1   7  21  37


            parfait! sauf qu'on est parti d'un tableau déjà trié...
            sur un ajout dynamique.. structure dépendante de l'ordre d'ajout des éléments



            noeud de base = racine
            noeud sans sous-arbre (sans branche) = feuille
            arité: nb de branche (kinda)

            valeur du noeud = clef
     */
    /*
        On peut ajouter une "definition" dans le noeud
        arbre devient une structure associative

        recherche retourne la definition
        insertion insere une clef et sa definition

        principre de map
     */
    /*
        Comment faire le parcours de tous les elements d'un arbre binaire de recherche...
            parcour(Noeud n){
                si n != null
                    afficher(n)     //Ordre prefixe
                    parcour(n.gauche);
                    afficher(n);    //Ordre Infixe
                    parcour(n.droite);
                    afficher(n)     //Ordre Suffixe

                   /18\
               /12\      21\
              6     /14     27
                  13

           Ordre prefixe: 18, 12, 6, 14, 13, 21, 27     //commence par la racine
           Ordre Infixe:  6, 12, 13, 14, 18, 21, 27     // affiche en ordre croissant
           Ordre Suffixe: 6, 13, 14, 12, 27, 21, 18     //termine par la racine

     */

}
