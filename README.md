# Sistema de Gestão de Clientes

## Descrição

Este projeto implementa um sistema simples de gestão de clientes em Java. Ele permite cadastrar, listar, buscar e atualizar informações de clientes (nome e telefone). Os dados são salvos e carregados automaticamente de um arquivo `.txt` em um diretório específico, garantindo a persistência entre execuções do programa.

## Funcionalidades

- **Cadastrar Cliente:** Adiciona um novo cliente com nome e telefone.
- **Listar Clientes:** Exibe todos os clientes cadastrados.
- **Buscar Cliente pelo Nome:** Localiza um cliente pelo nome informado.
- **Atualizar Cliente:** Permite modificar os dados de um cliente existente.
- **Salvar e carregar dados:** Os dados são persistidos em arquivo texto (`cliente.txt`), garantindo que as informações não sejam perdidas após encerrar o programa.

## Como usar

1. Compile o código Java.
2. Execute o programa.
3. No menu, escolha a opção desejada digitando o número correspondente.
4. Ao sair (opção 5), os dados serão salvos automaticamente no arquivo definido.

## Local de armazenamento do arquivo

Por padrão, o arquivo `cliente.txt` será salvo e carregado do caminho configurado no código, exemplo:

