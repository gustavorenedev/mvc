package br.com.gustavorene.model.bo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import br.com.gustavorene.model.dao.OrdenacaoDAO;
import br.com.gustavorene.model.dao.PassosDAO;
import br.com.gustavorene.model.vo.Ordenacao;
import br.com.gustavorene.model.vo.Passos;


/**
 * 
 * @author Gustavo René
 * @see Classe que contém o método de ordenação (bubble sort)
 * 
 */


public class OrdenacaoBO {
	
	/**
	 * @see Método responsável por fazer a ordenação através do algoritmo Bubble Sort (método bolha)
	 * @param numero
	 * @return Ordenacao
	 */
	
	public Ordenacao bubbleSort(int numero) {
	
		// Converte o número em String para fazer as trocas considerando caracter por caracter
		char[] digitos = String.valueOf(numero).toCharArray();
		
		// Variável auxiliar -> Intermediar entre as trocas 
		char aux;
		
		// Variável auxiliar -> Armazenar o número antes da modificação
		char[] antes;
		
		// Variável -> Será incrementada a cada troca realizada e contar quantas trocas ocorreram
		int qtdeTrocas = 0;
		
		// Vetor de passos para descrever todo o processo
		List<Passos> passos = new ArrayList<Passos>();
		
		
		// Variável que determina se houve troca -> Interromper o processo quando já não houver mais números a serem ordenados
		
		boolean continua = true;
		
		// Verifica se foram feitas trocar no último ciclo, se não, indica que o número já está ordenado
		for(int i=0; i<digitos.length; i++) {
			if(!continua) {
				break;
			}
			
			// Descrever o passo
			passos.add(new Passos(null, null, "Início da verificação número"
					.concat(String.valueOf(i))
					.concat("\n----------------------------------\n")));
			
			continua = false;
			
			// Percorrendo cada número com seu próximo
			for(int j=0; j<digitos.length - 1; j++) {
				if(digitos[j] > digitos[j+1]) {
					
					// O número é maior do que o próximo -> troca!
					antes = new String(digitos).toCharArray();
					
					aux = digitos[j];
					digitos[j] = digitos[j+1];
					digitos[j+1] = aux;
					
					// Incrementar a quantidade de trocas
					qtdeTrocas++;
					
					// Descrevendo o passo
					passos.add(new Passos(new String(antes), new String(digitos), "Trocou-se o dígito "
							.concat(String.valueOf(digitos[j+1]))
							.concat(" pelo "
							.concat(String.valueOf(digitos[j])))));
					
					continua = true;
				}else {
					passos.add(new Passos(new String(digitos), new String(digitos), "Não houve troca, pois o número "
							.concat(String.valueOf(digitos[j]))
							.concat(" é menor ou igual à "
							.concat(String.valueOf(digitos[j+1])))));
				}
			}
		}
		
		// Persiste os resultados
		Ordenacao ordenacao = new Ordenacao(numero, new String(digitos), qtdeTrocas);
		try {
			new OrdenacaoDAO().salvar(ordenacao);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			new PassosDAO().salvarPassos(passos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ordenacao;
		
		
		
		
		
		
	}
}
