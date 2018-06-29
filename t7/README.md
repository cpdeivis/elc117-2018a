# t7: Dashboard para monitoramento de frota de ônibus urbanos

O programa é um dashboard para visualização de dados sobre a [frota de ônibus da cidade do Rio de Janeiro](https://pcrj.maps.arcgis.com/home/item.html?id=c47f8bb36e2e4760a761111ac58f5ec0).

![Printscreen Dashboard](https://github.com/oscaruno/elc117-2018a/blob/master/t7/print.png "Printscreen Dashboard")

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
