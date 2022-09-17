package condicionais;

public class CaixaEletronico {

	// temos o escopo de método
	public static void main(String[] args) {
		/*
		 * temos duas variáveis, essas informações poderiam vir de um banco de dados ou
		 * de interação da tela dos usuários
		 */
		// variável denominada saldo que recebe o valor de 25
		double saldo = 25.0;
		// estamos simulando um valor solicitado igual a 17
		double valorSolicitado = 22.0;

		/*
		 * se o valor solicitado for menor que o meu saldo, o bloco abaixo será
		 * executado, caso ao contrário nada vai acontecer nessa instrução, dessa
		 * maneira a única execução que será executada é a próxima que é imprimir o
		 * saldo após a operação.
		 */
		if (valorSolicitado < saldo) { // o valor solicitado é menor que o saldo
			/*
			 * logo nosso saldo, vai entrar no seu fluxo de operações e o nosso saldo vai
			 * passar a ter o seu valor menos o valor solicitado
			 */
			saldo = saldo - valorSolicitado;
			System.out.println("Novo saldo: " + saldo);

		} else {
			System.out.println("Saldo insuficiente");
		}
		/*
		 * Se dentro do meu if, ou dentro do else, eu tenho mais de uma instrução eu
		 * preciso criar um bloco para esse fluxo com {}
		 */
	}

}
