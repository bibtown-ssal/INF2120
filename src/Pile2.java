import java.util.ArrayList;

public class Pile2<E> extends ArrayList<E> {

    public Pile2 (){
            super();
    }

    public void empiler(E valeur){
        this.add(valeur);
    }

    public void empiler2(E valeur){
        this.add(0,valeur);
    }
    public E sommet2(){
        return this.get(0);
    }
    public E sommet(){
        return this.get( size() -1);
    }

    public E depiler2(){
        return this.remove(0);
    }

    public E depiler(){
        return this.remove( size() -1);
    }
}
//Pas besoin de mettre de champs ArrayList!! Pile2 EST! un ArrayList!