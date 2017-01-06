package br.com.jopss.exemploimportacaocsv.gerenciador;

import br.com.jopss.exemploimportacaocsv.util.anotacoes.Coluna;
import br.com.jopss.exemploimportacaocsv.exceptions.ImportacaoException;
import br.com.jopss.exemploimportacaocsv.util.IOUtils;
import br.com.jopss.exemploimportacaocsv.util.RetornoImportacao;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import br.com.jopss.exemploimportacaocsv.util.ImportacaoForm;
import br.com.jopss.exemploimportacaocsv.util.ImportacaoManager;

/**
 * Classe de regras de importacao especificas de CSV.
 */
public class ImportacaoCSVManager implements ImportacaoManager {

        private static final String CHARSET = "UTF-8";
        private static final String SEPARADOR = ",";
        private static final String QUEBRA_LINHA = "\n";

        /**
         * Converte o arquivo do upload em linhas de dados.
         *
         * @param in InputStream com o arquivo.
         * @param clazzForm classe form que contem o mapeamento dos dados das
         * colunas do CSV.
         * @return RetornoImportacaoCSV
         * @throws ImportacaoException
         */
        @Override
        public RetornoImportacao converter(InputStream in, Class<? extends ImportacaoForm> clazzForm) throws ImportacaoException {
                try {
                        if (in != null) {
                                String linhas = IOUtils.toString(in, CHARSET);
                                return this.parseLinhas(linhas, clazzForm);

                        } else {
                                throw new ImportacaoException("Arquivo de importacao invalido");
                        }
                } catch (IOException | InstantiationException | IllegalAccessException ex) {
                        throw new ImportacaoException(ex);
                }
        }

        private RetornoImportacao parseLinhas(String slinhas, Class<? extends ImportacaoForm> clazzForm) throws InstantiationException, IllegalAccessException {
                if (slinhas == null || slinhas.isEmpty()) {
                        throw new ImportacaoException("Arquivo vazio.");
                }

                String[] linhas = slinhas.split(QUEBRA_LINHA);
                if (linhas == null || linhas.length <= 0) {
                        throw new ImportacaoException("O separador de linhas deve ser '\n'.");
                }

                int count = 0;
                StringBuilder msg = new StringBuilder();
                List<String> nomesCabecalhos = new ArrayList<>();
                List<ImportacaoForm> dados = new ArrayList<>();

                for (String linha : linhas) {
                        count++;

                        String[] colunas = linha.split(SEPARADOR);
                        if (colunas == null || colunas.length <= 0) {
                                throw new ImportacaoException("O separador de colunas deve ser ponto e virgula.");
                        }

                        int idxCol = 0;
                        ImportacaoForm form = (ImportacaoForm) clazzForm.newInstance();
                        for (String coluna : colunas) {
                                if (count == 1) {
                                        nomesCabecalhos.add(coluna);
                                } else {
                                        String nomeColuna = nomesCabecalhos.get(idxCol);
                                        Field atributoForm = form.buscarCampoPeloMapeamento(nomeColuna);
                                        atributoForm.set(form, coluna);
                                        idxCol++;
                                }
                        }
                        if (count != 1) {
                                dados.add(form);
//                        System.out.println("linhas "+count+": "+ form);
                        }
                }

                msg.append(count);
                msg.append(" linhas executadas com sucesso.");
                return new RetornoImportacao(msg.toString(), dados);
        }
}
