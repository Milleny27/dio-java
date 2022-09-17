package repetitivas;

import java.util.Random;

public class ExemploDoWhile {

	public static void main(String[] args) {
		System.out.println("Discando ...");

		do {
			// executando repetidas vezes até alguém atender
			System.out.println("Telefone tocando");
		} while (tocando());

		System.out.println("Alô !!!");
		/*
		 * Vai executar dizendo que está discando, depois vai registrar que o telefone
		 * está tocando, enquanto a expressão "tocando()" for verdadeira. Quando a
		 * expressão se tornar falsa, o algoritimo vai para o "Alô".
		 */

	}

	private static boolean tocando() {
		/*
		 * atendeu, tem o valor entre 1 e 3, e se nesse valor aleatório, o número
		 * sorteado for igual a 1, quer dizer que ele atendeu. E se ele atendeu, eu vou
		 * dizer que não está mais tocando.
		 */
		boolean atendeu = new Random().nextInt(3) == 1;
		System.out.println("Atendeu? " + atendeu);
		// negando o ato de continuar tocando
		return !atendeu;
	}

}
