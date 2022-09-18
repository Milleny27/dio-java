package collections;

/*Dadas as seguintes informações sobre meus gatos, crie uma lista
e ordene esta lista exibindo:
(nome - idade - cor);
Gato 1 = nome: Jon, idade: 18, cor: preto
Gato 2 = nome: Simba, idade: 6, cor: tigrado
Gato 3 = nome: Jon, idade: 12, cor: amarelo
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
	public static void main(String[] args) {

		/* Criando uma lista do tipo gato */
		List<Gato> meusGatos = new ArrayList<>() {
			{
				add(new Gato("Jon", 12, "preto"));
				add(new Gato("Simba", 6, "tigrado"));
				add(new Gato("Jon", 18, "amarelo"));
			}
		};
		meusGatos.sort(Comparator.comparing(Gato::getNome));

		/*
		 * Como estamos trabalhando com List, os elementos são armazenados de acordo com
		 * a ordem de inserção.
		 */
		System.out.println("--\tOrdem de Inserção\t---");
		System.out.println(meusGatos);
		System.out.println();

		/*
		 * Como eu posso bagunçar um List? Dentro da Lista não existe nada, mas podemos
		 * utilizar a classe Collections e o método shuffle - passamos a lista
		 */
		System.out.println("--\tOrdem aleatória\t---");
		Collections.shuffle(meusGatos);
		System.out.println(meusGatos);
		System.out.println();

		/*
		 * Para conseguir organizar com a ordem natural, eu preciso implementar a
		 * interface comparable, ele vai me obrigar a sobrescrever o método compareTo.
		 * Preciso utilizar um método que organize pela ordem natural, que é o método
		 * sort que recebe uma List, e essa List pra ser organizada tem que ter o método
		 * comparable.
		 */
		System.out.println("--\tOrdem Natural (Nome)\t---");
		Collections.sort(meusGatos);
		System.out.println(meusGatos);
		System.out.println();

		/*
		 * Como a gente vai utilizar o comparator, utilizamos o sort - passando a lista
		 * e o comparator ou podemos chamar o sort na List recebendo o comparator.
		 */
		System.out.println("--\tOrdem Idade\t---");
//        Collections.sort(meusGatos, new ComparatorIdade());
		meusGatos.sort(new ComparatorIdade());
		System.out.println(meusGatos);
		System.out.println();

		/* Da mesma forma que o anterior */
		System.out.println("--\tOrdem cor\t---");
//        Collections.sort(meusGatos, new ComparatorCor());
		meusGatos.sort(new ComparatorCor());
		System.out.println(meusGatos);
		System.out.println();

		/**/
		System.out.println("--\tOrdem Nome/Cor/Idade\t---");
//        Collections.sort(meusGatos, new ComparatorNomeCorIdade());
		meusGatos.sort(new ComparatorNomeCorIdade());
		System.out.println(meusGatos);
	}
}

class Gato implements Comparable<Gato> {
	/*
	 * Como sobrescrevi o comparable, pra fazer novas comparações eu tenho que
	 * utilizar o Comparator.
	 */
	private String nome;
	private Integer idade;
	private String cor;

	public Gato(String nome, Integer idade, String cor) {
		this.nome = nome;
		this.idade = idade;
		this.cor = cor;
	}

	/*
	 * Utilizamos getters e setter para conseguir acessar os atributos privados da
	 * classe
	 */
	public String getNome() {
		return nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public String getCor() {
		return cor;
	}

	@Override
	public String toString() {
		return "{" + "nome='" + nome + '\'' + ", idade=" + idade + ", cor='" + cor + '\'' + '}';
	}

	@Override
	public int compareTo(Gato gato) {
		/*
		 * Esse método retorna um int e esse int que vai ser organizado na ordem. Como
		 * quero comparar nome, que é uma String, a própria string tem um método que é
		 * chamado compareToIgnoreCase que faz a comparação e me retorna um int. Quando
		 * ela retorna 0 é porque os nomes são iguais, se der 1 é porque o gato que eu
		 * estou comparando tem que ficar depois, é maior do que o gato comparado, se o
		 * resultado for -1 é porque o gato que estou comparando é menor que o gato
		 * comparado.
		 */
		return this.getNome().compareToIgnoreCase(gato.getNome());
	}
}

class ComparatorIdade implements Comparator<Gato> {
	/*
	 * O próprio integer, assim no o String, tem o método para fazer essa
	 * comparação. O método é o compare, ele recebe dois inteiros e vai retornar um
	 * int. Esse int vai ser ou 0, ou 1 ou -1 que vai fazer essas comparações e
	 * ordenar a lista.
	 */
	@Override
	public int compare(Gato g1, Gato g2) {
		return Integer.compare(g1.getIdade(), g2.getIdade());
	}
}

class ComparatorCor implements Comparator<Gato> {
	/*
	 * Comparando as cores dos gatos, que são strings, se as cores forem iguais vai
	 * retornar 0, se o gato 1 for maior que o gato 2 vai retornar um número
	 * positivo, se o gato 1 for menor que o gato 2 vai retornar um número negativo.
	 * de acordo com esses números é que vai sendo organizados.
	 */
	@Override
	public int compare(Gato g1, Gato g2) {
		return g1.getCor().compareToIgnoreCase(g2.getCor());
	}
}

class ComparatorNomeCorIdade implements Comparator<Gato> {
	/*
	 * Primeiro eu quero ordenar por nome, se eles forem iguais o critério de
	 * desempate é comparar pelas cores, se as cores forem iguais, o desempate é
	 * pela idade, se os três forem iguais, não precisa ordenar porque eles são
	 * iguais.
	 */
	@Override
	public int compare(Gato g1, Gato g2) {
		int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
		/*
		 * se o nome for diferente de 0 - se o retorno for 1 ou -1, eu quero que ordene
		 * por nome, porque os nomes são diferentes.
		 */
		if (nome != 0)
			return nome;

		int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
		/* Se os nomes forem iguais e as cores diferentes, eu vou ordenar por cor */
		if (cor != 0)
			return cor;

		/* Se os nomes forem iguais, as cores forem iguais, vai ordenar por idade */
		return Integer.compare(g1.getIdade(), g2.getIdade());

	}

}
