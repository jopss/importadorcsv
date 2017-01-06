package br.com.jopss.exemploimportacaocsv.util.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotacao utilizada para indicar o mapeamento dos nomes das colunas de um CSV para importação.
 */
@Target(value = { ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Coluna {
	public String nome();
}
