# Dashboard para monitoramento de frota de ônibus urbanos

Tudo o que precisa está aqui(tem coisa até demais).

## Disclaimer
- Não sei fazer design com JavaFX, então para uma experiência interessante utilize a resolução 1366x768 =/ ;

## Como fazer o build
Para fazer o build é necessário ter incluso no projeto a [JSON-java(20180130)](https://github.com/stleary/JSON-java), o ".jar" desta versão já está no diretório "/dashtransporte".

  ### Terminal
  1. Acesse o diretório "/dashtransporte";

  2. Compile usando o javac :
  ```
  $ javac -cp "./json-20180130.jar" DataModel.java FeederModel.java GraficosController.java 
  TabelaController.java GMapsController.java DashTransporte.java
  ```

  3. Execute, informando o nome da classe **DashTransporte**:
  ```
  java -cp "./json-20180130.jar": DashTransporte
  ```
