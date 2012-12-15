package g4.programaClienteTwitter.ine5605.igu.paineis;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PainelPrincipalAjuda extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JButton ajuda;
	private PainelAjuda painelAjuda;
	private JPanel painelCard = new JPanel();
	
	private CardLayout cardLayout = new CardLayout();

	public PainelPrincipalAjuda(){
		this.setBackground(Color.white);
		painelAjuda = new PainelAjuda();
		posicionaComponets();
	}

	private void posicionaComponets() {
        this.setLayout(new BorderLayout());
        
        ajuda = new JButton("Ajuda Trabalho Final");
        ajuda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(painelCard, "painelAjuda");
			}
		});
        
    
       
              
        painelCard.setLayout(cardLayout);
        painelCard.add(painelAjuda, "painelAjuda");
        this.add(painelCard, BorderLayout.CENTER);
	}

}