package repetitivas;

public class ExemploForArray {

	public static void main(String[] args) {
		/*
		 * uma estruturas de arrays - conjunto de elementos de um tipo correspondente.
		 * Aqui temos um array do tipo String chamado de alunos, cada nome/elemento vai
		 * ficar dentro dessas chaves separado por um v�rgula. Em arrays o �ndice inicia
		 * em ZERO.
		 */
		String alunos[] = { "Felipe", "Jonas", "Julia", "Marcos" };

		/*
		 * Na inicializa��o criamos uma vari�vel x, pra representar o �ndice de um
		 * elemento em um array; a condi��o determina que enquanto x for menor que o
		 * tamanho do array de alunos (length); ele vai incrementar de um em um.
		 */
		// For
		for (int x = 0; x < alunos.length; x++) {
			/* Vai imprimir o nome dos alunos pelo �ndice. */
			System.out.println("O aluno no �ndice x=" + x + " � " + alunos[x]);
		}

		System.out.println();
		// For each
		/*
		 * Tenho elementos e esse elemento � de um tipo. Quando eu coloco dois pontos
		 * quer dizer que a cada itera��o de alunos, o aluno atual, no �ndice atual vai
		 * atualizar automaticamente essa vari�vel.
		 */
		for (String aluno : alunos) {
			System.out.println("Nome do aluno �: " + aluno);
		}

	}

}
