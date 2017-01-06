package br.com.jopss.exemploimportacaocsv;

import br.com.jopss.exemploimportacaocsv.controlador.ImportacaoCSVControlador;
import br.com.jopss.exemploimportacaocsv.exceptions.CampoImportacaoInexistenteException;
import java.util.List;
import java.util.Scanner;

public class Executor {
        
        public static void main(String[] argumentos){
                System.out.println("-----------------------------------------");
                System.out.println(" INICIANDO APP DE IMPORTACAO DE ARQUIVOS ");
                System.out.println("-----------------------------------------");
                 
                System.out.println(" LOG: Importando arquivo CSV automaticamente.");
                ImportacaoCSVControlador control = new ImportacaoCSVControlador();
                control.iniciarImportacaoArquivo("cidades.csv");
                System.out.println(" LOG: "+control.getMensagens());
                System.out.println("");
                
                System.out.println(" Opcoes possiveis: ");
                System.out.println("   count * -> contagem total de registros importados sem o cabecalho.");
                System.out.println("   count distinct [propriedade] -> total de valores distintos da propriedade (coluna).");
                System.out.println("   filter [propriedade] [valor] -> mostra o cabeçalho e todas as linhas em que a propriedade possua o valor informado.");
                System.out.println("   sair -> encerra a app.");
                System.out.println("-----------------------------------------");
                System.out.println("");
                
                System.out.println("O que deseja fazer?");                
                Scanner s = new Scanner(System.in);
                String linha;
                while(s.hasNext()){
                        linha = s.nextLine();
                        System.out.println("");
                        
                        try{
                                if(linha.equalsIgnoreCase("count *")){
                                        System.out.println(">> Contando as linhas (menos o cabecalho)... <<");
                                        System.out.println("Importado "+control.calcularTotalLinhas()+" linhas.");

                                }else if(linha.toLowerCase().contains("count distinct")){
                                        System.out.println(">> Contando as linhas com dados distintos de uma coluna... <<");
                                        String campo = linha.toLowerCase().substring(14).trim();
                                        System.out.println("Ha "+control.totalizarColunaDistinct(campo)+" linhas com dados diferentes na coluna "+campo+".");

                                }else if(linha.toLowerCase().contains("filter")){
                                        System.out.println(">> Exibindo as colunas que possui o dado especificado... <<");
                                        String comando = linha.toLowerCase().substring(6).trim();
                                        String campo = comando.substring(0, comando.indexOf(" ")).trim();
                                        String valor = comando.substring(campo.length()+1).trim();
                                        List<String> linhas = control.filtrarPorColunaEValor(campo, valor);
                                        
                                        System.out.println(linhas.size()+" linhas onde a coluna '"+campo+"' possui o valor '"+valor+"'");
                                        System.out.println("");
                                        linhas.stream().forEach((filtro) ->  System.out.println(filtro));
                                        
                                }else if(linha.equalsIgnoreCase("sair")){
                                        System.out.println(">> Saindo...");
                                        break;
                                } else {
                                        System.out.println(">> Comando invalido. Verifique as opcoes possiveis. <<");
                                }
                        }catch(CampoImportacaoInexistenteException e){
                                System.out.println(">> "+e.getMessage()+" <<");
                        }
                        
                        System.out.println("");
                        System.out.println("-----------------------------------------");
                        System.out.println("O que deseja fazer agora?");
                }
                
                System.out.println("-----------------------------------------");
                System.out.println(" FIM DA APP :) ");
                System.out.println("-----------------------------------------");
        }
        
}
