import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ExInter {
    /*Composante
        Contenant
            Placer(Layout)
      Evenements (Event)
        Systeme d'écoute (Listener)
            Callback (interface java)

     2 principale lib de base de GUI pour Java:
        AWT (old!)
        Swing (herite de AWT mais ameliorer)
     */
    protected static String texte = "base";

    public static void creerInterface(){

        JFrame fenetre = new JFrame( "Nom du Programme" );
        //fenetre.setLayout(new GridLayout(2,2));
        //FlowLayout
        //BorderLayout
        //GridBagLayout
        //fenetre.setLayout(new BorderLayout());
        fenetre.setLayout(new GridBagLayout());
        JLabel libele = new JLabel(texte); //texte a afficher dans la fenetre.. ie: "Nom: "
        //fenetre.add(libele, BorderLayout.WEST);

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;   //cette valeur devrait etre une constante "POSITION_LIBELE_X"
        gc.gridy = 0;
        gc.gridheight = 1;
        gc.gridwidth = 1;

        fenetre.add(libele, gc);

        JTextField edition = new JTextField(20);
        ActionListener act = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                texte = edition.getText();
                libele.setText(texte);
            }
        };
        //edition.addActionListener(act);
        edition.addActionListener(e -> {
            texte = edition.getText();
            libele.setText(texte);
        });
        //fenetre.add(edition, BorderLayout.CENTER);
        gc.gridx = 1;
        fenetre.add(edition, gc);



        JPanel panneauNord = new JPanel();
        panneauNord.setLayout(new GridLayout(1,2));

        JButton effacer = new JButton("Effacer");
        effacer.addActionListener(( e ) -> {
            edition.setText("");
            texte = "";
            libele.setText("");
        });
        panneauNord.add(effacer);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.gridwidth = 2;
        fenetre.add(effacer, gc);

        JButton b2 = new JButton("b2");
        panneauNord.add(b2);
         gc.gridy = 2;
         fenetre.add(b2,gc);
        //fenetre.add(panneauNord, BorderLayout.NORTH);

        fenetre.pack();// utile, mais utilisation de l'espace minimum.. pas necessairement bien place
        fenetre.setVisible(true);
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

    //POUR EXAM
        /*
            JButton
            JTextField
            JFrame
            JTextField
            JLabel

            constructeur, mettre dans un contenant,
            ACTION LISTENER avec LAMBDA

            la ligne: SwingUtilities.invokeLater(ExInter::creerInterface);
         */

}
