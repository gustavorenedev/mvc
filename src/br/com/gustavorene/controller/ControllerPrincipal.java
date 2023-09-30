package br.com.gustavorene.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.com.gustavorene.model.bo.OrdenacaoBO;
import br.com.gustavorene.model.vo.Ordenacao;
import br.com.gustavorene.view.DialogGerarNumero;
import br.com.gustavorene.view.FramePrincipal;

/**
 * 
 * @author Gustavo René
 * @see Classe que cria objeto de controle entre a camada Model e View
 *
 */

public class ControllerPrincipal implements ActionListener, ChangeListener{
	
	private FramePrincipal framePrincipal;
	private DialogGerarNumero dialogGerarNumero;
	
	/**
	 * Construtor da Classe - recebe o objeto do FramePrincipal
	 * 
	 */
	
	public ControllerPrincipal(FramePrincipal framePrincipal) {
		this.framePrincipal = framePrincipal;
		
		// definindo os Listeners (ouvintes) para os botões
		// dessa view
		this.framePrincipal.getBtGerarNumero().addActionListener(this);
		this.framePrincipal.getBtOrdernarNumero().addActionListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		/**
		 * A medida que o componente Slider é arrastado, 
		 * o Campo equivalente no FramePrincipal terá o seu
		 * valor alterado
		 */
		
		if(dialogGerarNumero != null) {
			
			
		
		// getSource = fonte de quem gerou o evento
		if(e.getSource() == this.dialogGerarNumero
				.getSlNumeroMaximo()) {
			
			this.framePrincipal.getTfNumeroMaximo()
			.setText(String.valueOf(dialogGerarNumero.getSlNumeroMaximo().getValue()));;
			
		}
		}
		
	}

	/**
	 * Evento de ação dos botões: pressionar um botão ou
	 * [Enter] em inputs
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		/**
		 * Se o botão gerarNumero do FramePrincipal
		 * instanciar um DialogGerarNumero
		 */
		
		if(e.getSource() == this.framePrincipal.getBtGerarNumero()) {
			//instanciando = DialogGerarNumero
			this.dialogGerarNumero = new DialogGerarNumero();
			this.dialogGerarNumero.getSlNumeroMaximo().setValue(Integer
					.parseInt(this.framePrincipal.getTfNumeroMaximo().getText()));
		
		/**
		 * Registrando os listeners
		 */
			
		this.dialogGerarNumero.getBtGerar().addActionListener(this);
		this.dialogGerarNumero.getBtGerarOrdenar().addActionListener(this);
		this.dialogGerarNumero.getSlNumeroMaximo().addChangeListener(this);
		this.dialogGerarNumero.setVisible(true);
		
		// destroi o Dialog
		this.dialogGerarNumero = null;
			
		}else if (this.dialogGerarNumero != null) {
			//Eventos do DialogGerarNumero
			if(e.getSource() == this.dialogGerarNumero.getBtGerar()) {
				gerarNumero();
			}else if(e.getSource() == this.dialogGerarNumero.getBtGerarOrdenar()) {
				gerarNumero();
				ordenarNumero();
			}else if(e.getSource() == this.framePrincipal.getBtOrdernarNumero()) {
				ordenarNumero();;
			}
		}
	}
	
	/**
	 * Método responsável por controlar a ação de ordenação
	 * Redirecionar para a Model
	 */
	
	private void ordenarNumero() {
		//Manda ordenar e receber uma Ordenação como resultado
		//do processo
		
		Ordenacao ordenacao = new OrdenacaoBO().bubbleSort(Integer.parseInt(this.framePrincipal.getTfNumeroGerado().getText()));
		
		//Atualiza a view
		this.framePrincipal.getTfNumeroOrdenado().setText(String.valueOf(ordenacao.getNumeroOrdenado()));
		this.framePrincipal.getTfNumeroOrdenado().setText(String.valueOf(ordenacao.getQtdeTrocas()));

	}
	
	/**
	 * Método que limpa os campos que contém
	 * valores dos resultados de uma ordenação
	 */
	
	private void limpaDadosOrdenacaoAnterior() {
		this.framePrincipal.getTfNumeroOrdenado().setText(null);
		this.framePrincipal.getTfQtdeTrocas().setText(null);
	}
	
	/**
	 * Método que gera um número randômico e atualiza a view
	 */
	private void gerarNumero() {
		limpaDadosOrdenacaoAnterior();
		
		//Fecha o DisalogGerarNumero
		this.dialogGerarNumero.setVisible(false);
		
		//Atualiza o número no FramePrincipal
		this.framePrincipal.getTfNumeroGerado().setText(String
				.valueOf((int) Math.random() * this.dialogGerarNumero.getSlNumeroMaximo().getValue()));
		
		//destruir o DialogGerarNumero
		this.dialogGerarNumero = null;
		
		//Habilitar o botão Ordenar do FramePrincipal
		this.framePrincipal.getBtOrdernarNumero().setEnabled(true);
	}
}
