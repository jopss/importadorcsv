package br.com.jopss.exemploimportacaocsv.util;

import br.com.jopss.exemploimportacaocsv.exceptions.ImportacaoException;
import java.io.InputStream;

/**
 * Interface superior dos gerenciadores de importacoes.
 */
public interface ImportacaoManager {
        public RetornoImportacao converter(InputStream in, Class<? extends ImportacaoForm> clazzForm) throws ImportacaoException;
}
