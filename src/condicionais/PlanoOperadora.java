package condicionais;

public class PlanoOperadora {

	public static void main(String[] args) {
		String plano = "T";

		// if/else
		if (plano == "B") {
			System.out.println("100 minutos de ligação");
		} else if (plano == "M") {
			System.out.println("100 minutos de ligação");
			System.out.println("Whats e Instagram grátis");
		} else if (plano == "T") {
			System.out.println("100 minutos de ligação");
			System.out.println("Whats e Instagram grátis");
			System.out.println("5Gb YouTube");
		}

		System.out.println();
		// switch
		switch (plano) {
		case "T": {
			System.out.println("5Gb YouTube");
		}
		case "M": {
			System.out.println("Whats e Instagram grátis");
		}
		case "B": {
			System.out.println("100 minutos de ligação");
		}
		}
		/*
		 * Tá em ordem decrescente e sem o break, tudo o que vier abaixo vai ser exibido
		 * também. Essa é uma proposta onde o switch fica como algo complementar e não
		 * controles de fluxos condicionais.
		 */

	}

}
