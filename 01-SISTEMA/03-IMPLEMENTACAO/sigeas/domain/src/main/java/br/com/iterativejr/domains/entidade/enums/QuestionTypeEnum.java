/**
 * 
 */
package br.com.iterativejr.domains.entidade.enums;

/**
 * <p>
 * <b> Tipos de pergunta </b>
 * </p>
 *
 * <p>
 * Usando quando é necesario colocar o tipo de uma pergunta
 * </p>
 * 
 * @author <a href="https://github.com/JoaquimCMH">Joaquim Maia</a>
 *
 */
public enum QuestionTypeEnum {
	/**
	 * Seleciona varias opcoes
	 */
	 CHECKBOX,
	 /**
	  * Seleciona apenas uma
	  */
	 RADIO,
	 /**
	  * Digitar um texto
	  */
	 TEXT,
	 /**
	  * Apenas um paragrafo
	  */
	 PARAGRAPH,
	 /**
	  * Inserir numeros
	  */
	 SPINNER;
}
