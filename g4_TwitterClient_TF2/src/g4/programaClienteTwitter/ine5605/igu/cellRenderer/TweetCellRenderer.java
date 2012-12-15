package g4.programaClienteTwitter.ine5605.igu.cellRenderer;

import g4.programaClienteTwitter.ine5605.logica.Formatador;
import g4.programaClienteTwitter.ine5605.logica.Tweets;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;


/**
*
*	Classe TweetCellRenderer - Responsavel pela renderizacao dos tweets que serao exibidos na lista de tweets
*
*/

public class TweetCellRenderer extends JPanel implements ListCellRenderer<Tweets>{

	private static final long serialVersionUID = 1L;
	private static final Color COR_SELECIONADO = new Color(150, 205, 205);
	private static final Color COR_NORMAL = new Color(255, 255, 255);
	
	private static final Color COR_RETWITADO = new Color(84,255,159);
	private static final Color COR_SELECIONADO_RETWITADO = new Color(154,205,50);

	Formatador formatador =  new Formatador();

	BorderLayout layout =  new BorderLayout(5,5);

	JEditorPane	texto;
		
	JLabel autor;
	JLabel foto;

	public TweetCellRenderer() {
		this.setSize(470, 400);

		this.setLayout(layout);
		this.setBorder(BorderFactory
				.createMatteBorder(0, 0, 1, 0, Color.gray));

		definaComponentes();
	}


	/**
	 * sao definidas as pisicoes onde cada elemento ficara no cell renderer.
	 */

	public void definaComponentes(){
		foto = new JLabel();
		this.add(foto, BorderLayout.WEST);

		autor = new JLabel();
		this.add(autor, BorderLayout.NORTH);

		texto = new JEditorPane("text/html", "");
		this.add(texto, BorderLayout.CENTER);

	}
	

	/**
	 * sao definidos os componentes que serao exibidos na lista de tweets
	 */
	@Override
	public Component getListCellRendererComponent(JList<? extends Tweets> list,
			Tweets value, int index, boolean isSelected, boolean cellHasFocus) {


		foto.setIcon(value.getFotoDoPerfil());
		autor.setText(value.getNome());
		texto.setText(formatador.formatHTML(value.getTexto()));

		

		if (value.isRetweeted()){
			setBackground(isSelected ?  COR_SELECIONADO_RETWITADO : COR_RETWITADO);
			texto.setBackground(isSelected ? COR_SELECIONADO_RETWITADO : COR_RETWITADO);
			setToolTipText(value.getDataEmString());
		}
		else {
			setBackground(isSelected ? COR_SELECIONADO : COR_NORMAL);
			texto.setBackground(isSelected ? COR_SELECIONADO : COR_NORMAL);
			setToolTipText(value.getDataEmString());
		}

		return this;
	}

}
