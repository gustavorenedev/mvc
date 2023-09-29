package br.com.gustavorene.model.dao;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import br.com.gustavorene.model.vo.Passos;

/**
 * @author Gustavo René
 * @see Classe que executa as operações de IO (entrada e saída)
 * do sistema com relação aos dados resultantes do passo a passo
 * 
 */

public class PassosDAO {
	
	/**
	 * Método que recebe os passos (lista), percorre os elementos
	 * dessa lista e salva-os em em arquivo.
	 * 
	 * @author Gustavo René
	 * @since 01/2023
	 * @param passos
	 * @throws FileNotFoundException
	 */
	public void salvarPassos(List<Passos> passos) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter("passos.txt");
		
		for (Passos p : passos) {
			pw.print(p);
		}
		
		pw.flush();
		pw.close();
	}
}
