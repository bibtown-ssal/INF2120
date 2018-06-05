public class File<E> {
    Chainon<E> premier;
    Chainon<E> dernier;

    public File(){
        this.dernier = null;
        this.premier = null;
    }

    public File(Chainon<E> premier){
        this.premier = premier;
        this.dernier = premier;
    }

    public boolean estVide(){
        return null == this.premier;
    }

    public void enfiler(E valeur){
        Chainon<E> nouveau = new Chainon<>(valeur);
        this.dernier.setSuivant(nouveau);
        this.dernier = nouveau;
    }

    public E tete() throws EmptyPileException{
        if(estVide()){
            throw new EmptyPileException("File vide!");
        }

        return this.premier.getValeur();
    }

    public E defiler() throws EmptyPileException{
        if(estVide()){
            throw new EmptyPileException("File vide!");
        }
        Chainon<E> ancient = this.premier;
        this.premier = this.premier.getSuivant();

        return ancient.getValeur();

    }

}
