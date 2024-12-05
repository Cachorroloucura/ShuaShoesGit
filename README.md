# ShuaShoes - Sistema de Venda de Calçados
Este é um projeto de site para a venda de tênis de basquete. O sistema permite a visualização de produtos, cadastro de clientes, realização de compras e pagamento via Pix, além de oferecer funcionalidade de e conversão internacional de tamanhos.


Índice

Visão Geral

Tecnologias Utilizadas

Instalação

Estrutura do Projeto

Funcionalidades

Comandos no Terminal

Conexão com o Banco de Dados

Conexão com o Git

Conclusão

Visão Geral


O ShuaShoes é um site de e-commerce focado na venda de tênis de basquete. O projeto envolve as seguintes funcionalidades principais:


Exibição de produtos com filtros por tamanho, modelo e preço.

Cadastro de clientes e controle de dados pessoais.

Sistema de pagamento via Pix.

Rastreio de entregas.

Conversão de tamanhos de calçados de diferentes regiões.

Tecnologias Utilizadas

Frontend: HTML, CSS, JavaScript

Backend: Java

Banco de Dados: PostgreSQL

Controle de Versão: Git

Frameworks: Spring Boot (Backend), Thymeleaf (Frontend)

Ferramentas: Maven, IntelliJ IDEA

Instalação

Para rodar o projeto localmente, siga as etapas abaixo:

1. Clone o repositório
```
bash

git clone https://github.com/seu-usuario/shuashoes.git
cd shuashoes
````
2. Configuração do Banco de Dados
Crie um banco de dados no PostgreSQL chamado shuashoes.
Importe o esquema do banco de dados. O arquivo SQL está disponível no repositório.
```
bash

psql -U seu_usuario -d shuashoes -f schema.sql
```
3. Configuração do Ambiente
Adicione as credenciais do banco de dados no arquivo application.properties:
```
properties

spring.datasource.url=jdbc:postgresql://localhost:5432/shuashoes
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```
4. Build do Projeto
Use o Maven para compilar o projeto:
```
bash

mvn clean install
```
5. Rodar o Projeto
Inicie o servidor localmente:
```
bash


mvn spring-boot:run
```
Acesse o site em http://localhost:8080.

Estrutura do Projeto
A estrutura do projeto é organizada da seguinte maneira:
```
css

shuashoes/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── shuashoes/
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   └── static/
│   │   │       ├── css/
│   │   │       └── js/
│   │   │   └── templates/
│   └── test/
│       └── java/
│           └── com/
│               └── shuashoes/
├── pom.xml
└── README.md
```
Funcionalidades
O sistema ShuaShoes possui as seguintes funcionalidades principais:

Cadastro de Clientes: O cliente pode criar uma conta, editar seus dados e realizar login.
Visualização de Produtos: O cliente pode filtrar os produtos por categoria, tamanho, e preço.
Carrinho de Compras: O cliente pode adicionar produtos ao carrinho e finalizar a compra via Pix.
Rastreamento de Entregas: O cliente pode acompanhar o status de entrega de seus pedidos.
Conversão de Tamanhos: O sistema oferece conversão de tamanhos de calçados internacionais.
Comandos no Terminal
Rodando o Projeto
```
bash


mvn spring-boot:run
```
Migrando o Banco de Dados
```
bash

psql -U seu_usuario -d shuashoes -f schema.sql
```
Conexão com o Banco de Dados
A conexão com o banco de dados PostgreSQL é configurada no arquivo application.properties. Exemplo de configuração:
```
properties

spring.datasource.url=jdbc:postgresql://localhost:5432/shuashoes
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```
Conexão com o Git

Para começar a usar o Git no projeto, siga os comandos abaixo:

Inicializando o repositório Git
```
bash

git init
```
Adicionando os arquivos ao repositório
```
bash

git add .
```
Comitando as mudanças
```
bash

git commit -m "Primeiro commit"
```
Enviando as alterações para o repositório remoto
```
bash

git remote add origin https://github.com/seu-usuario/shuashoes.git
git push -u origin master
```
