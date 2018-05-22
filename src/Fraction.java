
public class Fraction implements SontComparable<Fraction>{
	private int numerateur;
	private int denominateur;
	
	public static final Fraction ZERO;
	public static final Fraction UN;
	
	//set valeur initiale des variables d'instances
	{
		numerateur = 0;
		denominateur = 1;
	}
	
	//set valeur des variables de classes
	static {
		ZERO = new Fraction();
		UN = new Fraction(1,1);
	}
	
	public Fraction(){
		
	}
	
	public Fraction(int n, int m){
		numerateur = n;
		denominateur = m;
	}

    public boolean plusPetitQue( Fraction v ) {

        return  ( this.getNumerateur() * v.getDenominateur())
                <
                ( this.getDenominateur()*v.getNumerateur());

	}

	public boolean sontEgaux( Fraction v ) {
	    return this.equals(v);
    }
	//fonctionne, mais en Java on fait clone a la place
/*	public Fraction(Fraction f){
		this.numerateur = f.numerateur;
		this.denominateur = f.denominateur;
	}
*/
	//préférable a celle au dessus
	public Fraction clone(){
		return new Fraction(numerateur, denominateur);
	}


	@Override
	public boolean equals(Object obj){
		boolean resultat = false;

		if(obj != null && obj instanceof Fraction) {
			Fraction temp = (Fraction) obj;
			resultat = this.numerateur * temp.denominateur == this.denominateur * temp.numerateur;
		}
		return resultat;
	}


	public int getNumerateur(){
		return this.numerateur;
	}
	
	public int getDenominateur(){
		return this.denominateur;
	}
	
	public void setDenomninateur(int n){
		this.denominateur = n;
	}
	
	public void setNumerateur(int n){
		this.numerateur = n;
	}
	
	public String toString(){
		return numerateur+" / "+denominateur;
	}
	
}
