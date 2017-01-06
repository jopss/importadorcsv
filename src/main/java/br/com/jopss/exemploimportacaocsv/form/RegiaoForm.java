package br.com.jopss.exemploimportacaocsv.form;

import br.com.jopss.exemploimportacaocsv.util.anotacoes.Coluna;
import br.com.jopss.exemploimportacaocsv.util.ImportacaoForm;

/**
 * Representa as colunas do arquivo a ser importado.
 */
public class RegiaoForm extends ImportacaoForm {

        @Coluna(nome = "ibge_id")
        private String ibge;

        @Coluna(nome = "uf")
        private String uf;

        @Coluna(nome = "name")
        private String nome;

        @Coluna(nome = "capital")
        private String capital;

        @Coluna(nome = "lon")
        private String longitude;

        @Coluna(nome = "lat")
        private String latitude;

        @Coluna(nome = "no_accents")
        private String nomeSemAcento;

        @Coluna(nome = "alternative_names")
        private String nomesAlternativos;

        @Coluna(nome = "microregion")
        private String microrregiao;

        @Coluna(nome = "mesoregion")
        private String mesorregiao;

        public String getIbge() {
                return ibge;
        }

        public String getUf() {
                return uf;
        }

        public String getNome() {
                return nome;
        }

        public String getCapital() {
                return capital;
        }

        public String getLongitude() {
                return longitude;
        }

        public String getLatitude() {
                return latitude;
        }

        public String getNomeSemAcento() {
                return nomeSemAcento;
        }

        public String getNomesAlternativos() {
                return nomesAlternativos;
        }

        public String getMicrorregiao() {
                return microrregiao;
        }

        public String getMesorregiao() {
                return mesorregiao;
        }

        @Override
        public String toString() {
                return "ibge=" + ibge + ", uf=" + uf + ", nome=" + nome + ", capital=" + capital + ", longitude=" + longitude + ", latitude=" + latitude + ", nomeSemAcento=" + nomeSemAcento + ", nomesAlternativos=" + nomesAlternativos + ", microrregiao=" + microrregiao + ", mesorregiao=" + mesorregiao;
        }

}
