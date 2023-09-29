package br.com.gustavorene.model.vo;

/**
 *
 * @author Gustavo René
 * @see Classe que cria objeto capaz de armazenar
 * os dados relativos a ordenação
 *
 */

public class Ordenacao{
	
	//atributos
	private int numeroOrignal;
	private String numeroOrdenado;
	private int qtdeTrocas;
	
	
	/**
	 * Consntrutor padrão que insere os atributos no objeto
	 * 
	 * @param numeroOrignal
	 * @param numeroOrdenado
	 * @param qtdeTrocas
	 */
	public Ordenacao(int numeroOrignal, String numeroOrdenado, int qtdeTrocas) {
		this.numeroOrignal = numeroOrignal;
		this.numeroOrdenado = numeroOrdenado;
		this.qtdeTrocas = qtdeTrocas;
	}


	/**
	 * @return the numeroOrignal
	 */
	public int getNumeroOrignal() {
		return numeroOrignal;
	}


	/**
	 * @param numeroOrignal the numeroOrignal to set
	 */
	public void setNumeroOrignal(int numeroOrignal) {
		this.numeroOrignal = numeroOrignal;
	}


	/**
	 * @return the numeroOrdenado
	 */
	public String getNumeroOrdenado() {
		return numeroOrdenado;
	}


	/**
	 * @param numeroOrdenado the numeroOrdenado to set
	 */
	public void setNumeroOrdenado(String numeroOrdenado) {
		this.numeroOrdenado = numeroOrdenado;
	}


	/**
	 * @return the qtdeTrocas
	 */
	public int getQtdeTrocas() {
		return qtdeTrocas;
	}


	/**
	 * @param qtdeTrocas the qtdeTrocas to set
	 */
	public void setQtdeTrocas(int qtdeTrocas) {
		this.qtdeTrocas = qtdeTrocas;
	}
	
	
	//Sobrescrevendo o toString do objeto
	@Override
	public String toString() {
		return
				String.valueOf(this.numeroOrignal)
				.concat(" virou: \n")
				.concat(String.valueOf(this.numeroOrdenado))
				.concat("\nQtde de trocas: ")
				.concat(String.valueOf(this.qtdeTrocas));
	}
}