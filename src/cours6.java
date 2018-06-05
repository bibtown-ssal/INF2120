import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class cours6 {


    public static void main (String [] Args){
        INC h = new INC();
        System.out.println(h.f(4));

        Fonction<Integer, Integer> e = new Fonction<>() {
            @Override
            public Integer f(Integer x) {
                return 2*x+1;
            }
        };

        Function<Integer, Integer> f = x -> 2*x+1;
        Function < Integer, Integer> g = x -> x+1;

        ArrayList<Function<Integer, Integer> > liste =
                new ArrayList<>();
        liste.add(x -> x+1);
        liste.add(x -> x*x+7);

        Supplier < Integer > j = () -> 3;  //R get()
        Predicate < Integer > p = x -> x < 5;//boolean test<T>
        Consumer < Integer > c = x -> System.out.println(x); //void accept<T>
        Consumer < Integer > c2 = System.out :: println;
        Function < Integer, Integer > k = x -> {
            int somme = 0;
            for (int i = 1; i <= x; i++){
                somme += i;
            }
            return somme;
        };

        System.out.println(liste.get(0).apply(3));
        System.out.println(f.apply(4));
        c.accept(k.apply(g.apply(j.get())));


        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(3,5,7,89,-2));



        for( Integer x : a){
            if(x < 5) {  // le meme que p.test
            //if(p.test(x){
                System.out.println(x+1); //le meme que c2.accept(g.apply(x))
                //c2.accept(g.apply(x))
            }
        }
        for(Integer x : a){
            if(p.test(x)){
                c2.accept(g.apply(x));
            }
        }

        //Stream rend ca plus abstrait, penser chaine de montage;  Supplier -> Function <-> Predicate -> Consumer
        //Stream est le tapis roulant..


        Stream<Integer > s = a.stream();
        //iterator.next() = supplier
        //s2 a une boite qui contient tout les elements de a

        Stream s2 = s.filter(p);
        //filter(p) utilise predicat p, "if(p) then"
        //s2 a une boite qui contient les elements de a pour qui p.apply(a.elem) == true

        Stream s3 = s2.map(g);
        //map(g) fait l'action g.apply sur chaque element

        s3.forEach(c2);
        //consomme chaque element de s3 et fait c2

        //meilleure facon?
        a.stream().filter(p).map(g).forEach(c2);

        a.stream().parallel()
                  .filter( x -> x < 5)
                  .map(x -> x+1)
                  .forEach(System.out:: println);

    }

}
