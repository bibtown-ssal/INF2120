public class Prisme {
    protected double hauteur;
    protected Surface base;

    public Prisme(double hauteur, Surface base){
        this.hauteur = hauteur;
        this.base = base;
    }

    public double aire(){
        return base.aire()*2 + hauteur*base.perimetre();
    }

    public double volume(){
        return this.base.aire()*this.hauteur;
    }
}
