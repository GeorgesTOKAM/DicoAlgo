package com.AdrGeoLouis.DicoAlgo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;
//import javax.swing.UIManager;
//import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;


public class FormMain extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame("Ajouter activite");
	
    public FormMain() {
        initComponents();
        tfpop.setText("0");
        
    }
    
    private void initComponents() {
        
        //JFrame.setDefaultLookAndFeelDecorated(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.add(new FormPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    

    

    public class FormPane extends JPanel {

        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public FormPane() {
            setBorder(new EmptyBorder(8, 8, 8, 8));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(2, 2, 2, 2); // marge entre composants
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 1;

            DescPane descPane = new DescPane();
            descPane.setBorder(new CompoundBorder(new TitledBorder("Description"), new EmptyBorder(4, 4, 4, 4)));
            add(descPane, gbc);
      
        }

    }

    

    protected class DescPane    extends JPanel {

        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public DescPane() {
            JPanel detailsPane = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(2, 2, 2, 2); // marge entre composants
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            //detailsPane.add(new JScrollPane(new TextArea(10,50)), gbc);
            detailsPane.add(tadesc, gbc);
            
            gbc.gridx = 0;
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.EAST;
            gbc.weightx = 0;
            gbc.fill = GridBagConstraints.NONE;
            add(lbactivite, gbc);

            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridx++;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(tfactivite, gbc);   

            
            gbc.gridx = 0;
            gbc.gridy++;
            //gbc.weightx = 1;
            //gbc.fill = GridBagConstraints.HORIZONTAL;

            detailsPane.add(btajout, gbc);
            btajout.addActionListener(new addListener());
            
            gbc.gridy++;
            detailsPane.add(btquitter, gbc);
            btquitter.addActionListener(new quitListener());
            

           

            setLayout(new BorderLayout());
            add(detailsPane);
            add(detailsPane, BorderLayout.LINE_END);
                    
        }            
    } 
    
    public class quitListener implements ActionListener{
        // TODO Quitter fenêtre ajout activité
        @Override
        public void actionPerformed ( ActionEvent event ){
            frame.dispose();
        }
    }
    
    public class addListener implements ActionListener{
        // TODO Ajout activité
        @Override
        public void actionPerformed ( ActionEvent event ){
            
        }
    }
    
    
    
    String[] JStrings = { "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche" };
    private JLabel lbpays = new JLabel("Pays:");
    private JLabel lbville = new JLabel("Villes:");
    private JLabel lbpop = new JLabel("Population:");
    private JLabel lbjour = new JLabel("Jours:");
    private JLabel lbactivite = new JLabel("Activité:");
    
    private JTextField tfpays = new JTextField(10);
    private JTextField tfville = new JTextField(10);
    private JTextField tfpop = new JTextField(10);
    private JTextField tfactivite = new JTextField();
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox jours =  new JComboBox(JStrings);
    private JButton btajout = new JButton("Ajouter");
    private JButton btquitter = new JButton("Quitter");
    private TextArea tadesc = new TextArea(5,80);

}
