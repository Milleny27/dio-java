package condicionais;

public class ResultadoEscolarOperadorTernario {

	public static void main(String[] args) {
		int nota = 6;
		/*
		 * Tenho uma express�o tern�ria que joga para uma vari�vel, e dessa vari�vel eu
		 * posso imprimir, salvar em arquivo etc. A medida que a gente vai entendendo
		 * alguns conceitos, a gente vai aprimorando e vai otimizando as nossas
		 * implementa��es.
		 */
		/*
		 * Estou determinando que eu tenho uma vari�vel resultado, e ela vai ser igual a
		 * se a nota for maior ou igual a 7. Se a nota for maior ou igual a 7, ap�s o
		 * ponto de interroga��o ele atribui/determina o valor dessa vari�vel como
		 * Aprovado, sen�o imprime reprovado.
		 */
		//String resultado = nota >= 7 ? "Aprovado" : "Reprovado";

		//System.out.println(resultado);
		
		/*Traz a ideia de controle de fluxo encadeado*/
		String resultado = nota >= 7 ? "Aprovado" : nota >=5 && nota < 7? "Recupera��o" : "Reprovado";
		/*Essa atribui��o pode ser de qualquer tipo*/

		System.out.println(resultado);

	}

}
