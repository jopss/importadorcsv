package br.com.jopss.exemploimportacaocsv.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe padrao de retorno do gerenciador de importacao.
 */
public class RetornoImportacao {
	private String mensagens;
	private final List dados;

        public RetornoImportacao() {
                this.dados = new ArrayList();
        }

	public RetornoImportacao(String mensagens, List<ImportacaoForm> dados) {
		this.mensagens = mensagens;
		this.dados = dados;
	}

	public String getMensagens() {
		return mensagens;
	}

	public List getDados() {
		return dados;
	}

}
