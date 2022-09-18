package collections;

import java.util.*;

public class ExemploMap {
	public static void main(String[] args) {
		/*
		 * Dada os modelos dos carros e seus respectivos consumos na estrada, faça:
		 * modelo = gol - consumo = 14,4km/l modelo = uno - consumo = 15,6 km/l modelo =
		 * mobi - consumo = 16,1 km/l modelo = hb20 - consumo = 14,5 km/l modelo = kwid
		 * - consumo = 15,6 km/l
		 */

//        Map carrosPopulares2020 = new HashMap(); //antes do java 5
//        Map<String, Double> carrosPopulares = new HashMap<>(); //Generics(jdk 5) - Diamont Operator(jdk 7)
//        HashMap<String, Double> carrosPopulares = new HashMap<>();
//        Map<String, Double> carrosPopulares2020 = Map.of("gol", 14.4, "uno", 15.6, "mobi", 16.1, "hb20", 14.5, "kwid", 15.6)

		/*
		 * Criando um map, tem que informar o tipo da chave e o tipo do valor. Para
		 * adicionar precisamos usar o método put. A chave não pode ser repetida. Não
		 * garante ordem de inserção.
		 */
		System.out.println("---\tCrie um dicionário que relacione os modelos e seus respectivos consumos: \t---");
		Map<String, Double> carrosPopulares = new HashMap<>() {
			{
				put("gol", 14.4);
				put("uno", 15.6);
				put("mobi", 16.1);
				put("hb20", 14.5);
				put("kwid", 15.6);
			}
		};
		System.out.println(carrosPopulares.toString());
		System.out.println();

		/*
		 * Como não pode chave repetida, usamos o método put. Se já tem aquela chave,
		 * ele só vai sobrescrever o valor. Não tem como adicionar, tem como alterar,
		 * pois a chave já existe.
		 */
		System.out.println("---\tSubstitua o consumo do gol por 15,2 km/l: \t---");
		carrosPopulares.put("gol", 15.2);
		System.out.println(carrosPopulares);
		System.out.println();

		/*
		 * tucson é o modelo, o modelo é a chave, então usamos o método containsKey
		 * passando o objeto.
		 */
		System.out.println("---\tConfira se o modelo tucson está no dicionário: "
				+ carrosPopulares.containsKey("tucson") + "\t---");
		System.out.println();

		/*
		 * Para passar uma chave e obter um valor da chave usamos o get passando o
		 * objeto.
		 */
		System.out.println("---\tExiba o consumo do uno: " + carrosPopulares.get("uno") + "\t---");
		System.out.println();

		/* Como no set, não tem um método. */
//        System.out.println("Exiba o terceiro modelo adicionado: ");

		/* O método keySet retorna um set. */
		System.out.println("---\tExiba os modelos: \t---");
		Set<String> modelos = carrosPopulares.keySet();
		System.out.println(modelos);
		System.out.println();

		/* values retorna uma collection */
		System.out.println("---\tExiba os consumos dos carros: \t---");
		Collection<Double> consumos = carrosPopulares.values();
		System.out.println(consumos);
		System.out.println();

		/*
		 * Precisamos saber qual é o valor da chave que é mais eficiente - que faz mais
		 * km por litro. Precisamos retornar o maior valor - max, passando uma
		 * collection. Como trabalhar com chave e valor separadamente? Com o método
		 * entrySet - retorna um set, e os elementos desse set é do tipo entry.
		 */
		System.out.println("---\tExiba o modelo mais econômico e seu consumo: \t---");

		Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
		Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
		String modeloMaisEficiente = ""; // variável de controle
		/*
		 * Por mais que tenha chave e valor, estou trabalhando com Set. Se o meu entry,
		 * o valor dele, for igual ao consumoMaisEficiente. O modeloMaisEficiente é
		 * igual a chave referente a esse entry.
		 */
		for (Map.Entry<String, Double> entry : entries) {
			if (entry.getValue().equals(consumoMaisEficiente)) {
				modeloMaisEficiente = entry.getKey();
				System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
			}
		}
		System.out.println();

		System.out.println("---\tExiba o modelo menos econômico e seu consumo: \t---");

		Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
		String modeloMenosEficiente = "";
		for (Map.Entry<String, Double> entry : carrosPopulares.entrySet()) {
			if (entry.getValue().equals(consumoMenosEficiente)) {
				modeloMenosEficiente = entry.getKey();
				System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
			}
		}
		System.out.println();

		/*
		 * Consigo utilizar o iterator porque o retorno desse carrosPopulares é um
		 * collection. Criar uma variável soma pra guardar a soma e vamos iterar. O
		 * iterator tem próximo, eu vou somar com iterator.next e vou exibir a soma.
		 */
		Iterator<Double> iterator = carrosPopulares.values().iterator();
		Double soma = 0d;
		while (iterator.hasNext()) {
			soma += iterator.next();
		}
		System.out.println("---\tExiba a soma dos consumos: " + soma + "\t---");
		System.out.println();

		/* Soma dividido pela quantidade que é dada pelo size */
		System.out.println("---\tExiba a média dos consumos deste dicionário de carros: "
				+ (soma / carrosPopulares.size()) + "\t---");
		System.out.println();

		/*
		 * Outro iterator. Se o próximo elemento do iterator for igual ao valor 15.6, eu
		 * vou remover
		 */
		System.out.println(carrosPopulares);
		System.out.println("---\tRemova os modelos com o consumo igual a 15,6 km/l: \t---");
		Iterator<Double> iterator1 = carrosPopulares.values().iterator();
		while (iterator1.hasNext()) {
			if (iterator1.next().equals(15.6))
				iterator1.remove();
		}
		System.out.println(carrosPopulares);
		System.out.println();

		/* Pra exibir na ordem de inserção, usamos o LinkedHashMap. */
		System.out.println("---\tExiba todos os carros na ordem em que foram informados: \t---");
		Map<String, Double> carrosPopulares1 = new LinkedHashMap<>() {
			{
				put("gol", 14.4);
				put("uno", 15.6);
				put("mobi", 16.1);
				put("hb20", 14.5);
				put("kwid", 15.6);
			}
		};
		System.out.println(carrosPopulares1.toString());
		System.out.println();

		/*
		 * O modelo é a chave e quem ordena a chave é o TreeMap. A chave é string, então
		 * vai ordenar por ordem alfabética.
		 */
		System.out.println("---\tExiba o dicionário ordenado pelo modelo: \t---");
		Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
		System.out.println(carrosPopulares2.toString());
		System.out.println();

		System.out.println("---\tApague o dicionario de carros: \t---");
		carrosPopulares.clear();
		System.out.println();

		System.out.println("---\tConfira se o dicionário está vazio: " + carrosPopulares.isEmpty() + "\t---");
		System.out.println();
	}
}
