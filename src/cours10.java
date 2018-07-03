import java.net.Inet4Address;

public class cours10 {
    /*
        Tri:
            Collection sequentielle(position)

            modifier l'ordre pour qu'ils soient tries
                comparateur <
                echanger (lecture/ecriture en memoire)


            4 algo au menu:
                -insertion
                -selection
                -quicksort
                -tri bulle (bubble sort)
                    (rocksort)


            Calcul de la complexite: n log(n) est la complexite la plus basse possible, mathematiquement

    */

    public static < E extends Comparable<E>> void triInsertion(E[] tab){
        //positionner l'element a l'indice i au bon endroit
        /*pour i :=1 a tab.taille()-1
            j:=i
            tantque( j!= 0 et !(tab[j-1] < tab[j]
                temp := tab[i]
                tab[i] := tab[j]
                tab[j] := temp
                j := j-1
         */
            //poour limiter le nb decriture, on modifi un peu cet algo
        /*pour i :=1 a tab.taille()-1
            j:=i
            temp= tab[i]
            tantque( j!= 0 et !(tab[j-1] < tab[j]
                tab[j] := tab[j-1]
                j := j-1
            tab[j] := temp
         */
        int j;
        E temp;

        for(int i = 1; i < tab.length; i ++){
            j = i;
            temp = tab[i];
            while( j != 0 && tab[j-1].compareTo(temp) >= 0 ){
                tab[j] = tab[j-1];
                j--;
            }
            tab[j] = temp;
        }
        /*
            Analyse de complexite:
                la boucle while interne fait i comparaison dans le pire des cas
                    = n-1 comparaison
                moyen est a peu pres ((n-1)/2)
                meilleur cas est 1

            la boucle externe fait n-1 comparaison

            les deux ensemble:
                (n-1)*([ n-1 ][ (n-1)/2 ][1])
                pire cas: n²
                cas moyen: n²
                meilleur cas: n

            algorithme excellent pour des tableaux deja trie (ou presque trie)
                donc sur petit ajout dans un tableau trie, algo tres performent

                [sur base magnetique, il se deplace tres peu]

         */
    }

    public static <E extends Comparable<E>> void triSelection(E[] tab){

    }

    public static <E extends Comparable<E>> void triQuickSort(E[] tab){

    } 

    public static void main (String[] args){
        Integer[] t = {3,5,1,2,3};

        triInsertion(t);

        for(Integer e : t){
            System.out.print(e + " ");
        }
    }
}
