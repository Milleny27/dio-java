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
// Dada uma lista com 7 notas de um aluno [7, 8.5, 9.3, 5, 7, 0, 3.6], faça:

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
		 * Trabalhando com Set, não consigo pesquisar / fazer buscas de acordo com a
		 * posição, principalmente no HashSet, porque a ordem fica de forma aleatória.
		 * Não tem como fazer substituições também.
		 */
//        System.out.println("Exiba a posição da nota 5.0: ");

//        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");

//        System.out.println("Substitua a nota 5.0 pela nota 6.0: ");

		/* Utilizando o método contains passando o objeto, ele retorna true ou false */
		System.out.println("--\tConfira se a nota 5.0 está no conjunto: " + notas.contains(5d) + "\t---");
		System.out.println();

		/* Não tenho o método get para passar o índice e ele me retornar a nota */
//        System.out.println("Exiba a terceira nota adicionada: ");

		/* Utilizo o método min da classe collections passando uma collection */
		System.out.println("---\tExiba a menor nota: " + Collections.min(notas) + "\t---");
		System.out.println();

		/* Utilizo o método max da classe collections passando uma collection */
		System.out.println("---\tExiba a maior nota: " + Collections.max(notas) + "\t---");
		System.out.println();

		/*
		 * Também existe um método para retornar a soma - sum. Mas podemos utilizar um
		 * método iterator para iterar dentro da lista, e partir dessa iteração pegar os
		 * elementos e ir somando. Chamamos o método, criamos uma variável. Fazemos um
		 * laço, perguntamos ao iterator se tem próximo elemento, pegamos esse próximo
		 * elemento, colocamos dentro de uma variável e somamos essa variável com a
		 * variável soma que iniciou com zero. Quando não tiver um próximo, encerra o
		 * while. Por que o valor deu diferente do List, se os valores eram iguais?
		 * Porque não se repetiu elementos.
		 */
		Iterator<Double> iterator = notas.iterator();
		Double soma = 0.0;
		while (iterator.hasNext()) {
			Double next = iterator.next();
			soma += next;
		}
		System.out.println("---\tExiba a soma dos valores: " + soma + "\t---");
		System.out.println();

		System.out.println("---\tExiba a média das notas: " + (soma / notas.size()) + "\t---");
		System.out.println();

		/* Ele não tem o remove por índice */
		System.out.println("---\tRemova a nota 0: \t---");
		notas.remove(0d);
		System.out.println(notas);
		System.out.println();

//        System.out.println("Remova a nota da posição 0");

		/*
		 * Vou chamar o iterator, vou criar a variável. Enquanto houver próximo elemento
		 * no iterator, vou criar uma variável para o meu próximo elemento e se ele for
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
		 * Aqui tenho que trabalhar com o LinkedHashSet, pois o HashSet não ordena por
		 * ordem de inserção.
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

		System.out.println("---\tConfira se o conjunto está vazio: " + notas.isEmpty() + "\t---");
		System.out.println("---\tConfira se o conjunto 2 está vazio: " + notas2.isEmpty() + "\t---");
		System.out.println("---\tConfira se o conjunto 3 está vazio: " + notas3.isEmpty() + "\t---");

	}
}
