package condicionais;

public class CaixaEletronico {

	// temos o escopo de m�todo
	public static void main(String[] args) {
		/*
		 * temos duas vari�veis, essas informa��es poderiam vir de um banco de dados ou
		 * de intera��o da tela dos usu�rios
		 */
		// vari�vel denominada saldo que recebe o valor de 25
		double saldo = 25.0;
		// estamos simulando um valor solicitado igual a 17
		double valorSolicitado = 22.0;

		/*
		 * se o valor solicitado for menor que o meu saldo, o bloco abaixo ser�
		 * executado, caso ao contr�rio nada vai acontecer nessa instru��o, dessa
		 * maneira a �nica execu��o que ser� executada � a pr�xima que � imprimir o
		 * saldo ap�s a opera��o.
		 */
		if (valorSolicitado < saldo) { // o valor solicitado � menor que o saldo
			/*
			 * logo nosso saldo, vai entrar no seu fluxo de opera��es e o nosso saldo vai
			 * passar a ter o seu valor menos o valor solicitado
			 */
			saldo = saldo - valorSolicitado;
			System.out.println("Novo saldo: " + saldo);

		} else {
			System.out.println("Saldo insuficiente");
		}
		/*
		 * Se dentro do meu if, ou dentro do else, eu tenho mais de uma instru��o eu
		 * preciso criar um bloco para esse fluxo com {}
		 */
	}

}
