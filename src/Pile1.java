public class Pile1 <E>{

    protected Chainon<E> sommet;


    {
        sommet = null;
    }

    public Pile1(){

    }

    public Pile1 ( Chainon<E> sommet){
        this.sommet = sommet;
    }

    public boolean estVide(){
        return null == this.sommet;
    }

    public void empiler(E valeur){
        Chainon<E> nouveau = new Chainon<>(valeur);
        nouveau.setSuivant(this.sommet);
        this.sommet = nouveau;
    }

    public E sommet() throws EmptyPileException{
        if(null == this.sommet){ //estVide() est plus facile a maintenir, mais moins performant
            throw new EmptyPileException("Pile vide! Il n'y a pas de sommet");
        }

        return this.sommet.getValeur();
    }

    public E depiler() throws EmptyPileException{
        if(null == this.sommet){
            throw new EmptyPileException("Pile vide! Impossible de depiler");
        }
        Chainon<E> ancien = this.sommet;
        this.sommet = this.sommet.getSuivant();
        return ancien.getValeur();
    }

}
