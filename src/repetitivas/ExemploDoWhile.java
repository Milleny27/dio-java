package repetitivas;

import java.util.Random;

public class ExemploDoWhile {

	public static void main(String[] args) {
		System.out.println("Discando ...");

		do {
			// executando repetidas vezes at� algu�m atender
			System.out.println("Telefone tocando");
		} while (tocando());

		System.out.println("Al� !!!");
		/*
		 * Vai executar dizendo que est� discando, depois vai registrar que o telefone
		 * est� tocando, enquanto a express�o "tocando()" for verdadeira. Quando a
		 * express�o se tornar falsa, o algoritimo vai para o "Al�".
		 */

	}

	private static boolean tocando() {
		/*
		 * atendeu, tem o valor entre 1 e 3, e se nesse valor aleat�rio, o n�mero
		 * sorteado for igual a 1, quer dizer que ele atendeu. E se ele atendeu, eu vou
		 * dizer que n�o est� mais tocando.
		 */
		boolean atendeu = new Random().nextInt(3) == 1;
		System.out.println("Atendeu? " + atendeu);
		// negando o ato de continuar tocando
		return !atendeu;
	}

}
