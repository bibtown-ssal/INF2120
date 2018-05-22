import java.util.ArrayList;
import java.util.Iterator;

public class cours4 {


    public static void main (String[] args){

        ArrayList<Fraction> t = new ArrayList<>();
        t.add(new Fraction(8,2));
        t.add(new Fraction(3,2));
        t.add(new Fraction(5,2));
        t.add(new Fraction(7,2));
        t.add(new Fraction (9,2));

        Iterator<Fraction> it = t.iterator();
        while(it.hasNext()){
            Fraction f = it.next();

            System.out.println(f);
        }
        //est equivalent a (est la facon que le compilateur ecrit:
        for(Fraction f : t){
            System.out.println(f);
        }

        Intervale intervale = new Intervale(1,3);
        for(Integer i : intervale){
            System.out.println(i);
        }


    }

}
