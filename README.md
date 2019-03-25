## ml 

Projeto do exame Ml de analise do DNA

## REST API

${host}/cip.ws/swagger-ui.html

## Link do build job no Jenkins

http://192.168.80.40:8080/job/cip.ws/

## Build manual

`mvn clean install -P${ambiente}` onde `${ambiente}` pode ter os valores `dev`, `homolog` ou `prod`
* Se o parâmetro `-P` não for utilizado será assumido o valor `dev` como padrão
* Verifique os valores pré-configurados de conexão ao wsdl da Rede nos arquivos `application.properties`
