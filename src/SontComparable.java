public interface SontComparable< E extends SontComparable> {

    boolean sontEgaux( E v );

    default boolean neSontPasEgaux( E v ){
        return !sontEgaux(v);
    }

    boolean plusPetitQue( E v );

    default boolean plusGrandQue( E v ){
        //return (!plusPetitQue(v) && !sontEgaux(v));
        //ou encore
        return v.plusPetitQue(this);
    }

    default boolean plusPetitOuEgal(E v){
        return (!plusGrandQue(v));
    }

    default boolean plusGrandOuEgal(E v){
        return (!plusPetitQue(v));
    }

}

/*
Le <E> rend l'interfacce definit que "plusPetitQue" est sur 2 choses de meme type uniquement
 */