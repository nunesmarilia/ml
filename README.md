## ML

Projeto do teste de analise do DNA

## REST API

http://x:9001/ml/swagger-ui.html

## Validação DNA

http://x:9001/ml/simian 

http://x:9001/ml/stats

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