package br.com.jopss.exemploimportacaocsv.exceptions;

public class ImportacaoException extends RuntimeException {

	public ImportacaoException(String msg) {
		super(msg);
	}

        public ImportacaoException(Throwable cause) {
                super(cause);
        }

}
