public class Chainon <E>{

    protected E valeur;
    protected Chainon<E> suivant;

    public Chainon( E valeur ){
        this.valeur = valeur;
        this.suivant = null;
    }

    public void setValeur(E valeur) {
        this.valeur = valeur;
    }

    public void setSuivant(Chainon<E> suivant) {
        this.suivant = suivant;
    }

    public E getValeur() {

        return valeur;
    }

    public Chainon<E> getSuivant() {
        return suivant;
    }


}
