# ShuaShoes - Sistema de Venda de Calçados
Este é um projeto de site para a venda de tênis de basquete. O sistema permite a visualização de produtos, cadastro de clientes, realização de compras e pagamento via Pix, além de oferecer funcionalidade de e conversão internacional de tamanhos.


# Índice

Visão Geral

Tecnologias Utilizadas

Instalação

Estrutura do Projeto

Funcionalidades

Comandos no Terminal

Conexão com o Banco de Dados

Conexão com o Git

Conclusão


# Funcionalidades principais:


Cadastro de clientes e controle de dados pessoais.

Sistema de pagamento via Pix.

Conversão de tamanhos de calçados de diferentes regiões.



# Tecnologias Utilizadas

Frontend: HTML, CSS, JavaScript

Backend: Java

Banco de Dados: PostgreSQL

Controle de Versão: Git

Ferramentas: Maven, IntelliJ IDEA

Instalação

# Para rodar o projeto localmente, siga as etapas abaixo:

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
shuashoes/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── br/
│   │   │   │   └── com/
│   │   │   │       └── shuashoeswebapp/
│   │   │   │           └── Main.java
│   │   ├── dao/
│   │   │   ├── CategoriaDAO.java
│   │   │   ├── ClienteDAO.java
│   │   │   ├── ItensPedidosDAO.java
│   │   │   ├── PagamentoDAO.java
│   │   │   ├── PedidoDAO.java
│   │   │   └── ProdutoDAO.java
│   │   ├── infra/
│   │   │   └── ConexaoBanco.java
│   │   ├── model/
│   │   │   ├── Categoria.java
│   │   │   ├── Cliente.java
│   │   │   ├── ItensPedido.java
│   │   │   ├── Pagamento.java
│   │   │   ├── Pedido.java
│   │   │   └── Produto.java
│   ├── resources/
│   │   └── Script.sql
│   ├── webapp/
│   │   └── WEB-INF/
│   │       └── index.jsp
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
# Regras de Negócio - ShuaShoes 🏀👟

Bem-vindo ao documento oficial das regras de negócio da **ShuaShoes**, uma loja virtual especializada em produtos de basquete.  

Nosso objetivo é oferecer uma experiência transparente, prática e segura para nossos clientes, com processos claros e bem definidos.  

---

## **Regras de Negócio**  

### **1. Cadastro de Clientes**  
- Clientes devem se cadastrar para realizar compras, informando dados obrigatórios como nome completo, e-mail válido, CPF, endereço e telefone.  
- O sistema deve validar o CPF e o formato do e-mail no momento do cadastro.  

### **2. Catálogo de Produtos**  
- Todos os produtos devem conter descrições detalhadas, incluindo:  
  - Tamanho (ex.: tênis, camisetas).  
  - Material de fabricação.  
  - Preço e descontos aplicáveis.  
  - Disponibilidade de estoque.  
- Produtos devem ser exibidos com imagens de alta qualidade, mostrando múltiplos ângulos.  
- O site deve permitir a busca por tipo de produto (tênis, bolas, roupas), marca, preço e tamanho.  

### **3. Gestão de Estoque**  
- Não será permitido a venda de itens fora de estoque.  
- Estoques devem ser atualizados em tempo real com base nas vendas.  

### **4. Política de Preços e Promoções**  
- O preço final deve incluir todos os custos, como impostos e frete, antes de o cliente finalizar o pedido.  
- Promoções devem ter regras claras, incluindo prazo de validade e quantidade máxima por cliente.  

### **5. Política de Pagamento**  
- Aceitar pagamentos por cartão de crédito, débito, PIX e boleto bancário.  
- Oferecer parcelamento no cartão de crédito, com ou sem juros, dependendo do valor total da compra.  
- Pedidos só serão processados após a confirmação do pagamento.  

### **6. Política de Entrega**  
- O prazo estimado deve ser exibido antes da finalização do pedido, variando conforme a localização do cliente.  
- Oferecer frete grátis para compras acima de um valor mínimo (ex.: R$300).  
- Clientes devem receber um código de rastreamento após o envio.  

### **7. Política de Trocas e Devoluções**  
- O cliente pode solicitar devoluções ou trocas em até 30 dias após o recebimento, caso o produto esteja em perfeitas condições.  
- Produtos com defeitos de fabricação poderão ser devolvidos ou trocados sem custo adicional.  
- O frete da primeira troca será gratuito; trocas adicionais podem ter custo para o cliente.  

### **8. Atendimento ao Cliente**  
- Atendimento ao cliente deve ser oferecido via chat online, e-mail e telefone.  
- Responder solicitações de clientes em até 24 horas úteis.  

### **9. Segurança e Privacidade**  
- Informações dos clientes devem ser protegidas de acordo com a LGPD.  
- O site deve usar criptografia SSL para proteger transações e dados sensíveis.  

### **10. Fidelização de Clientes**  
- Implementar um sistema de pontos que pode ser trocado por descontos ou brindes.  
- Enviar e-mails com promoções e novidades para clientes cadastrados (mediante consentimento).  

---

## **Contribuição**  
Se você tem sugestões para melhorar nossas regras de negócio, fique à vontade para contribuir!  

---

## **Licença**  
Este documento está licenciado sob a [MIT License](./LICENSE).  

