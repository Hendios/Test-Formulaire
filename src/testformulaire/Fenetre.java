package testformulaire;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
Nom:    Fazzi
Prénom: Enzo

Classe: Fenetre
*/

public class Fenetre extends JFrame{
    
    // Attribut(s) -> Caractéristiques de l'objet
    private JPanel main = new JPanel();
    private JPanel center = new JPanel();
    private JPanel south = new JPanel();
    private JLabel prenom = new JLabel("Prénom: ");
    private JLabel nom = new JLabel("Nom: ");
    
    private JTextField jtfPrenom = new JTextField();
    private JTextField jtfNom = new JTextField();
    
    private JButton ok = new JButton("OK");
    private JButton reset = new JButton("RESET");
    
    private JOptionPane jopMessage = new JOptionPane();
    private String JTextBox = " ";
    
    private Font police = new Font("Verdana", Font.BOLD, 20);
    
    // Méthode(s) -> Fonctionnalités de l'objet
    public Fenetre(){
        super();
        this.setTitle("Formulaire de saisie");
        this.setSize(1200, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Layout
            //Grille
            main.setLayout(new BorderLayout());
            
            // Centre
            prenom.setPreferredSize(new Dimension(200, 50));
            prenom.setFont(police);
            jtfPrenom.setPreferredSize(new Dimension(950, 50));
            jtfPrenom.setFont(police);
            jtfPrenom.setForeground(Color.BLUE);
            
            nom.setPreferredSize(new Dimension(200, 50));
            nom.setFont(police);
            jtfNom.setPreferredSize(new Dimension(950, 50));
            jtfNom.setFont(police);
            jtfNom.setForeground(Color.BLUE);
            
            center.add(prenom);
            center.add(jtfPrenom);
            center.add(nom);
            center.add(jtfNom);
            main.add(center, BorderLayout.CENTER);
            
            // Sud
            ok.setPreferredSize(new Dimension(200, 50));
            ok.setFont(police);
                // Actions
                ok.addActionListener(new OkListener());
            
            reset.setPreferredSize(new Dimension(200, 50));
            reset.setFont(police);
                // Actions
                reset.addActionListener(new ResetListener());
                
            south.setBackground(Color.lightGray);
            south.add(ok);
            south.add(reset);
            main.add(south, BorderLayout.SOUTH);
            
        this.setContentPane(main);
        this.setVisible(true);
    }
    
    //Classes qui écoutent les actions
    class OkListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            JTextBox = jtfPrenom.getText() + " " + jtfNom.getText();
            
            if (JTextBox.equals(" ")){
                jopMessage.showMessageDialog(null, "Pas d'information", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            
            else{
                jopMessage.showMessageDialog(null, JTextBox, "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    class ResetListener implements ActionListener{
        public void actionPerformed(ActionEvent evt){
            jtfPrenom.setText("");
            jtfNom.setText("");
        }
    }
    
}
