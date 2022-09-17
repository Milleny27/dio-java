package condicionais;

public class SistemaMedida {

	public static void main(String[] args) {
		String sigla = "A";

		// Modo condicional if/else
		System.out.println("-------- if/else --------");
		if (sigla == "P") {
			System.out.println("PEQUENO");
		} else if (sigla == "M") {
			System.out.println("MEDIO");
		} else if (sigla == "G") {
			System.out.println("GRANDE");
		} else {
			System.out.println("INDEFINIDO");
		}

		System.out.println();
		System.out.println("-------- switch --------");
		// Modo switch case
		/* se essa sigla for caso P imprimo pequeno e dou break e assim vai */
		switch (sigla) {
		case "P": {
			System.out.println("PEQUENO");
			break;
		}
		case "M": {
			System.out.println("MEDIO");
			break;
		}
		case "G": {
			System.out.println("GRANDE");
			break;
		}
		default:
			System.out.println("INDEFINIDO");
		}

		/*
		 * O c�digo aqui n�o trouxe nenhum benef�cio em n�vel de sintaxe, e a gente tem
		 * que se preocupar com o break O switch tem suas aplicabilidades, mas ele n�o
		 * consegue, �s vezes, ser mais perform�tico a n�vel de sintaxe e complexidade
		 * do que o if tradicional.
		 */
	}

}
