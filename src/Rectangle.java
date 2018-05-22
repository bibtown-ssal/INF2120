public class Rectangle implements Surface {

    private double cote = 0;
    private double hauteur = 0;

    public Rectangle(double cote, double hauteur){
        this.hauteur = hauteur;
        this.cote = cote;
    }
    @Override
    public double aire(){
        return ( this.cote * this.hauteur );
    }

    @Override
    public double perimetre(){
        return (2 * (this.cote + this.hauteur));
    }
}
