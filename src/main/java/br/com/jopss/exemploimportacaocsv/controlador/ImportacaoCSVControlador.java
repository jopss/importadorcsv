package br.com.jopss.exemploimportacaocsv.controlador;

import br.com.jopss.exemploimportacaocsv.exceptions.ImportacaoException;
import br.com.jopss.exemploimportacaocsv.form.RegiaoForm;
import br.com.jopss.exemploimportacaocsv.gerenciador.ImportacaoCSVManager;
import br.com.jopss.exemploimportacaocsv.util.RetornoImportacao;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ImportacaoCSVControlador {

        private final ImportacaoCSVManager importacaoCSVManager;
        private RetornoImportacao retorno;

        public ImportacaoCSVControlador() {
                this.importacaoCSVManager = new ImportacaoCSVManager();
                this.retorno = new RetornoImportacao();
        }

        public void iniciarImportacaoArquivo(String caminho) {
                InputStream in = Thread.currentThread().getClass().getResourceAsStream("/" + caminho);
                retorno = this.importacaoCSVManager.converter(in, RegiaoForm.class);
        }

        public int totalizarColunaDistinct(String coluna) {
                TreeSet<RegiaoForm> collected = this.getDados().stream()
                        .collect(Collectors.toCollection(
                                () -> new TreeSet<RegiaoForm>((r1, r2) -> r1.getValorCampo(coluna).compareTo(r2.getValorCampo(coluna)))
                        ));

                return collected.size();
        }

        public List<String> filtrarPorColunaEValor(String campo, String valor) {
                return this.getDados().stream().filter((form) -> form.getValorCampo(campo).toLowerCase().contains(valor.toLowerCase())).map(RegiaoForm::toString).collect(Collectors.toList());
        }

        public int calcularTotalLinhas() {
                return this.getDados().size();
        }

        public String getMensagens() {
                return this.retorno.getMensagens();
        }

        private List<RegiaoForm> getDados() {
                return this.retorno.getDados();
        }

}
