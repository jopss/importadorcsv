package br.com.jopss.exemploimportacaocsv.util;

import br.com.jopss.exemploimportacaocsv.exceptions.CampoImportacaoInexistenteException;
import br.com.jopss.exemploimportacaocsv.exceptions.ImportacaoException;
import br.com.jopss.exemploimportacaocsv.util.anotacoes.Coluna;
import java.lang.reflect.Field;

/**
 * Interface superior dos forms que contem o mapeamento dos dados das colunas de um CSV.
 */
public abstract class ImportacaoForm {
        public Field buscarCampoPeloMapeamento(String mapeamento){
                Field[] fields = this.getClass().getDeclaredFields();
                for (Field atributoForm : fields) {
                        atributoForm.setAccessible(true);
                        Coluna annotation = atributoForm.getAnnotation(Coluna.class);
                        if (annotation != null) {
                                String nomeMapeado = annotation.nome();
                                if (nomeMapeado.equalsIgnoreCase(mapeamento)) {
                                        return atributoForm;
                                }
                        }
                }
                throw new CampoImportacaoInexistenteException("Coluna '"+mapeamento+"' nao existe. Tente outro campo.");
        }
        
        public String getValorCampo(String mapeamento) {
                Field f = this.buscarCampoPeloMapeamento(mapeamento);
                try {
                        return (String) f.get(this);
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                        throw new ImportacaoException(ex);
                }
        }
}
