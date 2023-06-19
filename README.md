
# Projeto de Comércio Eletrônico em Java

Este é um projeto de exemplo de um sistema básico de comércio eletrônico desenvolvido em Java. Ele permite que os usuários adicionem produtos ao estoque, adicionem produtos ao carrinho de compras, removam produtos do carrinho, exibam os produtos em estoque e no carrinho, e confirmem uma venda.

## Requisitos
- Java Development Kit (JDK) 8 ou superior
- MySQL Server

## Configuração do Banco de Dados

1. Crie um banco de dados chamado `ecommerce_db` no MySQL.
2. Execute o seguinte script SQL para criar a tabela de produtos:
```sql
CREATE TABLE products (

    id VARCHAR(20) PRIMARY KEY,
    
    name VARCHAR(100) NOT NULL,
    
    price DECIMAL(10,2) NOT NULL,
    
    quantity INT NOT NULL
);
```
Certifique-se de ter o servidor MySQL em execução e atualize as informações de conexão no código-fonte, se necessário.

## Configurando as Credenciais de Login do Banco de Dados
As credenciais de login do banco de dados são necessárias para estabelecer uma conexão bem-sucedida com o servidor MySQL. Siga as etapas abaixo para configurar as credenciais de login no código:
1. Abra o arquivo `Main.java` localizado no diretório `src` do projeto.
2. Procure o seguinte trecho no código:
   ```java
   javaConnection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_db", "user", "password");
4. Troque o "user" pelo nome de usuário do seu banco de dados e o "password" pela sua senha.
5. Salve as alterações no arquivo `Main.java`.

# Certifique-se de ter as dependências JDBC do MySQL configuradas no projeto.
Caso não tenha: 
 1. Acesse o site do MySQL Connector/J: https://dev.mysql.com/downloads/connector/j/
 2. Na página de downloads, role para baixo até encontrar a seção "Generally Available (GA) Releases". Lá, você encontrará várias versões disponíveis para download.
 3. Na página de downloads, role para baixo até encontrar a seção "Generally Available (GA) Releases". Lá, você encontrará várias versões disponíveis para download.
 4. Selecione a versão mais recente do MySQL Connector/J que seja compatível com sua versão do MySQL Server.
 5. Escolha a opção de download adequada para o seu sistema operacional. Por exemplo, se você estiver usando o Windows, escolha o arquivo JAR com um nome como mysql-connector-java-{version}.jar.
 6. Após o download, copie o arquivo JAR para o diretório do seu projeto Java.
 7. Em sua IDE Java, adicione o arquivo JAR ao classpath do projeto. Isso pode ser feito de diferentes maneiras, dependendo da IDE que você está usando. Aqui estão algumas instruções gerais para algumas IDEs populares:
 8. Eclipse: No Eclipse, clique com o botão direito do mouse no projeto, vá para "Build Path" e selecione "Configure Build Path". Na guia "Libraries", clique em "Add External JARs" e navegue até o arquivo JAR do Connector/J que você baixou.
 9. IntelliJ IDEA: No IntelliJ IDEA, clique com o botão direito do mouse no arquivo JAR, selecione "Add as Library" e escolha a opção apropriada para o seu projeto.
  Certifique-se de que o servidor MySQL esteja em execução e atualize as informações de conexão no código-fonte, se necessário.


# Executando o Projeto
1.Clone o repositório para o seu ambiente local.

2.Abra o projeto em sua IDE Java de preferência.

3.Certifique-se de que o servidor MySQL esteja em execução.

4.Execute a classe Main para iniciar o programa.

5.Siga as instruções no console para interagir com o sistema de comércio eletrônico.

# Funcionalidades
Adicionar um produto ao estoque.

Adicionar um produto ao carrinho de compras.

Remover um produto do carrinho de compras.

Exibir os produtos em estoque.

Exibir os produtos no carrinho de compras.

Confirmar uma venda.
