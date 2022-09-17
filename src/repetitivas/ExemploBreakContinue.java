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
		 * Por mais que a condição determinasse que fosse de 1 a 5, quando chegou no
		 * número 3, ele detectou que tinha o break dependendo de uma condição, ele
		 * interrompeu o for. Podem ter situações em que queremos aplicar uma regra de
		 * negócio que ao ser verdadeiro ela interrompa nosssa execução.
		 */

		System.out.println();

		for (int numero = 1; numero <= 5; numero++) {
			if (numero == 3) {
				continue;
			}
			System.out.println(numero);
		}
		/*
		 * O continue muda o fluxo daquela iteração naquele momento, não parou o for
		 * completamente.
		 */
	}

}
