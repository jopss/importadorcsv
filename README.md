# importadorcsv
App que importa dados de CSV. O arquivo de exemplo esta na raiz "resources", que são dados sobre cidades.

A premissa é criar um exemplo de importador que não use libs externas.
Foi criado uma anotação para facilitar o mapeamento do CSV para o objeto.

Pre requisito rodar com Java 8.

# executando no terminal
na raiz do projeto:

+ mvn clean install
+ cd target
+ java -jar importadorcsv-1.0.jar
