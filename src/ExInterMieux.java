import javax.swing.*;
import java.awt.*;

public class ExInterMieux extends JFrame{

    private static final String TEXTE_BASE = "base";
    private static final String TITRE_FENETRE = "Titre";

    private static final int POSITION_LIBELE_Y = 0;

    private String texte = TEXTE_BASE;

    protected JLabel libele = null;

    public ExInterMieux(){
        super( TITRE_FENETRE);
        setLayout(new GridBagLayout());
        libele = new JLabel(texte);
        GridBagConstraints gc = new GridBagConstraints();

        gc.gridy = POSITION_LIBELE_Y;

        add(libele, gc);


    }

    public static void creerInterface(){
        new ExInterMieux();
    }

    public static void main (String [] args){
        Runnable doRun = new Runnable() {
            @Override
            public void run() {
                creerInterface();
            }
        };

        //SwingUtilities.invokeLater(doRun);

        //SwingUtilities.invokeLater( () -> creerInterface());
        SwingUtilities.invokeLater(ExInter::creerInterface);//possible parce que possede la meme signature que "run()" attendu
    }
}
