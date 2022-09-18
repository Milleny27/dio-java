package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ExemploList {

	public static void main(String[] args) {
		// Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:
		/* Existem várias formas de iniciar um List. */

//		List notas = new ArrayList();
		/*
		 * antes do java 5, compila do java 5 o conceito de generics - List<Double>, a
		 * partir do Java 7 foi criado o conceito de Diamond Operator - ArrayList<>()
		 */
//      ArrayList<Double> notas = new ArrayList<>();
		/*
		 * é uma forma de você instanciar ela com a implementação, por que não é
		 * recomendável fazer dessa forma? É recomendado a gente programar voltado para
		 * a interface e não para a implementação.
		 */
//      List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
		/*
		 * A gente instancia o arrayList e dentro passa como um parâmetro, o
		 * arrasy.asList e colocar ali dentro os elementos que queremos adicionar nessa
		 * List
		 */

		/*
		 * List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
		 * notas.add(10d); System.out.println(notas);
		 */
		/*
		 * Inicia uma List de Double, inicia a variável, passa direto um arrays.asList.
		 * É uma forma válida, mas limitada, exemplo: nessa forma eu não posso adicionar
		 * ou então não posso retirar. Apresenta um erro.
		 */

		/*
		 * List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); notas.add(1d);
		 * notas.remove(5d); System.out.println(notas);
		 */
		/*
		 * Essa forma, torna a lista imútavel, posso utilizar alguns outros métodods,
		 * não posso adicionar e remover
		 */

		System.out.println("---\tCrie uma lista e adicione as sete notas\t---");
		/*
		 * criando uma lista, existem várias maneiras de adicionar, precisa vereficar os
		 * parâmetros
		 */
		List<Double> notas = new ArrayList<Double>(); // Generics(jdk 5) - Diamond Operator(jdk 7)
		notas.add(7.0);
		notas.add(8.5);
		notas.add(9.3);
		notas.add(5.0);
		notas.add(7.0);
		notas.add(0.0);
		notas.add(3.6);
		/* pode imprimir passando a variáve */
		System.out.println(notas.toString());

		System.out.println();

		/*
		 * Para exibir a posição de um elemento dentro de uma lista, temos um método
		 * chamado "indexOf", passamos o objeto e ele retorna um int, que é a posição
		 */
		System.out.println("---\tExiba a posição da nota 5.0: " + notas.indexOf(5d) + "\t---");
		System.out.println();

		/*
		 * Vamos adicionar o elemento, é o mesmo método, só que passando os argumentos:
		 * posição e o elemento
		 */
		System.out.println("---\tAdicione na lista a nota 8.0 na posição 4:\t---");
		notas.add(4, 8d);
		System.out.println(notas);
		System.out.println();

		/*
		 * O médoto de substituição vai ser o notas.set que recebe a posição que eu
		 * quero substituir, e o novo elemento. Mas como que eu posso saber a posição do
		 * elemento 5? Pelo indexOf.
		 */
		System.out.println("---\tSubstitua a nota 5.0 pela nota 6.0: \t---");
		notas.set(notas.indexOf(5d), 6.0);
		System.out.println(notas);
		System.out.println();

		/*
		 * Qual o método pra saber se existe determinado elemento na lista? Contains,
		 * passamos um objeto e ele retorna um boolean. Vai retornar false, pois o 5 foi
		 * substituído.
		 */
		System.out.println("---\tConfira se a nota 5.0 está na lista: " + notas.contains(5d) + "\t---");
		System.out.println();

		/*
		 * Como estamos utilizando um List, obrigatoriamente os elementos são ordenados
		 * de acordo com a ordem de inserção. Então seria somente imprimir a lista.
		 */
		System.out.println("---\tExiba todas as notas na ordem em que foram informados: \t---");
		for (Double nota : notas) {
			System.out.println(nota);
		}
		System.out.println();

		/*
		 * Para que a gente passe uma posição e retorne um elemento, utilizamos o método
		 * get - passamos a posição e recebemos o elemento. índice = posição - 1
		 */
		System.out.println("---\tExiba a terceira nota adicionada: " + notas.get(2) + "\t---");
		System.out.println(notas.toString());
		System.out.println();

		/*
		 * Nã existe um método nativo no List para chamar e retornar o menor valor, mas
		 * eu posso utilizar da classe collections o método min - passando uma
		 * collection. Como que esse método faz essa comparação para saber qual é menor
		 * ou maior? Os elementos da List é do tipo Double, e na classe Double ele
		 * implementa uma interface comparable - essa interface que faz a comparação e
		 * me diz qual é o maior, menor, o primeiro etc.
		 */
		System.out.println("---\tExiba a menor nota: " + Collections.min(notas) + "\t---");
		System.out.println();

		/* Igual ao min */
		System.out.println("---\tExiba a maior nota: " + Collections.max(notas) + "\t---");
		System.out.println();

		/*
		 * Também existe um método para retornar a soma - sum. Mas podemos utilizar um
		 * método iterator para iterar dentro da lista, e partir dessa iteração pegar os
		 * elementos e ir somando. Chamamos o método, criamos uma variável. Fazemos um
		 * laço, perguntamos ao iterator se tem próximo elemento, pegamos esse próximo
		 * elemento, colocamos dentro de uma variável e somamos essa variável com a
		 * variável soma que iniciou com zero. Quando não tiver um próximo, encerra o
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
		 * A média é a soma (que captamos no exercício anterior) dividido pelo tamanho
		 * da List. Como sabemos o tamanho da List? Pelo método size - me retorna um
		 * inteiro que significa a quantidade de elementos que tem na List.
		 */
		System.out.println("---\tExiba a média das notas: " + (soma / notas.size()) + "\t---");

		/*
		 * Pra remoção existe o método remove - passamos tanto a posição quanto o
		 * objeto. Se não colocar o d, ele fica um inteiro e assim ele ficaria como
		 * posição.
		 */
		System.out.println("---\tRemova a nota 0: \t---");
		notas.remove(0d);
		System.out.println(notas);
		System.out.println();

		/* Agora deixamos como inteiro para removar pela posição */
		System.out.println("---\tRemova a nota da posição 0 \t---");
		notas.remove(0);
		System.out.println(notas);
		System.out.println();

		/*
		 * Para saber as notas menores que 7, fazemos um iterator. Enquanto houver um
		 * próximo elemento, pegarei ele e colocarei em uma variável, se esse próximo
		 * elemento for menor que 7, eu quero que remova esse elemento de dentro da
		 * lista, senão volta para o laço.
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
		 * A gente tem um método que se chama clear - ele apaga toda a lista
		 * System.out.println("Apague toda a lista"); notas.clear();
		 * System.out.println(notas);
		 */

		/*
		 * isEmpty é um boolean que retorna true se estiver vazia ou false se não
		 * estiver
		 */
		System.out.println("---\tConfira se a lista está vazia: " + notas.isEmpty() + "\t---");

		/*
		 * Para você: Resolva esses exercícios utilizando os métodos da implementação
		 * LinkedList: System.out.println("Crie uma lista chamada notas2 " +
		 * "e coloque todos os elementos da list Arraylist nessa nova lista: ");
		 * System.out.println("Mostre a primeira nota da nova lista sem removê-lo: ");
		 * System.out.println("Mostre a primeira nota da nova lista removendo-o: ");
		 */
		
		System.out.println();
		System.out.println("\tLinkedList - exercícios\t");
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
		
		System.out.println("---\tMostre a primeira nota da nova lista sem removê-lo: " + notas2.get(0) + "\t---");
		System.out.println();
		
		System.out.println("---\tMostre a primeira nota da nova lista removendo-o: " + notas2.remove(0) + "\t---");
		System.out.println(notas2);

	}

}
