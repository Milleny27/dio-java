package condicionais;

public class ResultadoEscolar {

	public static void main(String[] args) {
		/* Tenho aqui uma variável que representa a nota do meu aluno */
		int nota = 10;

		/*
		 * Estou verificando se a nota é maior ou igual a uma nota correspondente Tenho
		 * a minha variável e tenho a condição que determina se vou executar neste fluxo
		 */
		if (nota >= 7) {
			System.out.println("Aprovado");
		}
		/* senão se ele vai imprimir ou realizar alguma coisa pertinente */
		else if (nota >= 5 && nota < 7) { // true or false
			System.out.println("Recuperação");
		}
		/*
		 * Senão, se minha nota não for nem maior, nem igual a 7, ele vai imprimir /
		 * entrar neste fluxo
		 */
		else {
			System.out.println("Reprovado");
		}
		/*
		 * Essa é uma condição composta, tenho tanto o fluxo quando a condição for
		 * verdadeira, como quando a condição for falsa. O if sempre é a primeira
		 * condição e o else a última. Nossa implementação não deve interferir nas
		 * estruturas ou nos blocos condicionais já previamente estruturados.
		 */

	}

}
