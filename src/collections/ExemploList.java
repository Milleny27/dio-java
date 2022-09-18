package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExemploList {

	public static void main(String[] args) {
		// Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], fa�a:
		/* Existem v�rias formas de iniciar um List. */

//		List notas = new ArrayList();
		/*
		 * antes do java 5, compila do java 5 o conceito de generics - List<Double>, a
		 * partir do Java 7 foi criado o conceito de Diamond Operator - ArrayList<>()
		 */
//      ArrayList<Double> notas = new ArrayList<>();
		/*
		 * � uma forma de voc� instanciar ela com a implementa��o, por que n�o �
		 * recomend�vel fazer dessa forma? � recomendado a gente programar voltado para
		 * a interface e n�o para a implementa��o.
		 */
//      List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
		/*
		 * A gente instancia o arrayList e dentro passa como um par�metro, o
		 * arrasy.asList e colocar ali dentro os elementos que queremos adicionar nessa
		 * List
		 */

		/*
		 * List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
		 * notas.add(10d); System.out.println(notas);
		 */
		/*
		 * Inicia uma List de Double, inicia a vari�vel, passa direto um arrays.asList.
		 * � uma forma v�lida, mas limitada, exemplo: nessa forma eu n�o posso adicionar
		 * ou ent�o n�o posso retirar. Apresenta um erro.
		 */

		/*
		 * List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); notas.add(1d);
		 * notas.remove(5d); System.out.println(notas);
		 */
		/*
		 * Essa forma, torna a lista im�tavel, posso utilizar alguns outros m�todods,
		 * n�o posso adicionar e remover
		 */

		System.out.println("---\tCrie uma lista e adicione as sete notas\t---");
		/*
		 * criando uma lista, existem v�rias maneiras de adicionar, precisa vereficar os
		 * par�metros
		 */
		List<Double> notas = new ArrayList<Double>(); // Generics(jdk 5) - Diamond Operator(jdk 7)
		notas.add(7.0);
		notas.add(8.5);
		notas.add(9.3);
		notas.add(5.0);
		notas.add(7.0);
		notas.add(0.0);
		notas.add(3.6);
		/* pode imprimir passando a vari�ve */
		System.out.println(notas.toString());

		System.out.println();

		/*
		 * Para exibir a posi��o de um elemento dentro de uma lista, temos um m�todo
		 * chamado "indexOf", passamos o objeto e ele retorna um int, que � a posi��o
		 */
		System.out.println("---\tExiba a posi��o da nota 5.0: " + notas.indexOf(5d) + "\t---");
		System.out.println();

		/*
		 * Vamos adicionar o elemento, � o mesmo m�todo, s� que passando os argumentos:
		 * posi��o e o elemento
		 */
		System.out.println("---\tAdicione na lista a nota 8.0 na posi��o 4:\t---");
		notas.add(4, 8d);
		System.out.println(notas);
		System.out.println();

		/*
		 * O m�doto de substitui��o vai ser o notas.set que recebe a posi��o que eu
		 * quero substituir, e o novo elemento. Mas como que eu posso saber a posi��o do
		 * elemento 5? Pelo indexOf.
		 */
		System.out.println("---\tSubstitua a nota 5.0 pela nota 6.0: \t---");
		notas.set(notas.indexOf(5d), 6.0);
		System.out.println(notas);
		System.out.println();

		/*
		 * Qual o m�todo pra saber se existe determinado elemento na lista? Contains,
		 * passamos um objeto e ele retorna um boolean. Vai retornar false, pois o 5 foi
		 * substitu�do.
		 */
		System.out.println("---\tConfira se a nota 5.0 est� na lista: " + notas.contains(5d) + "\t---");
		System.out.println();

		/*
		 * Como estamos utilizando um List, obrigatoriamente os elementos s�o ordenados
		 * de acordo com a ordem de inser��o. Ent�o seria somente imprimir a lista.
		 */
		System.out.println("---\tExiba todas as notas na ordem em que foram informados: \t---");
		for (Double nota : notas) {
			System.out.println(nota);
		}
		System.out.println();

		/*
		 * Para que a gente passe uma posi��o e retorne um elemento, utilizamos o m�todo
		 * get - passamos a posi��o e recebemos o elemento. �ndice = posi��o - 1
		 */
		System.out.println("---\tExiba a terceira nota adicionada: " + notas.get(2) + "\t---");
		System.out.println(notas.toString());
		System.out.println();

		/*
		 * N� existe um m�todo nativo no List para chamar e retornar o menor valor, mas
		 * eu posso utilizar da classe collections o m�todo min - passando uma
		 * collection. Como que esse m�todo faz essa compara��o para saber qual � menor
		 * ou maior? Os elementos da List � do tipo Double, e na classe Double ele
		 * implementa uma interface comparable - essa interface que faz a compara��o e
		 * me diz qual � o maior, menor, o primeiro etc.
		 */
		System.out.println("---\tExiba a menor nota: " + Collections.min(notas) + "\t---");
		System.out.println();

		/* Igual ao min */
		System.out.println("---\tExiba a maior nota: " + Collections.max(notas) + "\t---");
		System.out.println();

		/*
		 * Tamb�m existe um m�todo para retornar a soma - sum. Mas podemos utilizar um
		 * m�todo iterator para iterar dentro da lista, e partir dessa itera��o pegar os
		 * elementos e ir somando. Chamamos o m�todo, criamos uma vari�vel. Fazemos um
		 * la�o, perguntamos ao iterator se tem pr�ximo elemento, pegamos esse pr�ximo
		 * elemento, colocamos dentro de uma vari�vel e somamos essa vari�vel com a
		 * vari�vel soma que iniciou com zero. Quando n�o tiver um pr�ximo, encerra o
		 * while.
		 */
		Iterator<Double> iterator = notas.iterator();
		Double soma = 0d;
		while (iterator.hasNext()) {
			Double next = iterator.next();
			soma += next;
		}
		System.out.println("---\tExiba a soma dos valores: " + soma + "\t---");

		/*
		 * A m�dia � a soma (que captamos no exerc�cio anterior) dividido pelo tamanho
		 * da List. Como sabemos o tamanho da List? Pelo m�todo size - me retorna um
		 * inteiro que significa a quantidade de elementos que tem na List.
		 */
		System.out.println("---\tExiba a m�dia das notas: " + (soma / notas.size()) + "\t---");

		/*
		 * Pra remo��o existe o m�todo remove - passamos tanto a posi��o quanto o
		 * objeto. Se n�o colocar o d, ele fica um inteiro e assim ele ficaria como
		 * posi��o.
		 */
		System.out.println("---\tRemova a nota 0: \t---");
		notas.remove(0d);
		System.out.println(notas);
		System.out.println();

		/* Agora deixamos como inteiro para removar pela posi��o */
		System.out.println("---\tRemova a nota da posi��o 0 \t---");
		notas.remove(0);
		System.out.println(notas);
		System.out.println();

		/*
		 * Para saber as notas menores que 7, fazemos um iterator. Enquanto houver um
		 * pr�ximo elemento, pegarei ele e colocarei em uma vari�vel, se esse pr�ximo
		 * elemento for menor que 7, eu quero que remova esse elemento de dentro da
		 * lista, sen�o volta para o la�o.
		 */
		System.out.println("---\tRemova as notas menores que 7 e exiba a lista: \t---");
		Iterator<Double> iterator1 = notas.iterator();
		while (iterator1.hasNext()) {
			Double next = iterator1.next();
			if (next < 7)
				iterator1.remove();
		}
		System.out.println(notas);
		System.out.println();

		/*
		 * A gente tem um m�todo que se chama clear - ele apaga toda a lista
		 * System.out.println("Apague toda a lista"); notas.clear();
		 * System.out.println(notas);
		 */

		/*
		 * isEmpty � um boolean que retorna true se estiver vazia ou false se n�o
		 * estiver
		 */
		System.out.println("---\tConfira se a lista est� vazia: " + notas.isEmpty() + "\t---");

		/*
		 * Para voc�: Resolva esses exerc�cios utilizando os m�todos da implementa��o
		 * LinkedList: System.out.println("Crie uma lista chamada notas2 " +
		 * "e coloque todos os elementos da list Arraylist nessa nova lista: ");
		 * System.out.println("Mostre a primeira nota da nova lista sem remov�-lo: ");
		 * System.out.println("Mostre a primeira nota da nova lista removendo-o: ");
		 */
		
		System.out.println();
		System.out.println("\tLinkedList - exerc�cios\t");
		System.out.println();
		
		System.out.println("---\tCrie uma lista chamada notas2 e coloque todos os elementos da list Arraylist nessa nova lista: \t---");
		List<Double> notas2 = new LinkedList<>();
		notas2.add(7.0);
		notas2.add(8.5);
		notas2.add(9.3);
		notas2.add(5.0);
		notas2.add(7.0);
		notas2.add(0.0);
		notas2.add(3.6);
		System.out.println(notas2);
		System.out.println();
		
		System.out.println("---\tMostre a primeira nota da nova lista sem remov�-lo: " + notas2.get(0) + "\t---");
		System.out.println();
		
		System.out.println("---\tMostre a primeira nota da nova lista removendo-o: " + notas2.remove(0) + "\t---");
		System.out.println(notas2);

	}

}
