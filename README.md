## ML

Projeto do exame ML de analise do DNA

## REST API

${host}/ml/swagger-ui.html

## Validação DNA

${host}/ml/simian

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