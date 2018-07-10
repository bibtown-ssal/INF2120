public class ArbreBinaire <Clef extends Comparable<Clef>> {
    protected class Noeud < Clef extends Comparable<Clef>>{
        protected Clef clef;
        protected Noeud<Clef> gauche = null;
        protected Noeud<Clef> droite = null;

        public Noeud(Clef clef){
            this.clef = clef;
        }

        public Clef getClef() {
            return clef;
        }

        public Noeud<Clef> getGauche() {
            return gauche;
        }

        public Noeud<Clef> getDroite() {
            return droite;
        }

        public void setClef(Clef clef) {
            this.clef = clef;
        }

        public void setGauche(Noeud<Clef> gauche) {
            this.gauche = gauche;
        }

        public void setDroite(Noeud<Clef> droite) {
            this.droite = droite;
        }
    }

    Noeud<Clef> racine;

    public ArbreBinaire(){
        racine = null;
    }

    public boolean estVide(){
        return racine == null;
    }

    public void inserer(Clef clef){
        //on insere toujours une nouvelle feuille.
        if(racine == null){
            racine = new Noeud<>(clef);
        }else {
            Noeud<Clef> courant = racine;
            int resultatComparaison = courant.getClef().compareTo(clef);

            while (courant != null && resultatComparaison != 0) {
                if (resultatComparaison < 0) {
                    if (null == courant.getGauche()) {
                        courant.setGauche(new Noeud<>(clef));
                    }
                    courant = courant.getGauche();
                } else {
                    if (null == courant.getDroite()) {
                        courant.setDroite(new Noeud<>(clef));
                    }
                    courant = courant.getDroite();
                }
                resultatComparaison = courant.getClef().compareTo(clef);
            }
        }
    }

    public void supprimer(Clef clef){
        /*
            3 cas possible:
                Feuille
                    facile. supprime la feuille.
                1 seul sous arbre
                    relativement facile, on ramene le sous-arbre sous le parent de l'element a supprimer
                2 sous arbres
                    retirer la valeur du noeud, sans retirer le noeud (trouver un remplacent: valeur la plus grande du sous arbre de gauche, ou valeur la plus petite de droite)
                        remplacer valeur a supprimer par remplacent, supprimer remplacent (qui n'aura jamais 2 sous-arbres)
         */
        /*feuille:
            si racine
                racine = null
            sinon
                parent.set[Cote](null)

         */
        /*un enfant
            si racine
                racine = enfant
            sinon
                parent.set[Cote](enfant)
         */
        /*2 enfant
            element = suivant(racine.getDroite)
            parentDeSuivant.setGauche(null)
         */


    }

    private Clef minimum(Noeud<Clef> racine){
        Noeud<Clef> courant = racine;
        while(courant.getGauche() != null){
            courant = courant.getGauche();
        }
        return courant.getClef();
    }

    public boolean recherche(Clef clef){
        Noeud<Clef> courant = racine;
        /*
        while(courant != null && courant.getClef().compareTo(clef) != 0){
            if(courant.getClef().compareTo(clef) < 0){//dedoublement de code...
                courant = courant.getGauche();
            }else{
                courant = courant.getDroite();
            }
        }*/
        int resultatComparaison =
                null != courant
                ? courant.getClef().compareTo(clef)
                : 0;
        while(courant != null && resultatComparaison != 0){
            if(resultatComparaison < 0){
                courant = courant.getGauche();
            }else{
                courant = courant.getDroite();
            }
            resultatComparaison =
                    null != courant
                    ? courant.getClef().compareTo(clef)
                    : 0;

        }//meilleur pour des valeurs complexes ("if" coutent pas mal moins cher que "compareTo" pour des elements complexe (comme chaine de char)

        return courant != null;
    }

}
