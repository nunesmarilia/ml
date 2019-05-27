## ML

Projeto do exame ML de analise do DNA

## REST API

http://18.191.94.71:9001/ml/swagger-ui.html

## Validação DNA

http://18.191.94.71:9001/ml/simian 

http://18.191.94.71:9001/ml/stats

* Passar Json 
{
"dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}

## Contabilização DNA

${host}/ml/stats

## Build manual com Testes

`mvn install -Dmaven.test.skip=false`

## Build manual sem Testes

`mvn install -Dmaven.test.skip=true`