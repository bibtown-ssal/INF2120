import java.util.Iterator;

/**
 * Contient la description d'un intervale.
 * C'est un intervale d'entier(Integer) entre deux valeurs: debut et fin.
 * debut et fin sont inclus dans L'intervale
 *
 * ex: Intervale(4,8) represente les valeurs 4,5,6,7,8
 */

public class Intervale implements Iterable<Integer> {

    protected int debut;
    protected int fin;

    public Intervale(int debut, int fin){
        this.debut = debut;
        this.fin = fin;
    }

    public boolean estDans(int x){
        return (x >= this.debut) && (x <= this.fin);
    }

    @Override
    public Iterator iterator() {
        return new IteratorIntervale(this);
    }
}

class IteratorIntervale implements Iterator<Integer> {
    private Intervale _it = null;
    private int _courant = 0;

    public IteratorIntervale(Intervale it){
        this._it = it;
        this._courant = it.debut;
    }

    @Override
    public Integer next(){
        int resultat = this._courant;
        this._courant++;
        return resultat;
    }

    @Override
    public  boolean hasNext(){
        return this._courant <= this._it.fin;
    }
}