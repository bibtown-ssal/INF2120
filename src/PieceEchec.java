public abstract class PieceEchec {
    protected Colonne colonne;
    protected int ligne;

    public PieceEchec(int ligne, Colonne colonne){
        this.colonne = colonne;
        this.ligne = ligne;
    }
    public PieceEchec(){
        this.colonne = Colonne.A;
        this.ligne = 1;
    }

    public abstract boolean deplacementValide(int ligne, Colonne colonne);
}
