public class Cercle implements Surface {
    protected double rayon;

    public Cercle(double rayon){
        this.rayon = rayon;
    }

    @Override
    public double aire(){
        return Math.PI*rayon*rayon;
    }

    @Override
    public double perimetre(){
        return 2*Math.PI*rayon;
    }

}
