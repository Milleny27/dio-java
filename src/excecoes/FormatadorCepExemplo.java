package excecoes;

public class FormatadorCepExemplo {

	public static void main(String[] args) {
		try {
			String cepFormatado = formatarCep("2376064");
			System.out.println(cepFormatado);
		} catch (CepInvalidoException e) {
			System.out.println("O cep n�o corresponde com as regras de neg�cio");
		}

	}
	
	static String formatarCep(String cep) throws CepInvalidoException {
		if (cep.length() != 8) {
			throw new CepInvalidoException();
		}
		// simulando um cep formatado
		return "23.765-064";
	}

}
