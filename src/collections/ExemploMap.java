package collections;

import java.util.*;

public class ExemploMap {
	public static void main(String[] args) {
		/*
		 * Dada os modelos dos carros e seus respectivos consumos na estrada, fa�a:
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
		 * adicionar precisamos usar o m�todo put. A chave n�o pode ser repetida. N�o
		 * garante ordem de inser��o.
		 */
		System.out.println("---\tCrie um dicion�rio que relacione os modelos e seus respectivos consumos: \t---");
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
		 * Como n�o pode chave repetida, usamos o m�todo put. Se j� tem aquela chave,
		 * ele s� vai sobrescrever o valor. N�o tem como adicionar, tem como alterar,
		 * pois a chave j� existe.
		 */
		System.out.println("---\tSubstitua o consumo do gol por 15,2 km/l: \t---");
		carrosPopulares.put("gol", 15.2);
		System.out.println(carrosPopulares);
		System.out.println();

		/*
		 * tucson � o modelo, o modelo � a chave, ent�o usamos o m�todo containsKey
		 * passando o objeto.
		 */
		System.out.println("---\tConfira se o modelo tucson est� no dicion�rio: "
				+ carrosPopulares.containsKey("tucson") + "\t---");
		System.out.println();

		/*
		 * Para passar uma chave e obter um valor da chave usamos o get passando o
		 * objeto.
		 */
		System.out.println("---\tExiba o consumo do uno: " + carrosPopulares.get("uno") + "\t---");
		System.out.println();

		/* Como no set, n�o tem um m�todo. */
//        System.out.println("Exiba o terceiro modelo adicionado: ");

		/* O m�todo keySet retorna um set. */
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
		 * Precisamos saber qual � o valor da chave que � mais eficiente - que faz mais
		 * km por litro. Precisamos retornar o maior valor - max, passando uma
		 * collection. Como trabalhar com chave e valor separadamente? Com o m�todo
		 * entrySet - retorna um set, e os elementos desse set � do tipo entry.
		 */
		System.out.println("---\tExiba o modelo mais econ�mico e seu consumo: \t---");

		Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
		Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
		String modeloMaisEficiente = ""; // vari�vel de controle
		/*
		 * Por mais que tenha chave e valor, estou trabalhando com Set. Se o meu entry,
		 * o valor dele, for igual ao consumoMaisEficiente. O modeloMaisEficiente �
		 * igual a chave referente a esse entry.
		 */
		for (Map.Entry<String, Double> entry : entries) {
			if (entry.getValue().equals(consumoMaisEficiente)) {
				modeloMaisEficiente = entry.getKey();
				System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
			}
		}
		System.out.println();

		System.out.println("---\tExiba o modelo menos econ�mico e seu consumo: \t---");

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
		 * Consigo utilizar o iterator porque o retorno desse carrosPopulares � um
		 * collection. Criar uma vari�vel soma pra guardar a soma e vamos iterar. O
		 * iterator tem pr�ximo, eu vou somar com iterator.next e vou exibir a soma.
		 */
		Iterator<Double> iterator = carrosPopulares.values().iterator();
		Double soma = 0d;
		while (iterator.hasNext()) {
			soma += iterator.next();
		}
		System.out.println("---\tExiba a soma dos consumos: " + soma + "\t---");
		System.out.println();

		/* Soma dividido pela quantidade que � dada pelo size */
		System.out.println("---\tExiba a m�dia dos consumos deste dicion�rio de carros: "
				+ (soma / carrosPopulares.size()) + "\t---");
		System.out.println();

		/*
		 * Outro iterator. Se o pr�ximo elemento do iterator for igual ao valor 15.6, eu
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

		/* Pra exibir na ordem de inser��o, usamos o LinkedHashMap. */
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
		 * O modelo � a chave e quem ordena a chave � o TreeMap. A chave � string, ent�o
		 * vai ordenar por ordem alfab�tica.
		 */
		System.out.println("---\tExiba o dicion�rio ordenado pelo modelo: \t---");
		Map<String, Double> carrosPopulares2 = new TreeMap<>(carrosPopulares1);
		System.out.println(carrosPopulares2.toString());
		System.out.println();

		System.out.println("---\tApague o dicionario de carros: \t---");
		carrosPopulares.clear();
		System.out.println();

		System.out.println("---\tConfira se o dicion�rio est� vazio: " + carrosPopulares.isEmpty() + "\t---");
		System.out.println();
	}
}
