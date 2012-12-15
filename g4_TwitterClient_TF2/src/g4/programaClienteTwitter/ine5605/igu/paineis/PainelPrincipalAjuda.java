package g4.programaClienteTwitter.ine5605.igu.paineis;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class PainelPrincipalAjuda extends JPanel {

	private static final long serialVersionUID = 1L;

	private PainelAjuda painelAjuda;
	private JPanel painelCard = new JPanel();
	private CardLayout cardLayout = new CardLayout();

	public PainelPrincipalAjuda(String TF){
		this.setBackground(Color.white);
		painelAjuda = new PainelAjuda(TF);
		posicionaComponets();
	}

	private void posicionaComponets() {
		this.setLayout(new BorderLayout());

		painelCard.setLayout(cardLayout);
		painelCard.add(painelAjuda, "painelAjuda");
		this.add(painelCard, BorderLayout.CENTER);
	}

}