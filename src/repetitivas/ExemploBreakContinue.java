package repetitivas;

public class ExemploBreakContinue {

	public static void main(String[] args) {
		for (int numero = 1; numero <= 5; numero++) {
			if (numero == 3) {
				break;
			}
			System.out.println(numero);
		}
		/*
		 * Por mais que a condi��o determinasse que fosse de 1 a 5, quando chegou no
		 * n�mero 3, ele detectou que tinha o break dependendo de uma condi��o, ele
		 * interrompeu o for. Podem ter situa��es em que queremos aplicar uma regra de
		 * neg�cio que ao ser verdadeiro ela interrompa nosssa execu��o.
		 */

		System.out.println();

		for (int numero = 1; numero <= 5; numero++) {
			if (numero == 3) {
				continue;
			}
			System.out.println(numero);
		}
		/*
		 * O continue muda o fluxo daquela itera��o naquele momento, n�o parou o for
		 * completamente.
		 */
	}

}
