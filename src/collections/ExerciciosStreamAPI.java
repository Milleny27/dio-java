package collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {

	public static void main(String[] args) {
		List<String> numerosAleatorios = Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

		/*
		 * Imprimir utilizando o foreach. Como eu coloco argumento dentro dessa
		 * operação? O foreach pede um consumer, um consumer é uma interface funcional -
		 * método que a gente utiliza é o accept e ele não retorna nada, ele pega cada
		 * elemento dessa stream, e vai imprimir. Pode transformar em lambda, ele pede
		 * pra transformar em method reference.
		 */
//        System.out.println("Imprima todos os elementos dessa lista de String: ");
//        numerosAleatorios.stream()
//                 .forEach(System.out::println);
//        numerosAleatorios.forEach(System.out::println);

		/*
		 * Para pegar os cinco primeiros números utiliza o limit - recebe um long que
		 * vai ser o número de elementos que eu quero pegar. Colocando dentro de um set
		 * pela operação collect - pegue algo de algum lugar e collect/coloque em outro
		 * lugar (pegue os 5 primeiros elementos dessa minha stream e colete colocando
		 * dentro de um set). Existes várias sobrecargas, um é passando uma collection
		 * com o método toSet. Imprimindo no foreach passando um reference method. Posso
		 * colocar dentro de uma variável Set.
		 */
//        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set:");
//        numerosAleatorios.stream()
//                .limit(5)
//                .collect(Collectors.toSet())
//                .forEach(System.out::println);
//        Set<String> numerosAleatorios5Primeiros = numerosAleatorios.stream()
//                .limit(5)
//                .collect(Collectors.toSet());
//        System.out.println(numerosAleatorios5Primeiros);

		/*
		 * O map recebe uma interface function e retorna uma stream, no caso um fluxo
		 * que dentro desse fluxo os elementos vão ser do tipo que é informado. Vai
		 * pegar e colocar dentro de um List.
		 */
//        System.out.println("Transforme esta lista de String em uma lista de números inteiros.");
//        List<Integer> numerosAleatorios1 = numerosAleatorios.stream()
//                .map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream().map(Integer::parseInt)
				.collect(Collectors.toList());

		// .forEach(System.out::println);

		/*
		 * O mapa pega cada valor e transforma em um tipo, para fazer uma seleção
		 * pegando os pares e maiores que 2 usamos o filter. Vou colocar em uma lista.
		 */
//        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista:");
//        numerosAleatorios.stream()
//                .map(Integer::parseInt)
//                .filter(i -> i % 2 == 0 && i > 2)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
//        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
//                .map(Integer::parseInt)
//                .filter(i -> (i % 2 == 0 && i > 2))
//                .collect(Collectors.toList());
//        System.out.println(listParesMaioresQue2);

		/*
		 * Average - retorna a média. Como ele retorna um optional, tenho utilizar uma
		 * método do optional - serve para trabalhar com null, ele evita dar retorno
		 * null. O método ifPresent recebe um consumer e retorna um void.
		 */
//        System.out.println("Mostre a média dos números: ");
//        numerosAleatorios1.stream()
//                .average()
//                .ifPresent(System.out::println);
//        numerosAleatorios.stream()
//                .mapToInt(Integer::parseInt)
//                .average()
//                .ifPresent(System.out::println);

		/*
		 * Para remover não pode trabalhar com lista de string, tenho que trabalhar com
		 * lista de integer.
		 */
//        System.out.println("Remova os valores ímpares: ");
//        numerosAleatorios1.removeIf(integer -> integer % 2 != 0);
//        System.out.println(numerosAleatorios1);
//        numerosAleatoriosInteger.removeIf(i -> (i % 2 != 0));
//        System.out.println(numerosAleatoriosInteger);

//        Para você
		System.out.println("---\tIgnore os 3 primeiros elementos da lista e imprima o restante:\t---");
		numerosAleatoriosInteger.stream().skip(3).forEach(System.out::println);

		long countNumerosUnicos = numerosAleatoriosInteger.stream().distinct().count();
		System.out.println(
				"---\tRetirando os números repetidos da lista, quantos números ficam? " + countNumerosUnicos + "\t---");

		System.out.print("---\tMostre o menor valor da lista: ");
		numerosAleatoriosInteger.stream().mapToInt(Integer::intValue).min().ifPresent(System.out::println);

		System.out.print("---\tMostre o maior valor da lista: ");
		numerosAleatoriosInteger.stream().mapToInt(Integer::intValue).max().ifPresent(System.out::println);
		;

		int somaDosNumerosPares = numerosAleatoriosInteger.stream().filter(i -> (i % 2 == 0))
				.mapToInt(Integer::intValue).sum();
		System.out.println("---\tPegue apenas os números pares e some: " + somaDosNumerosPares + "\t---");

		System.out.println("---\tMostre a lista na ordem númerica: ---\t");
		List<Integer> numerosOrdemNatural = numerosAleatoriosInteger.stream().sorted(Comparator.naturalOrder())
				.collect(Collectors.toList());
		System.out.println(numerosOrdemNatural);

		System.out.println("---\tAgrupe os valores ímpares múltiplos de 3 ou de 5:---\t");
//        dica: collect(Collectors.groupingBy(new Function())
		Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = numerosAleatoriosInteger.stream()
				.collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
		System.out.println(collectNumerosMultiplosDe3E5);
	}
}