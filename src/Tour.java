public class Tour extends PieceEchec{
    private int ligne;
    private Colonne colonne;

    public Tour(int ligne, Colonne colonne){
        super( ligne, colonne);
    }

    @Override
    public final boolean deplacementValide(int ligne, Colonne colonne){  //classe qui hérite ne pourra pas Override la fonction
        return ((this.ligne == ligne) ^ (this.colonne == colonne));
    }
}
