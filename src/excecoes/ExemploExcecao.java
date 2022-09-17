package excecoes;

import java.text.NumberFormat;
import java.text.ParseException;

public class ExemploExcecao {

	public static void main(String[] args) {
		/*
		 * Se eu for avaliar esse c�digo valueOf da classe wrapper Double, (segura o Crl
		 * e clica no m�todo), podemos observar que ele tem a finalidade de pegar uma
		 * String e converter para um Double, e ele dispara(throws) um
		 * NumberFormatException, por que essa exce��o n�o teve que ser tratada pelo try
		 * / catch, j� que ele dispara essa exce��o? Clicando na classe
		 * NumberFormatException, ela extends de IllegalArgumentException e essa
		 * IllegalArgumentException extends de RuntimeException, ent�o basicamente o que
		 * � essa classe RuntimeException? � uma classe que determina: essa exce��o que
		 * pode acontecer ela � algo que n�s desenvolvedores n�o nos preocupamos em
		 * pedir pra voc� tratar. N�o � algo obrigat�rio de voc�s tratarem. O erro vai
		 * acontecer, mas a gente n�o consegue validar sem antes ele acontecer alguma
		 * vez.
		 */
		Number valor = Double.valueOf("a1.75");

		System.out.println(valor);

		/*
		 * A instru��o fica em vermelho e sugere tratar a poss�vel exce��o ao tentar
		 * realizar a convers�o de uma String para um n�mero. Ent�o no try / catch, ele
		 * diz: tenta converter esta string para um valor, se n�o der certo, trata
		 * jogando essa exce��o "e.printStackTrace()". A ParseException extends da
		 * Exception, ent�o basicamente a proposta de Exce��es Checadas e N�o Checadas �
		 * o fato de ao tentar utilizar o m�todo, esse m�todo determina se precisa
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
