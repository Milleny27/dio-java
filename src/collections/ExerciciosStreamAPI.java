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
		 * opera��o? O foreach pede um consumer, um consumer � uma interface funcional -
		 * m�todo que a gente utiliza � o accept e ele n�o retorna nada, ele pega cada
		 * elemento dessa stream, e vai imprimir. Pode transformar em lambda, ele pede
		 * pra transformar em method reference.
		 */
//        System.out.println("Imprima todos os elementos dessa lista de String: ");
//        numerosAleatorios.stream()
//                 .forEach(System.out::println);
//        numerosAleatorios.forEach(System.out::println);

		/*
		 * Para pegar os cinco primeiros n�meros utiliza o limit - recebe um long que
		 * vai ser o n�mero de elementos que eu quero pegar. Colocando dentro de um set
		 * pela opera��o collect - pegue algo de algum lugar e collect/coloque em outro
		 * lugar (pegue os 5 primeiros elementos dessa minha stream e colete colocando
		 * dentro de um set). Existes v�rias sobrecargas, um � passando uma collection
		 * com o m�todo toSet. Imprimindo no foreach passando um reference method. Posso
		 * colocar dentro de uma vari�vel Set.
		 */
//        System.out.println("Pegue os 5 primeiros n�meros e coloque dentro de um Set:");
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
		 * que dentro desse fluxo os elementos v�o ser do tipo que � informado. Vai
		 * pegar e colocar dentro de um List.
		 */
//        System.out.println("Transforme esta lista de String em uma lista de n�meros inteiros.");
//        List<Integer> numerosAleatorios1 = numerosAleatorios.stream()
//                .map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream().map(Integer::parseInt)
				.collect(Collectors.toList());

		// .forEach(System.out::println);

		/*
		 * O mapa pega cada valor e transforma em um tipo, para fazer uma sele��o
		 * pegando os pares e maiores que 2 usamos o filter. Vou colocar em uma lista.
		 */
//        System.out.println("Pegue os n�meros pares e maiores que 2 e coloque em uma lista:");
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
		 * Average - retorna a m�dia. Como ele retorna um optional, tenho utilizar uma
		 * m�todo do optional - serve para trabalhar com null, ele evita dar retorno
		 * null. O m�todo ifPresent recebe um consumer e retorna um void.
		 */
//        System.out.println("Mostre a m�dia dos n�meros: ");
//        numerosAleatorios1.stream()
//                .average()
//                .ifPresent(System.out::println);
//        numerosAleatorios.stream()
//                .mapToInt(Integer::parseInt)
//                .average()
//                .ifPresent(System.out::println);

		/*
		 * Para remover n�o pode trabalhar com lista de string, tenho que trabalhar com
		 * lista de integer.
		 */
//        System.out.println("Remova os valores �mpares: ");
//        numerosAleatorios1.removeIf(integer -> integer % 2 != 0);
//        System.out.println(numerosAleatorios1);
//        numerosAleatoriosInteger.removeIf(i -> (i % 2 != 0));
//        System.out.println(numerosAleatoriosInteger);

//        Para voc�
		System.out.println("---\tIgnore os 3 primeiros elementos da lista e imprima o restante:\t---");
		numerosAleatoriosInteger.stream().skip(3).forEach(System.out::println);

		long countNumerosUnicos = numerosAleatoriosInteger.stream().distinct().count();
		System.out.println(
				"---\tRetirando os n�meros repetidos da lista, quantos n�meros ficam? " + countNumerosUnicos + "\t---");

		System.out.print("---\tMostre o menor valor da lista: ");
		numerosAleatoriosInteger.stream().mapToInt(Integer::intValue).min().ifPresent(System.out::println);

		System.out.print("---\tMostre o maior valor da lista: ");
		numerosAleatoriosInteger.stream().mapToInt(Integer::intValue).max().ifPresent(System.out::println);
		;

		int somaDosNumerosPares = numerosAleatoriosInteger.stream().filter(i -> (i % 2 == 0))
				.mapToInt(Integer::intValue).sum();
		System.out.println("---\tPegue apenas os n�meros pares e some: " + somaDosNumerosPares + "\t---");

		System.out.println("---\tMostre a lista na ordem n�merica: ---\t");
		List<Integer> numerosOrdemNatural = numerosAleatoriosInteger.stream().sorted(Comparator.naturalOrder())
				.collect(Collectors.toList());
		System.out.println(numerosOrdemNatural);

		System.out.println("---\tAgrupe os valores �mpares m�ltiplos de 3 ou de 5:---\t");
//        dica: collect(Collectors.groupingBy(new Function())
		Map<Boolean, List<Integer>> collectNumerosMultiplosDe3E5 = numerosAleatoriosInteger.stream()
				.collect(Collectors.groupingBy(i -> (i % 3 == 0 || i % 5 == 0)));
		System.out.println(collectNumerosMultiplosDe3E5);
	}
}