create DATABASE IF NOT EXISTS ShuaShoesBD2


-- Tabela Categoria
CREATE TABLE IF NOT EXISTS Categoria (
    ID_Categoria INT PRIMARY KEY AUTO_INCREMENT,
    Nome_Categoria VARCHAR(100) NOT NULL,
    Descricao TEXT
    );

-- Tabela Cliente
CREATE TABLE IF NOT EXISTS Cliente (
    ID_Cliente INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(255) NOT NULL,
    CPF VARCHAR(14) NOT NULL UNIQUE,
    Email VARCHAR(255) NOT NULL UNIQUE,
    Telefone VARCHAR(20),
    Endereço VARCHAR(255),
    Data_Nascimento DATE,
    Genero VARCHAR(50),
    Data_Cadastro DATE NOT NULL DEFAULT CURRENT_DATE,
    Preferencias TEXT,
    Historico_Compras TEXT
    );

-- Tabela Produto
CREATE TABLE IF NOT EXISTS Produto (
    ID_Produto INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(255) NOT NULL,
    Marca VARCHAR(100) NOT NULL,
    Tamanho VARCHAR(10) NOT NULL,
    Cor VARCHAR(50),
    Preco DECIMAL(10, 2) NOT NULL,
    Estoque INT NOT NULL,
    ID_Categoria INT,
    FOREIGN KEY (ID_Categoria) REFERENCES Categoria(ID_Categoria)
    );

-- Tabela Pedido
CREATE TABLE IF NOT EXISTS Pedido (
    ID_Pedido INT PRIMARY KEY AUTO_INCREMENT,
    ID_Cliente INT NOT NULL,
    Data_Pedido DATE NOT NULL DEFAULT CURRENT_DATE,
    Valor_Total DECIMAL(10, 2) NOT NULL,
    Status VARCHAR(15) NOT NULL,
    FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID_Cliente)
    );

-- Tabela Itens_Pedido
CREATE TABLE IF NOT EXISTS Itens_Pedido (
    ID_Item INT PRIMARY KEY AUTO_INCREMENT,
    ID_Pedido INT NOT NULL,
    ID_Produto INT NOT NULL,
    Quantidade INT NOT NULL,
    Preco_Unitario DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (ID_Pedido) REFERENCES Pedido(ID_Pedido),
    FOREIGN KEY (ID_Produto) REFERENCES Produto(ID_Produto)
    );

-- Tabela Pagamento
CREATE TABLE IF NOT EXISTS Pagamento (
    ID_Pagamento INT PRIMARY KEY AUTO_INCREMENT,
    ID_Pedido INT NOT NULL,
    Metodo_Pagamento VARCHAR(50) NOT NULL,
    Valor_Pago DECIMAL(10, 2) NOT NULL,
    Data_Pagamento DATE NOT NULL DEFAULT CURRENT_DATE,
    FOREIGN KEY (ID_Pedido) REFERENCES Pedido(ID_Pedido)
    );
