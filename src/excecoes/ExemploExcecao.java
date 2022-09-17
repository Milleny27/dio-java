package excecoes;

import java.text.NumberFormat;
import java.text.ParseException;

public class ExemploExcecao {

	public static void main(String[] args) {
		/*
		 * Se eu for avaliar esse código valueOf da classe wrapper Double, (segura o Crl
		 * e clica no método), podemos observar que ele tem a finalidade de pegar uma
		 * String e converter para um Double, e ele dispara(throws) um
		 * NumberFormatException, por que essa exceção não teve que ser tratada pelo try
		 * / catch, já que ele dispara essa exceção? Clicando na classe
		 * NumberFormatException, ela extends de IllegalArgumentException e essa
		 * IllegalArgumentException extends de RuntimeException, então basicamente o que
		 * é essa classe RuntimeException? É uma classe que determina: essa exceção que
		 * pode acontecer ela é algo que nós desenvolvedores não nos preocupamos em
		 * pedir pra você tratar. Não é algo obrigatório de vocês tratarem. O erro vai
		 * acontecer, mas a gente não consegue validar sem antes ele acontecer alguma
		 * vez.
		 */
		Number valor = Double.valueOf("a1.75");

		System.out.println(valor);

		/*
		 * A instrução fica em vermelho e sugere tratar a possível exceção ao tentar
		 * realizar a conversão de uma String para um número. Então no try / catch, ele
		 * diz: tenta converter esta string para um valor, se não der certo, trata
		 * jogando essa exceção "e.printStackTrace()". A ParseException extends da
		 * Exception, então basicamente a proposta de Exceções Checadas e Não Checadas é
		 * o fato de ao tentar utilizar o método, esse método determina se precisa
		 * tratar algum erro imediatamente.
		 */
		try {
			valor = NumberFormat.getInstance().parse("a1.75");
			System.out.println(valor);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
