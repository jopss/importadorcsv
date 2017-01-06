package br.com.jopss.exemploimportacaocsv.exceptions;

public class CampoImportacaoInexistenteException extends ImportacaoException {

	public CampoImportacaoInexistenteException(String msg) {
		super(msg);
	}

        public CampoImportacaoInexistenteException(Throwable cause) {
                super(cause);
        }

}
