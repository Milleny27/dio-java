package collections;

/*Dadas as seguintes informa��es sobre meus gatos, crie uma lista
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
		 * Como estamos trabalhando com List, os elementos s�o armazenados de acordo com
		 * a ordem de inser��o.
		 */
		System.out.println("--\tOrdem de Inser��o\t---");
		System.out.println(meusGatos);
		System.out.println();

		/*
		 * Como eu posso bagun�ar um List? Dentro da Lista n�o existe nada, mas podemos
		 * utilizar a classe Collections e o m�todo shuffle - passamos a lista
		 */
		System.out.println("--\tOrdem aleat�ria\t---");
		Collections.shuffle(meusGatos);
		System.out.println(meusGatos);
		System.out.println();

		/*
		 * Para conseguir organizar com a ordem natural, eu preciso implementar a
		 * interface comparable, ele vai me obrigar a sobrescrever o m�todo compareTo.
		 * Preciso utilizar um m�todo que organize pela ordem natural, que � o m�todo
		 * sort que recebe uma List, e essa List pra ser organizada tem que ter o m�todo
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
	 * Como sobrescrevi o comparable, pra fazer novas compara��es eu tenho que
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
		 * Esse m�todo retorna um int e esse int que vai ser organizado na ordem. Como
		 * quero comparar nome, que � uma String, a pr�pria string tem um m�todo que �
		 * chamado compareToIgnoreCase que faz a compara��o e me retorna um int. Quando
		 * ela retorna 0 � porque os nomes s�o iguais, se der 1 � porque o gato que eu
		 * estou comparando tem que ficar depois, � maior do que o gato comparado, se o
		 * resultado for -1 � porque o gato que estou comparando � menor que o gato
		 * comparado.
		 */
		return this.getNome().compareToIgnoreCase(gato.getNome());
	}
}

class ComparatorIdade implements Comparator<Gato> {
	/*
	 * O pr�prio integer, assim no o String, tem o m�todo para fazer essa
	 * compara��o. O m�todo � o compare, ele recebe dois inteiros e vai retornar um
	 * int. Esse int vai ser ou 0, ou 1 ou -1 que vai fazer essas compara��es e
	 * ordenar a lista.
	 */
	@Override
	public int compare(Gato g1, Gato g2) {
		return Integer.compare(g1.getIdade(), g2.getIdade());
	}
}

class ComparatorCor implements Comparator<Gato> {
	/*
	 * Comparando as cores dos gatos, que s�o strings, se as cores forem iguais vai
	 * retornar 0, se o gato 1 for maior que o gato 2 vai retornar um n�mero
	 * positivo, se o gato 1 for menor que o gato 2 vai retornar um n�mero negativo.
	 * de acordo com esses n�meros � que vai sendo organizados.
	 */
	@Override
	public int compare(Gato g1, Gato g2) {
		return g1.getCor().compareToIgnoreCase(g2.getCor());
	}
}

class ComparatorNomeCorIdade implements Comparator<Gato> {
	/*
	 * Primeiro eu quero ordenar por nome, se eles forem iguais o crit�rio de
	 * desempate � comparar pelas cores, se as cores forem iguais, o desempate �
	 * pela idade, se os tr�s forem iguais, n�o precisa ordenar porque eles s�o
	 * iguais.
	 */
	@Override
	public int compare(Gato g1, Gato g2) {
		int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
		/*
		 * se o nome for diferente de 0 - se o retorno for 1 ou -1, eu quero que ordene
		 * por nome, porque os nomes s�o diferentes.
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
