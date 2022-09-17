package condicionais;

public class ResultadoEscolarOperadorTernario {

	public static void main(String[] args) {
		int nota = 6;
		/*
		 * Tenho uma expressão ternária que joga para uma variável, e dessa variável eu
		 * posso imprimir, salvar em arquivo etc. A medida que a gente vai entendendo
		 * alguns conceitos, a gente vai aprimorando e vai otimizando as nossas
		 * implementações.
		 */
		/*
		 * Estou determinando que eu tenho uma variável resultado, e ela vai ser igual a
		 * se a nota for maior ou igual a 7. Se a nota for maior ou igual a 7, após o
		 * ponto de interrogação ele atribui/determina o valor dessa variável como
		 * Aprovado, senão imprime reprovado.
		 */
		//String resultado = nota >= 7 ? "Aprovado" : "Reprovado";

		//System.out.println(resultado);
		
		/*Traz a ideia de controle de fluxo encadeado*/
		String resultado = nota >= 7 ? "Aprovado" : nota >=5 && nota < 7? "Recuperação" : "Reprovado";
		/*Essa atribuição pode ser de qualquer tipo*/

		System.out.println(resultado);

	}

}
