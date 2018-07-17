public class ArbreBinaire <Clef extends Comparable<Clef>, Def> {
    protected class Noeud < Clef extends Comparable<Clef>, Def>{
        protected Clef clef;
        public Def definition;
        protected Noeud<Clef, Def> gauche = null;
        protected Noeud<Clef, Def> droite = null;

        public Noeud(Clef clef, Def definition){
            this.clef = clef;
            this.definition = definition;
        }

        public Clef getClef() {
            return clef;
        }

        public Noeud<Clef, Def> getGauche() {
            return gauche;
        }

        public Noeud<Clef, Def> getDroite() {
            return droite;
        }

        public void setClef(Clef clef) {
            this.clef = clef;
        }

        public void setGauche(Noeud<Clef, Def> gauche) {
            this.gauche = gauche;
        }

        public void setDroite(Noeud<Clef, Def> droite) {
            this.droite = droite;
        }
    }

    Noeud<Clef, Def> racine;

    public ArbreBinaire(){
        racine = null;
    }

    public boolean estVide(){
        return racine == null;
    }

    public void inserer(Clef clef, Def definition){
        //on insere toujours une nouvelle feuille.
        if(racine == null){
            racine = new Noeud<>(clef, definition);
        }else {
            Noeud<Clef, Def> courant = racine;
            int resultatComparaison = courant.getClef().compareTo(clef);

            while (courant != null && resultatComparaison != 0) {
                if (resultatComparaison < 0) {
                    if (null == courant.getGauche()) {
                        courant.setGauche(new Noeud<>(clef, definition));
                    }
                    courant = courant.getGauche();
                } else {
                    if (null == courant.getDroite()) {
                        courant.setDroite(new Noeud<>(clef, definition));
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

        Noeud<Clef, Def> parent = null;
        Noeud<Clef, Def> courant = this.racine;

        int resultat = (null != courant) ? clef.compareTo(courant.clef) : 0;

        /*
            logique de recherche
         */
        while (null != courant && resultat != 0){
            parent = courant;
            if(resultat > 0){
                courant = courant.getDroite();
            }else {
                courant = courant.getGauche();
            }
            resultat = (null != courant) ? clef.compareTo(courant.clef) : 0;
        }

        /*
            Etat du programme:

                Arbre vide              | Parent : null     | courant : null
                Supprimer racine        | Parent : null     | courant != null
                non present             | Parent != null    | courant : null
                supprimer non-racine    | Parent != null    | courant != null
         */

        if(courant != null) {
            supprimerNoeud(parent, courant);
        }
    }

    private void supprimerNoeud(Noeud<Clef, Def> parent, Noeud<Clef, Def> courant){
        /*
            si personne a droite,
                remonte arbre a gauche
            sinon si persone a gauche
                remonte arbre droite
            sinon
                trouver precedent
                remplacer courant <- precedent
                supprimerNoeud(parentPrecedent, precedent)

         */

        Noeud<Clef, Def> precedent;
        Noeud<Clef, Def> parentPrecedent;
        if( courant.getGauche() == null){
            if(parent != null){
                if(parent.getDroite() == courant){
                    parent.setDroite(courant.getDroite());
                } else {
                    parent.setGauche(courant.getDroite());
                }
            }else{
                this.racine = courant.getDroite();
            }
        }else if (courant.getDroite() == null){
            if(parent != null){
                if(parent.getDroite() == courant){
                    parent.setDroite(courant.getGauche());
                } else {
                    parent.setGauche(courant.getGauche());
                }
            } else {
                this.racine = courant.getGauche();
            }
        } else {
            precedent = courant.getGauche();
            parentPrecedent = courant;
            while( precedent.getDroite() != null){
                parentPrecedent = precedent;
                precedent = precedent.getDroite();
            }
            courant.setClef(precedent.getClef());
            supprimerNoeud(parentPrecedent, precedent);
        }


    }

    private Clef minimum(Noeud<Clef, Def> racine){
        Noeud<Clef, Def> courant = racine;
        while(courant.getGauche() != null){
            courant = courant.getGauche();
        }
        return courant.getClef();
    }

    public boolean recherche(Clef clef){
        Noeud<Clef, Def> courant = racine;
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
