package repetitivas;

public class ExemploForArray {

	public static void main(String[] args) {
		/*
		 * uma estruturas de arrays - conjunto de elementos de um tipo correspondente.
		 * Aqui temos um array do tipo String chamado de alunos, cada nome/elemento vai
		 * ficar dentro dessas chaves separado por um vírgula. Em arrays o índice inicia
		 * em ZERO.
		 */
		String alunos[] = { "Felipe", "Jonas", "Julia", "Marcos" };

		/*
		 * Na inicialização criamos uma variável x, pra representar o índice de um
		 * elemento em um array; a condição determina que enquanto x for menor que o
		 * tamanho do array de alunos (length); ele vai incrementar de um em um.
		 */
		// For
		for (int x = 0; x < alunos.length; x++) {
			/* Vai imprimir o nome dos alunos pelo índice. */
			System.out.println("O aluno no índice x=" + x + " é " + alunos[x]);
		}

		System.out.println();
		// For each
		/*
		 * Tenho elementos e esse elemento é de um tipo. Quando eu coloco dois pontos
		 * quer dizer que a cada iteração de alunos, o aluno atual, no índice atual vai
		 * atualizar automaticamente essa variável.
		 */
		for (String aluno : alunos) {
			System.out.println("Nome do aluno é: " + aluno);
		}

	}

}
