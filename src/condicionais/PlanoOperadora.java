package condicionais;

public class PlanoOperadora {

	public static void main(String[] args) {
		String plano = "T";

		// if/else
		if (plano == "B") {
			System.out.println("100 minutos de liga��o");
		} else if (plano == "M") {
			System.out.println("100 minutos de liga��o");
			System.out.println("Whats e Instagram gr�tis");
		} else if (plano == "T") {
			System.out.println("100 minutos de liga��o");
			System.out.println("Whats e Instagram gr�tis");
			System.out.println("5Gb YouTube");
		}

		System.out.println();
		// switch
		switch (plano) {
		case "T": {
			System.out.println("5Gb YouTube");
		}
		case "M": {
			System.out.println("Whats e Instagram gr�tis");
		}
		case "B": {
			System.out.println("100 minutos de liga��o");
		}
		}
		/*
		 * T� em ordem decrescente e sem o break, tudo o que vier abaixo vai ser exibido
		 * tamb�m. Essa � uma proposta onde o switch fica como algo complementar e n�o
		 * controles de fluxos condicionais.
		 */

	}

}
