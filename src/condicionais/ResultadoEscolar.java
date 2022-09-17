package condicionais;

public class ResultadoEscolar {

	public static void main(String[] args) {
		/* Tenho aqui uma vari�vel que representa a nota do meu aluno */
		int nota = 10;

		/*
		 * Estou verificando se a nota � maior ou igual a uma nota correspondente Tenho
		 * a minha vari�vel e tenho a condi��o que determina se vou executar neste fluxo
		 */
		if (nota >= 7) {
			System.out.println("Aprovado");
		}
		/* sen�o se ele vai imprimir ou realizar alguma coisa pertinente */
		else if (nota >= 5 && nota < 7) { // true or false
			System.out.println("Recupera��o");
		}
		/*
		 * Sen�o, se minha nota n�o for nem maior, nem igual a 7, ele vai imprimir /
		 * entrar neste fluxo
		 */
		else {
			System.out.println("Reprovado");
		}
		/*
		 * Essa � uma condi��o composta, tenho tanto o fluxo quando a condi��o for
		 * verdadeira, como quando a condi��o for falsa. O if sempre � a primeira
		 * condi��o e o else a �ltima. Nossa implementa��o n�o deve interferir nas
		 * estruturas ou nos blocos condicionais j� previamente estruturados.
		 */

	}

}
