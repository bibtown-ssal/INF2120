import java.awt.*;

public class cours5 {


    public static void hanoi(int n, char depart, char intermediaire, char finale){
        if(n > 1){
            hanoi(n-1, depart, finale, intermediaire);
        }
        System.out.println("deplacer le disque de la tour " + depart + " vers la tour " + finale);
        if(n > 1 ){
            hanoi(n-1, intermediaire,depart,finale);
        }
    }
    public static int sommationRecurs(int x, int y){
        int resultat = y;

        if( x < y ){
            resultat += sommationRecurs(x, y-1);
        }

        return resultat;
    }

    public static int elemFibonacci(int numero){
        int fib = numero;
        if(numero > 1) {
            fib = elemFibonacci(numero - 1) + elemFibonacci(numero - 2);
        }
        return fib;
    }

    public static void main ( String [] Arg){
        Pile1<Integer> p = new Pile1<>();
        p.empiler(2);
        p.empiler(30);
        p.empiler(25);
        p.empiler(-62);
        try {
            while(!p.estVide()){
                System.out.println(p.depiler());
            }
        }catch (EmptyPileException e){
                System.out.println(e.getMessage());
        }

        System.out.println(elemFibonacci(10));
        hanoi(4,'A','B','C');

        Fonction<Integer, Integer> v = new Inc();
        System.out.println(v.f(4));

    }
}
class Inc implements Fonction< Integer, Integer>{

    @Override
    public Integer f(Integer x) {
        return x + 1 ;
    }
}
//Recursion; utilise elle meme a l'interieur d'elle meme, inclu un point d'arret
// permet des solutions plus simple a des problemes complexes, mais est generalement moins performant

//utilise la reduction pour aller travailler sur un cas de base
