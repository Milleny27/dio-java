package collections;

/*Dadas as seguintes informa��es sobre minhas s�ries favoritas,
crie um conjunto e ordene este conjunto exibindo:
(nome - genero - tempo de epis�dio);

S�rie 1 = Nome: got, genero: fantasia, tempoEpisodio: 60
S�rie 2 = nome: dark, genero: drama, tempoEpisodio: 60
S�rie 3 = nome: that '70s show, genero: com�dia, tempoEpisodio: 25
*/
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class ExemploOrdenacaoSet {
	public static void main(String[] args) {

		/* Ordem aleat�ria -> HashSet */
		System.out.println("--\tOrdem aleat�ria\t--");
		Set<Serie> minhasSeries = new HashSet<>() {
			{
				add(new Serie("got", "fantasia", 60));
				add(new Serie("dark", "drama", 60));
				add(new Serie("that '70s show", "com�dia", 25));
			}
		};
		for (Serie serie : minhasSeries)
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
		System.out.println();

		/* Ordem de inser��o -> LinkedHashSet */
		System.out.println("--\tOrdem inser��o\t--");
		Set<Serie> minhasSeries1 = new LinkedHashSet<>() {
			{
				add(new Serie("got", "fantasia", 60));
				add(new Serie("dark", "drama", 60));
				add(new Serie("that '70s show", "com�dia", 25));
			}
		};
		for (Serie serie : minhasSeries1)
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
		System.out.println();

		/*
		 * A ordem natural � pelo tempo de episodio -> TreeSet.. Precisa criar o
		 * comparable
		 */
		System.out.println("--\tOrdem natural (TempoEpisodio)\t--");
		Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
		for (Serie serie : minhasSeries2)
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
		System.out.println();

		System.out.println("--\tOrdem Nome/G�nero/TempoEpisodio\t--");
		Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
		minhasSeries3.addAll(minhasSeries);
		for (Serie serie : minhasSeries3)
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
		System.out.println();

//Pra voc�
		/*
		 * System.out.println("--\tOrdem g�nero\t--");
		 * System.out.println("--\tOrdem Tempo Epis�dio\t--");
		 */
		
		System.out.println("--\tOrdem g�nero\t--");
		Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorGenero());
		minhasSeries4.addAll(minhasSeries);
		for (Serie serie : minhasSeries)
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
		System.out.println();
		
		System.out.println("--\tOrdem Tempo Epis�dio\t--");
		Set<Serie> minhasSeries5 = new TreeSet<>(new ComparatorTempoEpisodio());
		minhasSeries5.addAll(minhasSeries);
		for (Serie serie : minhasSeries)
			System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());

	}
}

class Serie implements Comparable<Serie> {
	private String nome;
	private String genero;
	private Integer tempoEpisodio;

	public Serie(String nome, String genero, Integer tempoEpisodio) {
		this.nome = nome;
		this.genero = genero;
		this.tempoEpisodio = tempoEpisodio;
	}

	public String getNome() {
		return nome;
	}

	public String getGenero() {
		return genero;
	}

	public Integer getTempoEpisodio() {
		return tempoEpisodio;
	}

	@Override
	public String toString() {
		return "{" + "nome='" + nome + '\'' + ", genero='" + genero + '\'' + ", tempoEpisodio=" + tempoEpisodio + '}';
	}

	/*
	 * Quando � importante sobrescrever o equals e hashCode? Quando a gente t�
	 * utilizando implementa��es que no nome tem a palavras "hash".
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Serie serie = (Serie) o;
		return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, genero, tempoEpisodio);
	}

	@Override
	public int compareTo(Serie serie) {
		/*
		 * Comparando por tempo de episodio. Como ele n�o recebe objetos iguais, se
		 * implementar somente a compara��o po tempo de episodio ele n�o exibir uma.
		 * Eu tenho que dar o crit�rio de desempate.
		 */
		int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
		if (tempoEpisodio != 0)
			return tempoEpisodio;

		return this.getGenero().compareTo(serie.getGenero());
	}
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie> {
	
	@Override
	public int compare(Serie s1, Serie s2) {
		int nome = s1.getNome().compareTo(s2.getNome());
		if (nome != 0)
			return nome;

		int genero = s1.getGenero().compareTo(s2.getGenero());
		if (genero != 0)
			return genero;

		return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
	}
}

class ComparatorGenero implements Comparator<Serie> {

	@Override
	public int compare(Serie s1, Serie s2) {
		return s1.getGenero().compareTo(s2.getGenero());
	}
	
}

class ComparatorTempoEpisodio implements Comparator<Serie> {

	@Override
	public int compare(Serie s1, Serie s2) {
		return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
	}
	
}
