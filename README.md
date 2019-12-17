# Índice
- [Sobre o projeto](#sobre)
- [Clientes](#clientes)
- [Execução do projeto](#execucao)
- [Tecnologias e versões](#tecnologias)


## Sobre o projeto <a name="sobre"></a>
O projeto é focado em conciliação de `cartões digitais`.


## Clientes <a name="clientes"></a>
```
Super Digital
```


## Execução do projeto <a name="execucao"></a>

Execute os seguintes comandos no diretório do projeto, `../trustion-digital-api`.

- Execução

```
mvn clean install spring-boot:run -Dspring.profiles.active=develop -Dmaven.test.skip=true
```

- Teste

```
mvn test
```

### Observações
- Caso falte alguma dependência, fale com um desenvolvedor.


## Tecnologias e Versões <a name="tecnologias"></a>
- JDK -> 1.8;
- Spring Boot -> 2.1.9.RELEASE;
