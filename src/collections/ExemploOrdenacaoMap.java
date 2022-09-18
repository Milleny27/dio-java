package collections;

/*Dadas as seguintes informa��es sobre meus livros favoritos e seus autores,
crie um dicion�rio e ordene este dicion�rio:
exibindo (Nome Autor - Nome Livro);
Autor = Hawking, Stephen  - Livro = nome: Uma Breve Hist�ria do Tempo. p�ginas: 256
Autor = Duhigg, Charles - Livro = nome: O Poder do H�bito, paginas: 408
Autor = Harari, Yuval Noah  - Livro = 21 Li��es Para o S�culo 21, p�ginas: 432
*/

import java.util.*;
import java.util.Map.Entry;

public class ExemploOrdenacaoMap {
	public static void main(String[] args) {

		/*
		 * Ordem aleat�ria - HashMap. Para trabalhar com elementos separadamente -
		 * entrySet. FAzemos um for para imprimir a minha chave e no valor s� o nome.
		 */
		System.out.println("--\tOrdem aleat�ria\t--");
		Map<String, Livro> meusLivros = new HashMap<>() {
			{
				put(" Hawking, Stephen", new Livro("Uma Breve Hist�ria do Tempo", 256));
				put(" Duhigg, Charles", new Livro("O Poder do H�bito", 408));
				put(" Harari, Yuval Noah", new Livro("21 Li��es Para o S�culo 21", 432));
			}
		};
		for (Map.Entry<String, Livro> livro : meusLivros.entrySet())
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
		System.out.println();

		/* Ordem de inser��o - LinkedHashMap */
		System.out.println("--\tOrdem Inser��o\t--");
		Map<String, Livro> meusLivros1 = new LinkedHashMap<>() {
			{
				put(" Hawking, Stephen", new Livro("Uma Breve Hist�ria do Tempo", 256));
				put(" Duhigg, Charles", new Livro("O Poder do H�bito", 408));
				put(" Harari, Yuval Noah", new Livro("21 Li��es Para o S�culo 21", 432));
			}
		};
		for (Map.Entry<String, Livro> livro : meusLivros1.entrySet())
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
		System.out.println();

		System.out.println("--\tOrdem alfab�tica autores\t--");
		Map<String, Livro> meusLivros2 = new TreeMap<>(meusLivros1);
		for (Map.Entry<String, Livro> livro : meusLivros2.entrySet())
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
		System.out.println();

		/*
		 * Os nomes do livro est� no valor, ent�o trabalhamos com o TreeSet, porque eu
		 * preciso passar o camparator.
		 */
		System.out.println("--\tOrdem alfab�tica nomes dos livros\t--");

		Set<Map.Entry<String, Livro>> meusLivros3 = new TreeSet<>(new ComparatorNome());
		meusLivros3.addAll(meusLivros.entrySet());
		for (Map.Entry<String, Livro> livro : meusLivros3)
			System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
		System.out.println();

//        System.out.println("--\tOrdem n�mero de p�gina\t--"); //Pra voc�

		System.out.println("--\tOrdem n�mero de p�gina\t--");
		Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorPaginas());
		meusLivros4.addAll(meusLivros.entrySet());
		for (Map.Entry<String, Livro> livro : meusLivros4)
			System.out.println(livro.getKey() + " - " + livro.getValue().getPaginas());

	}
}

class Livro {
	private String nome;
	private Integer paginas;

	public Livro(String nome, Integer paginas) {
		this.nome = nome;
		this.paginas = paginas;
	}

	public String getNome() {
		return nome;
	}

	public Integer getPaginas() {
		return paginas;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Livro livro = (Livro) o;
		return nome.equals(livro.nome) && paginas.equals(livro.paginas);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, paginas);
	}

	@Override
	public String toString() {
		return "Livro{" + "nome='" + nome + '\'' + ", paginas=" + paginas + '}';
	}
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>> {

	@Override
	public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
		return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
	}
}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>> {

	@Override
	public int compare(Entry<String, Livro> l1, Entry<String, Livro> l2) {
		return l1.getValue().getPaginas().compareTo(l1.getValue().getPaginas());
	}

}
