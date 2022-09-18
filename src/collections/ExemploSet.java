package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExemploSet {
	public static void main(String[] args) {
// Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], fa�a:

//      Set notas = new HashSet(); //antes do java 5
//      HashSet<Double> notas = new HashSet<>();
//      Set<Double> notas = new HashSet<>(); //Generics(jdk 5) - Diamont Operator(jdk 7)
		/*
		 * Set<Double> notas = Set.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); notas.add(1d);
		 * notas.remove(5d); System.out.println(notas);
		 */

		System.out.println("--\tCrie um conjunto e adicione as notas: \t--");
		/*
		 * criando um set de notas implementando o HashSet e colocando como argumento um
		 * arrays.asList com todas as notas
		 */
		Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
		System.out.println(notas.toString());
		System.out.println();

		/*
		 * Trabalhando com Set, n�o consigo pesquisar / fazer buscas de acordo com a
		 * posi��o, principalmente no HashSet, porque a ordem fica de forma aleat�ria.
		 * N�o tem como fazer substitui��es tamb�m.
		 */
//        System.out.println("Exiba a posi��o da nota 5.0: ");

//        System.out.println("Adicione na lista a nota 8.0 na posi��o 4: ");

//        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");

		/* Utilizando o m�todo contains passando o objeto, ele retorna true ou false */
		System.out.println("--\tConfira se a nota 5.0 est� no conjunto: " + notas.contains(5d) + "\t---");
		System.out.println();

		/* N�o tenho o m�todo get para passar o �ndice e ele me retornar a nota */
//        System.out.println("Exiba a terceira nota adicionada: ");

		/* Utilizo o m�todo min da classe collections passando uma collection */
		System.out.println("---\tExiba a menor nota: " + Collections.min(notas) + "\t---");
		System.out.println();

		/* Utilizo o m�todo max da classe collections passando uma collection */
		System.out.println("---\tExiba a maior nota: " + Collections.max(notas) + "\t---");
		System.out.println();

		/*
		 * Tamb�m existe um m�todo para retornar a soma - sum. Mas podemos utilizar um
		 * m�todo iterator para iterar dentro da lista, e partir dessa itera��o pegar os
		 * elementos e ir somando. Chamamos o m�todo, criamos uma vari�vel. Fazemos um
		 * la�o, perguntamos ao iterator se tem pr�ximo elemento, pegamos esse pr�ximo
		 * elemento, colocamos dentro de uma vari�vel e somamos essa vari�vel com a
		 * vari�vel soma que iniciou com zero. Quando n�o tiver um pr�ximo, encerra o
		 * while. Por que o valor deu diferente do List, se os valores eram iguais?
		 * Porque n�o se repetiu elementos.
		 */
		Iterator<Double> iterator = notas.iterator();
		Double soma = 0.0;
		while (iterator.hasNext()) {
			Double next = iterator.next();
			soma += next;
		}
		System.out.println("---\tExiba a soma dos valores: " + soma + "\t---");
		System.out.println();

		System.out.println("---\tExiba a m�dia das notas: " + (soma / notas.size()) + "\t---");
		System.out.println();

		/* Ele n�o tem o remove por �ndice */
		System.out.println("---\tRemova a nota 0: \t---");
		notas.remove(0d);
		System.out.println(notas);
		System.out.println();

//        System.out.println("Remova a nota da posi��o 0");

		/*
		 * Vou chamar o iterator, vou criar a vari�vel. Enquanto houver pr�ximo elemento
		 * no iterator, vou criar uma vari�vel para o meu pr�ximo elemento e se ele for
		 * menor que 7, vou pedir para remover.
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
		 * Aqui tenho que trabalhar com o LinkedHashSet, pois o HashSet n�o ordena por
		 * ordem de inser��o.
		 */
		System.out.println("---\tExiba todas as notas na ordem em que foram informados: \t---");
		Set<Double> notas2 = new LinkedHashSet<>();
		notas2.add(7d);
		notas2.add(8.5);
		notas2.add(9.3);
		notas2.add(5d);
		notas2.add(7d);
		notas2.add(0d);
		notas2.add(3.6);
		System.out.println(notas2);
		System.out.println();

		/*
		 * Aqui tenho que utilizar a TreeSet, porque ela organiza de acordo com a ordem
		 * natural dos elementos. Estou trabalhando com o Double e ele tem o comparable.
		 */
		System.out.println("---\tExiba todas as notas na ordem crescente: \t---");
		Set<Double> notas3 = new TreeSet<>(notas2);
		System.out.println(notas3);
		System.out.println();

		System.out.println("---\tApague todo o conjunto\t---");
		notas.clear();
		System.out.println();

		System.out.println("---\tConfira se o conjunto est� vazio: " + notas.isEmpty() + "\t---");
		System.out.println("---\tConfira se o conjunto 2 est� vazio: " + notas2.isEmpty() + "\t---");
		System.out.println("---\tConfira se o conjunto 3 est� vazio: " + notas3.isEmpty() + "\t---");

	}
}
